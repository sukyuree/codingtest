import java.io.*;
import java.util.*;

public class Main_2559_수열 {
  static int N, K;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] T = new int[N];
    for (int i = 0; i < N; i++) {
      T[i] = Integer.parseInt(st.nextToken());
    }
    slidingWindow(T);
    System.out.println(max);
  }

  static void slidingWindow(int[] T) {
    int sum = 0;
    for (int i = 0; i < K; i++) {
      sum += T[i];
    }
    max = sum;

    int out = 0;
    for (; out + K < N; out++) {
      int in = out + K;
      sum -= T[out];
      sum += T[in];
      max = Math.max(sum, max);
    }
  }
}
