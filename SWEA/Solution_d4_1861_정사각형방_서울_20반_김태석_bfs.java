import java.io.*;
import java.util.*;

public class Solution_d4_1861_정사각형방_서울_20반_김태석_bfs {
    static int N, max, index, count, min;
    static int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());

            max = Integer.MIN_VALUE;
            index = Integer.MAX_VALUE;
            board = new int[N+1][N+1];
    
            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j = 1; j <= N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N+1][N+1];
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(!visited[i][j]){
                        count = 0;
                        min = Integer.MAX_VALUE;
                        bfs(i, j);
                    }
                }
            }
            sb.append("#").append(t).append(" ")
              .append(index).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void bfs(int i, int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{j,i});
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int currentNum = board[polled[1]][polled[0]];
            min = Math.min(min,currentNum);
            visited[polled[1]][polled[0]] = true;
            for(int d = 0; d < 4; d++){
                int nx = polled[0]+dx[d];
                int ny = polled[1]+dy[d];
                if((nx>0&&nx<=N&&ny>0&&ny<=N&&!visited[ny][nx])
                 &&(board[ny][nx]==currentNum+1||board[ny][nx]==currentNum-1)){
                    q.offer(new int[]{nx,ny});
                 }
            }
            count++;
        }
        if(max < count) index = min;
        else if(max == count) index = Math.min(index,min);
        max = Math.max(max,count);
    }
}
