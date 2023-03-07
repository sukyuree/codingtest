import java.io.*;
import java.util.*;

public class Solution_d4_Contact_서울_20반_김태석 {
    static int N, start, max;
    static int[] visited;
    static boolean[][] graph;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 10; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph = new boolean[101][101];
            visited = new int[101];
            max = Integer.MIN_VALUE;

            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = true;
            }
            q.offer(start);
            visited[start] = 1;
            bfs(start);
            sb.append("#"+t+" ").append(findMaxValue()).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void bfs(int start){

        while(!q.isEmpty()){
            int polled = q.poll();
            for(int i = 1; i <= 100; i++){
                if(graph[polled][i]&&(visited[i]==0||visited[i]==visited[polled]+1)){
                    q.offer(i);
                    visited[i] = visited[polled]+1;
                    max = visited[i];
                }
            }
        }
    }
  

    static int findMaxValue(){
        int answer = 0;
        for(int i = 1; i <= 100; i++){
            if(visited[i]==max) answer = Math.max(answer,i);
        }
        return answer;
    }
}
