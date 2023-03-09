import java.io.*;

public class Main_bj_9461_파도반수열 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    long[] dp = new long[101];
    dp[1] = 1L;
    dp[2] = 1L;
    dp[3] = 1L;
    dp[4] = 2L;
    dp[5] = 2L;

    for (int i = 6; i <= 100; i++) {
      dp[i] = dp[i - 2] + dp[i - 3];
    }
    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      sb.append(dp[N]).append("\n");
    }
    System.out.print(sb.toString());
  }
}
