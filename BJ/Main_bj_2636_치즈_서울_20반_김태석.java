import java.util.*;
import java.io.*;

public class Main_bj_2636_치즈_서울_20반_김태석 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N,M;
    static boolean[][] visited;
    static int[][] map;
    static int count,last;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) count++;
            }
        }

        int t = 0;
        while(count>0){
            t++;
            bfs();
        }
        sb.append(t).append("\n").append(last);
        System.out.print(sb.toString());
    }

    static void bfs(){
        visited = new boolean[N][M];
        last = count;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny>=0&&ny<N&&nx>=0&&nx<M&&!visited[ny][nx]){
                    if(map[ny][nx]==1){
                        map[ny][nx] = 0;
                        count--;
                    }
                    else q.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
