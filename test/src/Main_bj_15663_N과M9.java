import java.io.*;
import java.util.*;

public class Main_bj_15663_N과M9 {
    static int N,M;
    static int[] a,b;
    static boolean[] visited;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        b = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        perm(0);
        Iterator<String> it = ans.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()) sb.append(it.next()).append("\n");
        System.out.print(sb.toString());
    }

    static void perm(int cnt){
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for(int i : b) sb.append(i).append(" ");
            ans.add(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            b[cnt] = a[i];
            perm(cnt+1);
            visited[i]=false;
        }
    }
}
