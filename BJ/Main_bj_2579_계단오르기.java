import java.io.*;
import java.util.*;

public class Main_bj_2579_계단오르기 {
  static int N;
  static int[] arr, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[301];
    dp = new int[301];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];

    for (int i = 3; i <= N; i++) {
      dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
    }

    System.out.print(dp[N]);
  }
}
