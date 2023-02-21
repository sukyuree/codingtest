import java.io.*;
import java.util.*;

public class Main_bj_1012_유기농배추 {
    static int[][] map;
    static int N,M,count;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            int K = Integer.parseInt(st.nextToken());
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j]&&map[i][j]==1){
                        bfs(i,j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void bfs(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<M
                && !visited[ny][nx]
                && map[ny][nx] == 1){
                    q.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
        count++;
    }
}
