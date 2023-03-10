import java.util.*;
import java.io.*;

public class Main_bj_9019_DSLR {
  static class Number {
    int num;
    String order;
    int count;

    public Number(int num, String order, int count) {
      this.num = num;
      this.order = order;
      this.count = count;
    }
  }

  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      visited = new boolean[10000];
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      bfs(A, B);
    }
    System.out.print(sb.toString());
  }

  static void bfs(int A, int B) {
    PriorityQueue<Number> pq = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);
    pq.offer(new Number(A, "", 0));
    visited[A] = true;

    while (!pq.isEmpty()) {
      Number n = pq.poll();
      int number = n.num;
      String order = n.order;
      int count = n.count;

      if (number == B) {
        sb.append(order).append("\n");
        return;
      }

      int d = D(number);
      int s = S(number);
      int l = L(number);
      int r = R(number);

      if (!visited[d]) {
        pq.offer(new Number(d, order + "D", count + 1));
        visited[d] = true;
      }
      if (!visited[s]) {
        pq.offer(new Number(s, order + "S", count + 1));
        visited[s] = true;
      }
      if (!visited[l]) {
        pq.offer(new Number(l, order + "L", count + 1));
        visited[l] = true;
      }
      if (!visited[r]) {
        pq.offer(new Number(r, order + "R", count + 1));
        visited[r] = true;
      }
    }
  }

  static int D(int A) {
    return (2 * A) % 10000;
  }

  static int S(int A) {
    if (A == 0)
      return 9999;
    return A - 1;
  }

  static int L(int A) {
    return (A % 1000) * 10 + A / 1000;
  }

  static int R(int A) {
    return (A % 10) * 1000 + A / 10;
  }
}
