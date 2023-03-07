import java.util.*;
import java.io.*;

public class Main_bj_2146_다리만들기_서울_20반_김태석 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int paint = 2;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //영역 구별
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    bfsForSearch(i,j);
                }
            }
        }
        //최소값 구하기.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j]!=0){
                    //System.out.println(i+" "+j);
                    visited = new boolean[N][N];
                    bfsForFind(i,j,map[i][j]);
                }
            }
        }
        System.out.print(min);
    }

    static void bfsForSearch(int i, int j){
        visited = new boolean[N][N];
        visited[i][j] = true;
        map[i][j] = paint;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<N
                &&!visited[ny][nx]&&map[ny][nx]==1){
                    map[ny][nx] = paint;
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }   
        }
        paint++;
    }
    static void bfsForFind(int i, int j, int color){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j,0});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];
            int cnt = polled[2];

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<N
                &&!visited[ny][nx] && map[ny][nx] == 0){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx,cnt+1});
                }
                else if(ny>=0&&ny<N&&nx>=0&&nx<N
                && map[ny][nx] != 0 && map[ny][nx] != color){
                    min = Math.min(min,cnt);
                }
            }
        }
    }
}
