import java.io.*;
import java.util.*;

public class Main_bj_4485_녹색옷입은애가젤다지_서울_20반_김태석 {
    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int startX,startY,endX,endY;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            startX = startY = 0;
            endX = endY = N-1;
            min = Integer.MAX_VALUE;
            bfs();
            sb.append("Problem "+count+": "+min+"\n");
            count++;
        }
        
        
        System.out.println(sb.toString());
    }

    static void bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[2]-p2[2]);
        pq.offer(new int[]{startY,startX,map[startY][startX]});
        dist[startY][startX] = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int y = polled[0];
            int x = polled[1];
            int w = polled[2];

            if(visited[y][x]) continue;

            if(y == endY && x == endX){
                min = w;
                break;
            }

            visited[y][x] = true;

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny>=0&&ny<N&&nx>=0&&nx<N
                &&!visited[ny][nx]&&dist[ny][nx] > map[ny][nx] + w){
                    dist[ny][nx] = map[ny][nx] + w;
                    pq.offer(new int[]{ny,nx,dist[ny][nx]});
                }
            }

        }
    }
}
