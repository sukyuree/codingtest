import java.io.*;
import java.util.*;

public class Main_bj_2458_키순서 {
  static int N, M;
  static int[][] graph;
  static boolean[] visited;
  static int cnt;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new int[N + 1][N + 1];
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      graph[from][to] = 1;
      graph[to][from] = 2;
    }
    int answer = 0;
    
    for (int i = 1; i <= N; i++) {
      cnt = 0;
      gtDFS(i, new boolean[N + 1]);
      ltDFS(i, new boolean[N + 1]);
      if (cnt == N - 1)
        answer++;
    }

    System.out.println(answer);
  }
  
  static void gtDFS(int cur, boolean[] visit) {
    visit[cur] = true;
    for (int i = 1; i <= N; i++) {
      if (graph[cur][i] == 1 && !visit[i]) {
        cnt++;
        gtDFS(i, visit);
      }
    }
  }
  static void ltDFS(int cur,boolean[] visit) {
    visit[cur] = true;
    for (int i = 1; i <= N; i++) {
      if (graph[i][cur] == 1 && !visit[i]) {
        cnt++;
        ltDFS(i, visit);
      }
    }
  }
}
