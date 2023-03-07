import java.io.*;
import java.util.*;

public class Main_bj_10026_적록색약_서울_20반_김태석 {
    static int N;
    static char[][] map;
    static boolean[][] visited1, visited2;
    static int count1,count2;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(!visited1[i][j]){bfsV1(i,j); count1++;}
                if(!visited2[i][j]){bfsV2(i,j); count2++;}
            }
        }
        System.out.print(count1+" "+count2);
    }

    static void bfsV1(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        char RGB = map[i][j];
        visited1[i][j] = true;
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<N
                && !visited1[ny][nx]
                && map[ny][nx] == RGB){
                    q.offer(new int[]{ny,nx});
                    visited1[ny][nx] = true;
                }
            }
        }
    }
    static void bfsV2(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        char RGB = map[i][j];
        visited2[i][j] = true;
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<N
                && !visited2[ny][nx]
                && (map[ny][nx] == RGB
                || map[ny][nx]+11==RGB
                || map[ny][nx]-11==RGB)){
                    q.offer(new int[]{ny,nx});
                    visited2[ny][nx] = true;
                }
            }
        }
    }
}
