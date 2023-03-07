import java.util.*;
import java.io.*;

public class Main_bj_1149_RGB거리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];
        int[][] arr = new int[N+1][3];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        for(int i = 2; i <= N; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+arr[i][2];
        }

        int min = Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2]));
        System.out.print(min);
    }
}
