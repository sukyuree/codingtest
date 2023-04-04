import java.io.*;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Main_bj_9205_맥주마시면서걸어가기_서울_20반_김태석 {
  static int N;
  static int[][] map;
  static int[][] graph;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      map = new int[N + 2][2];
      graph = new int[N + 2][N + 2];
      visited = new boolean[N + 2];

      for (int i = 0; i < N + 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        map[i][0] = Integer.parseInt(st.nextToken());
        map[i][1] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < N + 2; i++) {
        for (int j = 0; j < N + 2; j++) {
          if (i == j)
            continue;
          if (graph[i][j] != 0)
            continue;

          if (distance(map[i][0], map[i][1], map[j][0], map[j][1]) <= 1000) {
            graph[i][j] = 1;
            graph[j][i] = 1;
          }
        }
      } 
      sb.append(bfs() ? "happy" : "sad").append("\n");
    }
    System.out.print(sb.toString());
  }

  static int distance(int y1, int x1, int y2, int x2) {
    return Math.abs(y1 - y2) + Math.abs(x1 - x2);
  }

  static boolean bfs() {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(0);
    visited[0] = true;
    while (!q.isEmpty()) {
      int polled = q.poll();
      if (polled == N + 1)
        return true;

      for (int i = 0; i < N + 2; i++) {
        if (!visited[i] && graph[polled][i] != 0) {
          q.offer(i);
          visited[i] = true;
        }
      }
    }
    return false;
  }
}
