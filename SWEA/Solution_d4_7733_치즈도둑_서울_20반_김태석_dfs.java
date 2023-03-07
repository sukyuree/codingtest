import java.io.*;
import java.util.*;

public class Solution_d4_7733_치즈도둑_서울_20반_김태석_dfs {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int max;
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
                visited = new boolean[N+1][N+1];
                count = 0;
                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= N; j++){
                        if(!visited[i][j]&&board[i][j]>d){
                            dfs(i,j,d);
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                }
            }
            
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void dfs(int y, int x, int n){
        if(visited[y][x]||board[y][x]<=n) return;

        visited[y][x] = true;

        for(int d = 0; d < 4; d++){
            int ny = y+dy[d];
            int nx = x+dx[d];
            if(ny>0&&ny<=N && nx>0&&nx<=N && !visited[ny][nx] && board[ny][nx] > n) dfs(ny,nx,n);
        }
    }
}