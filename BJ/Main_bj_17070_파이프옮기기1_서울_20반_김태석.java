import java.io.*;
import java.util.*;

public class Main_bj_17070_파이프옮기기1_서울_20반_김태석 {
  static int N;
  static int[][] map;
  static int currentState; // 0은 가로 1은 세로 2는 대각선
  static int[][] dx = { { 1, 0, 1 }, { 0, 0, 1 }, { 1, 0, 1 } }; // (그대로,대각선),(그대로,대각선),(그대로,가로,세로)
  static int[][] dy = { { 0, 0, 1 }, { 0, 1, 1 }, { 0, 1, 1 } }; // (그대로,대각선),(그대로,대각선),(그대로,가로,세로)
  static int currentX, currentY;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    count = 0;
    currentState = 0;
    currentY = 1;
    currentX = 2;

    dfs(currentY, currentX, currentState, 0);
    System.out.println(count);
  }

  static void dfs(int y, int x, int state, int depth) {
    if (y == N && x == N) {
      count++;
      return;
    }
    for (int d = 0; d < 3; d++) {
      int ny = y + dy[state][d];
      int nx = x + dx[state][d];
      if (!(ny == y && nx == x) && ny >= 1 && ny <= N && nx >= 1 && nx <= N &&
          map[ny][nx] == 0) {
        if (d != 2)
          dfs(ny, nx, d, depth + 1);
        else {
          if (map[ny - 1][nx] == 0 && map[ny][nx - 1] == 0)
            dfs(ny, nx, d, depth + 1);
        }
      }
    }
  }
}
