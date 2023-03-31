import java.util.*;
import java.io.*;

public class Main_bj_1167_트리의지름 {
  static int N;
  static List<int[]>[] list;
  static int answer;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    list = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int numOfToken = st.countTokens();
      for (int j = 1; j <= (numOfToken - 1) / 2; j++) {
        int child = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        list[parent].add(new int[] { child, weight });
      }
    }
    bfs(bfs(1));
    System.out.println(answer);
  }

  static void dfs(int node, int length) {
    answer = Math.max(answer, length);
    visited[node] = true;

    for (int[] nodes : list[node]) {
      if (!visited[nodes[0]]) {
        dfs(nodes[0], length + nodes[1]);
      }
    }
  }

  static int bfs(int node) {
    visited = new boolean[N + 1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq2[1] - pq1[1]);
    visited[node] = true;
    pq.offer(new int[] { node, 0 });
    int mostDeep = 0;
    int max = 0;
    while (!pq.isEmpty()) {
      int[] polled = pq.poll();
      node = polled[0];
      int length = polled[1];
      if (length > max) {
        max = length;
        answer = length;
        mostDeep = node;
      }
      for (int[] nodes : list[node]) {
        if (!visited[nodes[0]]) {
          pq.offer(new int[] { nodes[0], nodes[1] + length });
          visited[nodes[0]] = true;
        }
      }
    }
    return mostDeep;
  }
}
