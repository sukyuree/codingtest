import java.util.*;
import java.io.*;

public class Main_bj_4963_섬의개수_서울_20반_김태석 {
    static int w,h,count;
    static int[][] map;
    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,-1,0,1,-1,1,1,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0&&h==0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j]==1&&!visited[i][j]) bfs(i,j);
                }
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static void bfs(int i,int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];

            for(int d = 0; d < 8; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny>=0&&ny<h&&nx>=0&&nx<w
                && !visited[ny][nx] && map[ny][nx] == 1){
                    q.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
        count++;
    }
}
