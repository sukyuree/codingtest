import java.util.*;
import java.io.*;

// class Node {
//   int start;
//   int end;
//   int weight;

//   public Node(int start, int end, int weight) {
//     this.start = start;
//     this.end = end;
//     this.weight = weight;
//   }
// }

public class Main_bj_1967_트리의지름 {
  static int N;
  static List<int[]>[] list;
  static int max;
  static boolean[] visited;
  static boolean[] isParent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    list = new List[N + 1];
    isParent = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      isParent[parent] = true;
      list[parent].add(new int[] { child, weight });
      list[child].add(new int[] { parent, weight });
    }

    for (int i = 1; i <= N; i++) {
      if (!isParent[i]) {
        visited = new boolean[N + 1];
        dfs(i, 0);
      }
    }
    System.out.println(max);
  }

  static void dfs(int node, int length) {
    max = Math.max(max, length);
    visited[node] = true;

    for (int[] nodes : list[node]) {
      if (!visited[nodes[0]]) {
        dfs(nodes[0], length + nodes[1]);
      }
    }
  }
}
