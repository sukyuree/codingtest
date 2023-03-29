import java.io.*;
import java.util.*;

public class Main_bj_1600_말이되고픈원숭이_서울_20반_김태석 {
  static int K, W, H;
  static int[][] map;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };
  static int[] hdx = { -2, -1, 1, 2, 2, 1, -1, -2 };
  static int[] hdy = { -1, -2, -2, -1, 1, 2, 2, 1 };
  static int min;
  static boolean[][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H + 1][W + 1];
    visited = new boolean[H + 1][W + 1][K + 1];
    min = Integer.MAX_VALUE;

    for (int i = 1; i <= H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= W; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // dfs(1, 1, 0, K);
    bfs(1, 1);
    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
  }

  static void bfs(int y, int x) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[2] - pq2[2]);
    pq.offer(new int[] { y, x, 0, K });
    visited[y][x][K] = true;
    while (!pq.isEmpty()) {
      int[] polled = pq.poll();
      y = polled[0];
      x = polled[1];
      int count = polled[2];
      int jump = polled[3];

      if (y == H && x == W) {
        min = count;
        return;
      }
      for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        if (ny >= 1 && ny <= H && nx >= 1 && nx <= W && map[ny][nx] == 0 &&
            !visited[ny][nx][jump]) {
          pq.offer(new int[] { ny, nx, count + 1, jump });
          visited[ny][nx][jump] = true;
        }
      }
      if (jump <= 0)
        continue;
      for (int d = 0; d < 8; d++) {
        int ny = y + hdy[d];
        int nx = x + hdx[d];
        if (ny >= 1 && ny <= H && nx >= 1 && nx <= W && map[ny][nx] == 0 &&
            !visited[ny][nx][jump - 1]) {
          pq.offer(new int[] { ny, nx, count + 1, jump - 1 });
          visited[ny][nx][jump - 1] = true;
        }
      }
    }
  }

  // static void dfs(int y, int x, int jumpCount, int horseJump) {
  // if (y == H && x == W) {
  // min = Math.min(min, jumpCount);
  // return;
  // }

  // if (horseJump > 0) {
  // for (int d = 0; d < 8; d++) {
  // int ny = y + hdy[d];
  // int nx = x + hdx[d];
  // if (ny >= 1 && ny <= H && nx >= 1 && nx <= W && map[ny][nx] == 0 &&
  // !visited[ny][nx]) {
  // visited[ny][nx] = true;
  // dfs(ny, nx, jumpCount + 1, horseJump - 1);
  // visited[ny][nx] = false;
  // }
  // }
  // }

  // for (int d = 0; d < 4; d++) {
  // int ny = y + dy[d];
  // int nx = x + dx[d];
  // if (ny >= 1 && ny <= H && nx >= 1 && nx <= W && map[ny][nx] == 0 &&
  // !visited[ny][nx]) {
  // visited[ny][nx] = true;
  // dfs(ny, nx, jumpCount + 1, horseJump);
  // visited[ny][nx] = false;
  // }
  // }
  // }
}
