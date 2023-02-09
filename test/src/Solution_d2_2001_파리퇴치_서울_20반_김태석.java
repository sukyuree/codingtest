import java.util.*;
import java.io.*;

public class Solution_d2_2001_파리퇴치_서울_20반_김태석{
    
    static int[][] board;
    static int N,M,MAX;
    static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            MAX = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            kill(0,0,0);
            sb.append("#").append(t).append(" ").append(MAX).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void kill(int x,int y, int sum){
        MAX = Math.max(MAX,sum);
        if(x+M==N+1||y+M==N+1){
            return;
        }
        int killed = 0;
        for(int i = y; i < y+M; i++){
            for(int j = x; j < x+M; j++){
                killed += board[i][j];
            }
        }
        kill(x+1,y,killed);
        kill(x,y+1,killed);
    }
}