import java.io.*;
import java.util.*;

public class Main_bj_9251_LCS {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] s1 = br.readLine().toCharArray();
    char[] s2 = br.readLine().toCharArray();

    int N = s1.length;
    int M = s2.length;

    int[][] dp = new int[N][M];
    if (s1[0] == s2[0])
      dp[0][0]++;

    for (int i = 1; i < N; i++) {
      dp[i][0] = dp[i - 1][0];
      if (s1[i] == s2[0] && dp[i][0] == 0)
        dp[i][0] = 1;
    }

    for (int i = 1; i < M; i++) {
      dp[0][i] = dp[0][i - 1];
      if (s2[i] == s1[0] && dp[0][i] == 0)
        dp[0][i] = 1;
    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        if (s1[i] == s2[j])
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    System.out.print(dp[N - 1][M - 1]);
  }
}
