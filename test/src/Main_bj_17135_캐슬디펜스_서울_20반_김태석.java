import java.io.*;
import java.util.*;

public class Main_bj_17135_캐슬디펜스_서울_20반_김태석 {
    static int N,M,D;
    static int[][] map;
    static int[][] tempMap;
    static boolean[][] visited;
    static boolean[][] target;
    static int count, max;
    static int archerY;
    static int[] dx = {-1,0,1};
    static int[] dy = {0,-1,0};
    static int[] archers = new int[3];
    static int mostFarEnemy;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tempMap = new int[N][M];
        target = new boolean[N][M];
        archerY = N;

        boolean flag = false;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                tempMap[i][j] = map[i][j];
                if(map[i][j] == 1&&!flag){
                    mostFarEnemy=N-i;
                    flag = true;
                }
            }
        }
        comb(0,0);
        System.out.print(max);
    }

    static void comb(int cnt, int start){
        if(cnt == 3){
            count = 0;
            gameStart(archers[0],archers[1],archers[2]);
            max = Math.max(max,count);
            mapCopy();
            return;
        }
        for(int i = start; i < M; i++){
            archers[cnt] = i;
            comb(cnt+1,i+1);
        }
    }

    static void gameStart(int archerX1, int archerX2, int archerX3){
        for(int g = 1; g <= mostFarEnemy; g++){
            kill(archerX1);
            kill(archerX2);
            kill(archerX3);
            count();
            enemyMove();
        }
    }

    static void enemyMove(){
        for(int i = N-2; i >= 0; i--){
            for(int j = 0; j < M; j++){
                map[i+1][j] = map[i][j];
            }
        }
        for(int j = 0; j < M; j++) map[0][j] = 0;
    }

    static void count(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(target[i][j]){
                    map[i][j] = 0;
                    count++;
                    target[i][j] = false;
                }
            }
        }
    }

    static void kill(int archerX){
        visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        if(map[archerY-1][archerX]==1){
            target[archerY-1][archerX] = true;
            return;
        }
        else{
            q.offer(new int[]{archerY-1,archerX});
            visited[archerY-1][archerX] = true;
        }
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];
            for(int d = 0; d < 3; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<M&&!visited[ny][nx]){
                    if(map[ny][nx]==1&&(Math.abs(ny-archerY)+Math.abs(nx-archerX))<=D){
                        target[ny][nx] = true;
                        return;
                    }
                    else if(Math.abs(ny-archerY)+Math.abs(nx-archerX)<=D){
                        q.offer(new int[]{ny,nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    static void mapCopy(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = tempMap[i][j];
            }
        }
    }
}
