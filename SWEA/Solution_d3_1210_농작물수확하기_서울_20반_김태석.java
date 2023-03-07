import java.util.*;
import java.io.*;

public class Solution_d3_1210_농작물수확하기_서울_20반_김태석 {
    static int[][] board;
    static int N;
    static int sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            board = new int[N+1][N+1];
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine(),"1|2|3|4|5|6|7|8|9|0",true);
                for(int j = 1; j <= N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            calRevenue();
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void calRevenue(){
        sum = 0;
        int mid = (N/2)+1;
        int increase = 0;
        for(int i = 1; i <= N; i++){
            if(i < mid){
                for(int j=mid-increase; j <= mid+increase; j++){
                    sum+=board[i][j];
                }
                increase++;
            }
            else{
                for(int j = mid-increase; j<= mid+increase; j++){
                    sum+=board[i][j];
                }
                increase--;
            }
        }
    }
}
