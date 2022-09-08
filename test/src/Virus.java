import java.util.*;
import java.io.*;

public class Virus {
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    static boolean[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        graph = new boolean[N+1][N+1];
        st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());

        for(int i = 0; i < node; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }

        int count = -1;
        visited[1] = true;
        q.offer(1);
        while(!q.isEmpty()) {
			
			int V = q.poll();
            count ++;
			
			for(int i = 1 ; i <= N ; i++) {
				if(graph[V][i] && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
        System.out.println(count);
    }
}
