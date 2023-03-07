import java.io.*;
import java.util.*;

public class Solution_d4_1219_길찾기_서울_20반_김태석 {
    static boolean[] visited;
    static boolean[][] graph;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            visited = new boolean[100];
            graph = new boolean[100][100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                graph[y][x] = true;
            }
            sb.append("#"+t+" " ).append(bfs() ? 1:0).append("\n");
        }
        System.out.print(sb.toString());
    }

    static boolean bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        for(int j = 0; j < 100; j++){
            if(graph[0][j]){
                q.offer(j);
                visited[j] = true;
            }
        }
        while(!q.isEmpty()){
            int ny = q.poll();

            if(ny == 99) return true;
            
            for(int j = 0; j < 100; j++){
                if(graph[ny][j]&&!visited[j]){
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
        return false;
    }
}
