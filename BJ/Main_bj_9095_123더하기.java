import java.io.*;

public class Main_bj_9095_123더하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb.toString());
    }
}