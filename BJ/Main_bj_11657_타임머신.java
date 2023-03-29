import java.io.*;
import java.util.*;

public class Main_bj_11657_타임머신 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.valueOf(st.nextToken());
    int m = Integer.valueOf(st.nextToken());

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.valueOf(st.nextToken());
      int end = Integer.valueOf(st.nextToken());
      int cost = Integer.valueOf(st.nextToken());

      edges.add(new Edge(start, end, cost));
    }

    long[] dist = new long[n + 1];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[1] = 0;

    for (int i = 1; i <= n; i++) {
      for (Edge edge : edges) {
        if (dist[edge.start] == Long.MAX_VALUE)
          continue;
        if (dist[edge.end] > dist[edge.start] + edge.cost) {
          dist[edge.end] = dist[edge.start] + edge.cost;
          if (i == n) {
            System.out.println(-1);
            System.exit(0);
          }
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (dist[i] == Long.MAX_VALUE) {
        System.out.println(-1);
      } else {
        System.out.println(dist[i]);
      }
    }
  }

  static class Edge {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
    }
  }
}