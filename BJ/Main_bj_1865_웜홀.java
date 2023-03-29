import java.io.*;
import java.util.*;

class Edge {
  int start;
  int end;
  int time;

  public Edge(int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}

public class Main_bj_1865_웜홀 {
  final static int INF = Integer.MIN_VALUE;
  static int N, M, W;
  static List<Edge> list;
  static long[] dist;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int TC = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= TC; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());

      list = new ArrayList<>();
      dist = new long[N + 1];
      Arrays.fill(dist, INF);

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        list.add(new Edge(start, end, time));
        list.add(new Edge(end, start, time));
      }

      for (int i = 0; i < W; i++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        list.add(new Edge(start, end, time * -1));
      }
      sb.append(BellmanFord() ? "YES" : "NO").append("\n");
    }
    System.out.print(sb.toString());
  }

  static boolean BellmanFord() {
    for (int i = 1; i <= N; i++) {
      boolean isUpdate = false;
      dist[i] = 0;
      for (int j = 1; j < N; j++) {
        for (Edge edge : list) {
          if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.time) {
            dist[edge.end] = dist[edge.start] + edge.time;
            isUpdate = true;
          }
        }
        if (!isUpdate)
          break;
      }
      if (isUpdate) {
        for (Edge edge : list) {
          if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.time) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
