import java.util.*;
import java.io.*;

public class Solution_5656_벽돌깨기_서울_20반_김태석 {
    static int N,W,H;
    static int[][] map;
    static int[][] temp;
    static int[] p;
    static boolean[][] visitedForBfs;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            min = Integer.MAX_VALUE;
            p = new int[N];

            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            perm(0);
            
            sb.append("#"+t+" ").append(min).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void perm(int cnt){
        if(cnt == N){
            temp = mapCopy();
            for(int i = 0; i < N; i++){
                bfs(p[i]);
            }
            min = Math.min(min,count());
            
            return;
        }
        for(int i = 0; i < W; i++){
            p[cnt] = i;
            perm(cnt+1);
        }
    }

    //벽돌 부수기
    static void bfs(int j){
        visitedForBfs = new boolean[H][W];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < H; i++){
            if(temp[i][j]!=0){
                q.offer(new int[]{i,j});
                visitedForBfs[i][j] = true;
                break;
            }
        }

        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];
            int range = temp[y][x];

            for(int r = 0; r < range; r++){
                for(int d = 0; d < 4; d++){
                    int ny = (y + r*dy[d]);
                    int nx = (x + r*dx[d]);
                    if(ny>=0&&ny<H&&nx>=0&&nx<W
                    &&temp[ny][nx]!=0&&!visitedForBfs[ny][nx]){
                        visitedForBfs[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
        for(int i = 0; i < H; i++){
            for(int k = 0; k < W; k++){
                if(visitedForBfs[i][k]){
                    temp[i][k] = 0;
                }
            }
        }
        sort();
    }

    //벽돌 정렬하기
    static void sort(){
        for(int j = 0; j < W; j++){
            Queue<Integer> q = new ArrayDeque<>();
            for(int i = H-1; i >= 0; i--){
                if(temp[i][j] != 0){
                    q.offer(temp[i][j]);
                }
            }
            for(int i = H-1; i >= 0; i--){
                temp[i][j] = (!q.isEmpty()) ? q.poll():0; 
            }
        }
    }

    static int count(){
        int count = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(temp[i][j]!=0) count++;
            }
        }
        return count;
    }

    static int[][] mapCopy(){
        int[][] temp = new int[H][W];
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
}
