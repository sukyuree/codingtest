import java.io.*;
import java.util.*;

public class Main_bj_15666_N과M12 {
    static int N,M;
    static int[] a,b;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        a = new int[set.size()];
        b = new int[M];
        N = set.size();
        Iterator<Integer> it = set.iterator();
        for(int i = 0; i < set.size(); i++){
            a[i] = it.next();
        }     
        Arrays.sort(a);

        comb(0,0);

        System.out.print(sb.toString());
    }

    static void comb(int cnt, int start){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < N; i++){
            b[cnt] = a[i];
            comb(cnt+1, i);
        }
    }
}
