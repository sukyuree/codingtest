import java.util.*;
import java.io.*;

public class Main_bj_2096_내려가기 {
  static int N;
  static int[][] dpMax;
  static int[][] dpMin;
  static int max0,max1,max2, min0,min1,min2;
  static int[][] chart;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    chart = new int[N + 1][3];
    dpMax = new int[N + 1][3];
    dpMin = new int[N + 1][3];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        chart[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dpMax[1][0] = chart[1][0];
    dpMax[1][1] = chart[1][1];
    dpMax[1][2] = chart[1][2];

    dpMin[1][0] = chart[1][0];
    dpMin[1][1] = chart[1][1];
    dpMin[1][2] = chart[1][2];

    for (int i = 2; i <= N; i++) {
      dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + chart[i][0];
      dpMax[i][1] = Math.max(dpMax[i - 1][0], Math.max(dpMax[i - 1][1], dpMax[i - 1][2])) + chart[i][1];
      dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + chart[i][2];

      dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + chart[i][0];
      dpMin[i][1] = Math.min(dpMin[i - 1][0], Math.min(dpMin[i - 1][1], dpMin[i - 1][2])) + chart[i][1];
      dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + chart[i][2];
    }

    //sb.append(Math.max(max0, Math.max(max1, max2))).append(" ").append(Math.min(min0, Math.min(min1, min2)));
    sb.append(Math.max(dpMax[N][0], Math.max(dpMax[N][1], dpMax[N][2]))).append(" ").append(Math.min(dpMin[N][0], Math.min(dpMin[N][1], dpMin[N][2])));
    System.out.print(sb.toString());
  }
}
