import java.io.*;
import java.util.*;

public class Main_bj_1504_특정한최단경로 {
  static int N, E;
  static final int INF = 200000000;
  static List<int[]>[] graph;
  static int[] dist;
  static boolean[] visited;
  static int specialNode1, specialNode2;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    dist = new int[N + 1];

    Arrays.fill(dist, INF);
    graph = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= E; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph[from].add(new int[] { to, weight });
      graph[to].add(new int[] { from, weight });
    }
    st = new StringTokenizer(br.readLine());
    specialNode1 = Integer.parseInt(st.nextToken());
    specialNode2 = Integer.parseInt(st.nextToken());

    int min1 = 0;
    min1 += dijkstra(1, specialNode1);
    min1 += dijkstra(specialNode1, specialNode2);
    min1 += dijkstra(specialNode2, N);

    Arrays.fill(visited,false);
    Arrays.fill(dist, INF);

    int min2 = 0;
    min2 += dijkstra(1, specialNode2);
    min2 += dijkstra(specialNode2, specialNode1);
    min2 += dijkstra(specialNode1, N);
    
    System.out.print(min1>=INF&&min2>=INF?-1:Math.min(min1,min2));
  }
  
  static int dijkstra(int from, int to) {
    Arrays.fill(visited,false);
    Arrays.fill(dist, INF);
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[1] - pq2[1]);
    pq.offer(new int[] { from, 0 });
    dist[from] = 0;
    while (!pq.isEmpty()) {
      int[] polled = pq.poll();
      from = polled[0];
      if (visited[from])
        continue;
      visited[from] = true;
      for (int[] nodes : graph[from]) {
        int t = nodes[0];
        if (!visited[t] && dist[t] > dist[from] + nodes[1]) {
          dist[t] = dist[from] + nodes[1];
          pq.offer(new int[] { t, dist[t] });
        }
      }
    }
    return dist[to];
  }
}