import java.util.*;
import java.io.*;

public class Main_bj_14938_서강그라운드 {
  static int N, M, R;
  static int[][] graph;
  static int[] items;
  static final int INF = 987654321;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    graph = new int[N + 1][N+1];
    items = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      items[i] = Integer.parseInt(st.nextToken());
      for (int j = 1; j <= N; j++) {
        graph[i][j] = INF;
      }
      graph[i][i] = 0;
    }

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph[from][to] = weight;
      graph[to][from] = weight;

    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
      int count = 0;
      for (int j = 1; j <= N; j++) {
        if (graph[i][j] <= M)
          count += items[j];
      }
      max = Math.max(max, count);
    }
    System.out.print(max);
  }
}
