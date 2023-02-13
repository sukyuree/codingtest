import java.io.*;
import java.util.*;

public class Solution_d4_7733_치즈도둑_서울_20반_bfs {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int max;
    static ArrayDeque<int[]> q;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            board = new int[N+1][N+1];
            int maxDay = Integer.MIN_VALUE;
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = Math.max(maxDay,board[i][j]);
                }
            }
            max = Integer.MIN_VALUE;
            for(int d = 0; d <= maxDay; d++){
                q = new ArrayDeque<>();
                visited = new boolean[N+1][N+1];
                count = 0;
                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= N; j++){
                        if(!visited[i][j]&&board[i][j]>d){
                            bfs(i,j,d);
                            count++;
                        }
                    }
                }
                max = Math.max(max,count);
            }
            
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void bfs(int i, int j, int n){
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] popped = q.poll();
            for(int d = 0; d < 4; d++){
                int ny = popped[0]+dy[d];
                int nx = popped[1]+dx[d];
                if(ny>0&&ny<=N && nx>0&&nx<=N && !visited[ny][nx] && board[ny][nx] > n){
                    q.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}