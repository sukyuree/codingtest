import java.io.*;
import java.util.*;

public class Main_bj_11724_연결요소의개수 {
    static boolean[][] map;
    static boolean[] visited;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = true;
            map[x][y] = true;
        }
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.print(count);
    }

    static void bfs(int i){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int polled = q.poll();
            for(int k = 1; k <= N; k++){
                if(!visited[k]&&map[polled][k]){
                    visited[k] = true;
                    q.offer(k);
                }
            }
        }
    }
}
