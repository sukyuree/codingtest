import java.io.*;
import java.util.*;

public class Main_bj_10971_외판원순회2_서울_20반_김태석 {
  static int N;
  static int[][] graph;
  static boolean[] visited;
  static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    graph = new int[N + 1][N + 1];
    min = Integer.MAX_VALUE;

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      dfs(i, i, 0, 0);
    }
    System.out.println(min);
  }

  static void dfs(int start, int end, int depth, int cost) {
    if (depth == N && start == end) {
      min = Math.min(cost, min);
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (!visited[i] && graph[start][i] > 0) {
        visited[i] = true;
        dfs(i, end, depth + 1, cost + graph[start][i]);
        visited[i] = false;
      }
    }
  }
}