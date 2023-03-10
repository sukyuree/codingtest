import java.util.*;
import java.io.*;

public class Main_bj_16928_뱀과사다리게임 {
  static int N, M;
  static int[] map;
  static boolean[] visited;
  static int[] dice = { 1, 2, 3, 4, 5, 6 };
  static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[101];
    min = Integer.MAX_VALUE;
    visited = new boolean[101];

    for (int i = 1; i <= 100; i++) {
      map[i] = i;
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      map[from] = to;
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      map[from] = to;
    }
    bfs();
    System.out.print(min);
  }

  static void bfs() {
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> {
      if (pq1[1] == pq2[1])
        return pq2[0] - pq1[0];
      return pq1[1] - pq2[1];
    });
    pq.offer(new int[] { 1, 0 });
    visited[1] = true;
    while (!pq.isEmpty()) {
      int[] polled = pq.poll();
      int x = polled[0];
      int count = polled[1];
      if (x == 100) {
        min = count;
        return;
      }

      for (int d = 0; d < 6; d++) {
        int nx = x + dice[d];
        if (nx >= 0 && nx <= 100 && !visited[map[nx]] && !visited[nx]) {
          pq.offer(new int[] { map[nx], count + 1 });
          visited[map[nx]] = true;
          visited[nx] = true;
        }
      }
    }
  }
}
