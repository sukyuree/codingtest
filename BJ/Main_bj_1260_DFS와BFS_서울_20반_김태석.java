import java.util.*;
import java.io.*;

public class Main_bj_1260_DFS와BFS_서울_20반_김태석 {
    static boolean[] visitedForDFS;
    static boolean[] visitedForBFS;
    static boolean[][] graph;

    static int N,M,V;

    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visitedForBFS = new boolean[N+1];
        visitedForDFS = new boolean[N+1];
        graph = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = true;
        }
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
    
    static void dfs(int V){
        visitedForDFS[V] = true;
        sb.append(V).append(" ");
        for(int i = 1; i <= N; i++){
            if(graph[V][i] && !visitedForDFS[i]) dfs(i);
        }
    }

    static void bfs(int V){
        visitedForBFS[V] = true;
        q.offer(V);

        while(!q.isEmpty()) {
			
			V = q.poll();
			sb.append(V).append(" ");
			
			for(int i = 1 ; i <= N ; i++) {
				if(graph[V][i] && !visitedForBFS[i]) {
					q.offer(i);
					visitedForBFS[i] = true;
				}
			}
		}
    }
}
