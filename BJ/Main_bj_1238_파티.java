import java.io.*;
import java.util.*;

public class Main_bj_1238_파티 {
  static int N, M, X;
  static List<int[]>[] graph;
  static int[] dist;
  static int[] time;
  static boolean[] visited;
  static final int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    dist = new int[N + 1];
    time = new int[N + 1];
    visited = new boolean[N + 1];
    graph = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph[from].add(new int[] { to, weight });
    }

    for (int i = 1; i <= N; i++) {
      time[i] = dijkstra(i,X)+dijkstra(X, i);
    }
    Arrays.sort(time);
    System.out.print(time[N]);
  }
  
  static int dijkstra(int from, int to) {
    Arrays.fill(dist, INF);
    Arrays.fill(visited, false);
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[1] - pq2[1]);
    pq.offer(new int[] { from, 0 });
    dist[from] = 0;
    while (!pq.isEmpty()) {
      int[] polled = pq.poll();
      from = polled[0];
      if (from == to) {
        return polled[1];
      }
      if (visited[from])
        continue;
      visited[from] = true;
      for (int[] arr : graph[from]) {
        int end = arr[0];
        int weight = arr[1];
        if (!visited[end] && dist[end] > dist[from] + weight) {
          dist[end] = dist[from] + weight;
          pq.offer(new int[] { end, dist[end] });
        }
      }
    }
    return dist[to];
  }
}
