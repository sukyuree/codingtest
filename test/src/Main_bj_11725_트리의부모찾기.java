import java.io.*;
import java.util.*;

public class Main_bj_11725_트리의부모찾기 {
    static int N;
    static int[] nP;
    static List<Integer>[] node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        node = new List[N+1];
        for(int i = 1; i <= N; i++){
            node[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        nP = new int[N+1];

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);

        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) sb.append(nP[i]).append("\n");
        System.out.print(sb.toString());
    }

    public static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int polled = q.poll();
            for(int i = 0; i < node[polled].size(); i++){
                int n = node[polled].get(i);
                if(!visited[n]){
                    nP[n] = polled;
                    q.offer(n);
                    visited[n] = true;
                }
            }
        }
    }
}
