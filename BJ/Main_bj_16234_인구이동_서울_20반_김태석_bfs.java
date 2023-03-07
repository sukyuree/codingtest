import java.util.*;
import java.io.*;

public class Main_bj_16234_인구이동_서울_20반_김태석_bfs {
    static int N,L,R;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int min,max;
    static int count = 0;
    static int sum = 0;
    static int answer = 0;
    static boolean isChanged;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        arr = new int[N][N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,arr[i][j]);
                min = Math.min(min,arr[i][j]);
            }
        }
        
        while(true){
            visited = new boolean[N][N];
            isChanged = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    sum = 0;
                    count = 0;
                    if(!visited[i][j]){
                        bfs(i,j);
                    }
                }
            }
        
            if(!isChanged) break;
            answer++;
        }

        System.out.println(answer);
    }

    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> tempQ = new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        tempQ.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[] polled = q.poll();
            sum += arr[polled[0]][polled[1]];
            count++;
            for(int d = 0; d < 4; d++){
                int ny = polled[0]+dy[d];
                int nx = polled[1]+dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<N
                && Math.abs(arr[polled[0]][polled[1]]-arr[ny][nx])>=L
                && Math.abs(arr[polled[0]][polled[1]]-arr[ny][nx])<=R
                &&!visited[ny][nx]){
                    q.offer(new int[]{ny,nx});
                    tempQ.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                    isChanged = true;
                }
            }
        }
        while(!tempQ.isEmpty()){
            int[] polled = tempQ.poll();
            arr[polled[0]][polled[1]] = sum/count;
        }
    }
}
