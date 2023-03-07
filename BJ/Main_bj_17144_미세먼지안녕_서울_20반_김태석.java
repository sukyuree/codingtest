import java.util.*;
import java.io.*;

public class Main_bj_17144_미세먼지안녕_서울_20반_김태석 {
    static int R,C,T;
    static int[][] map;
    static int[][] tempMap;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<int[]> q;
    static List<int[]> cleanerXY;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        cleanerXY = new ArrayList<>();

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) cleanerXY.add(new int[]{i,j});
            }
        }
        // T동안 반복.
        for(int t = 1; t <= T; t++){
            q = new ArrayDeque<>();
            // 배열 전체 돌면서 현재 미세먼지 있는 곳 확인해서 q에 넣기
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j]!=0&&map[i][j]!=-1) q.offer(new int[]{i,j});
                }
            }
            // bfs로 확신시키기.
            bfs();
            // 공기청정기로 순환시키기.
            refresh();
        }
        // 공기청정기는 -1,-1 두개니까 시작값을 2로.
        int sum = 2;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sum += map[i][j];
            }
        }
        System.out.print(sum);
    }
    static void bfs(){
        tempMap = new int[R][C];
        // 동시에 확산이므로 임시맵에 확산량 저장.
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0]; int x = polled[1];
            int dust = map[y][x];
            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<R&&nx>=0&&nx<C
                 &&map[ny][nx]!=-1){
                    tempMap[ny][nx] += dust/5;
                    map[y][x] -= dust/5;
                }
            }
        }
        // 임시맵에 저장된거 합쳐주기.
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                map[i][j] += tempMap[i][j];
            }
        }
    }
    static void refresh(){
        int uy = cleanerXY.get(0)[0];
        int ux = cleanerXY.get(0)[1];
        
        for(int i = uy; i > 0; i--) map[i][0] = map[i-1][0];
        for(int j = 0; j < C-1; j++) map[0][j] = map[0][j+1];
        for(int i = 0; i < uy; i++) map[i][C-1] = map[i+1][C-1];
        for(int j = C-1; j > 0; j--) map[uy][j] = map[uy][j-1];

        int dy = cleanerXY.get(1)[0];
        int dx = cleanerXY.get(1)[1];

        for(int i = dy; i < R-1; i++) map[i][0] = map[i+1][0];
        for(int j = 0; j < C-1; j++) map[R-1][j] = map[R-1][j+1];
        for(int i = R-1; i > dy; i--) map[i][C-1] = map[i-1][C-1];
        for(int j = C-1; j > 0; j--) map[dy][j] = map[dy][j-1];

        map[uy][ux] = -1;
        map[dy][dx] = -1;
        map[uy][ux+1] = 0;
        map[dy][dx+1] = 0;
    }

}
