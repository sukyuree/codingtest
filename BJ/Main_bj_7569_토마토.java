import java.io.*;
import java.util.*;

public class Main_bj_7569_토마토 {
  static int N, M, H;
  static int[][][] map;
  static boolean[][][] visited;
  static int[] dx = { 1, -1, 0, 0, 0, 0 };
  static int[] dy = { 0, 0, 1, -1, 0, 0 };
  static int[] dz = { 0, 0, 0, 0, 1, -1 };
  static Queue<int[]> q = new ArrayDeque<>();
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    visited = new boolean[N][M][H];
    map = new int[N][M][H];
    max = Integer.MIN_VALUE;

    for (int k = 0; k < H; k++) {
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
          map[i][j][k] = Integer.parseInt(st.nextToken());
          if (map[i][j][k] == 1) {
            q.offer(new int[] { i, j, k, 0 });
            visited[i][j][k] = true;
          } else if (map[i][j][k] == -1) {
            visited[i][j][k] = true;
          }
        }
      }
    }
    bfs();
    System.out.print(check() ? max : -1);
  }

  static void bfs() {
    while (!q.isEmpty()) {
      int[] polled = q.poll();
      int y = polled[0];
      int x = polled[1];
      int z = polled[2];
      int count = polled[3];
      max = Math.max(max, count);

      for (int d = 0; d < 6; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        int nz = z + dz[d];
        if (ny >= 0 && ny < N && nx >= 0 && nx < M && nz >= 0 && nz < H
            && !visited[ny][nx][nz] && map[ny][nx][nz] == 0) {
          q.offer(new int[] { ny, nx, nz, count + 1 });
          visited[ny][nx][nz] = true;
        }
      }
    }
  }

  static boolean check() {
    boolean flag = true;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < H; k++) {
          if (!visited[i][j][k]) {
            flag = false;
            break;
          }
        }
      }
    }
    return flag;
  }
}