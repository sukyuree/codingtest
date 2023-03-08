import java.io.*;
import java.util.*;

public class Main_bj_11403_경로찾기 {
  static int N;
  static boolean[][] graph;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    graph = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        graph[i][j] = st.nextToken().equals("1") ? true : false;
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        bfs(i, j);
      }
      sb.append("\n");
    }

    System.out.print(sb.toString());
  }

  static void bfs(int from, int to) {
    visited = new boolean[N];
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      if (graph[from][i]) {
        q.offer(i);
        if (i == to) {
          sb.append("1 ");
          return;
        }
      }
    }

    while (!q.isEmpty()) {
      from = q.poll();

      if (from == to) {
        sb.append("1 ");
        return;
      }

      visited[from] = true;
      for (int i = 0; i < N; i++) {
        if (graph[from][i] && !visited[i])
          q.offer(i);
      }
    }
    sb.append("0 ");
  }
}
