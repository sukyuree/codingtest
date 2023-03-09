import java.util.*;
import java.io.*;

public class Main_bj_1780_종이의개수 {
  static int N;
  static int[][] map;
  static int black, gray, white; // black : -1, gray : 0, white : 1

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
    count(1, 1, N);
    System.out.print(black + "\n" + gray + "\n" + white);
  }

  static void count(int y, int x, int length) {
    if (isIntegrated(y, x, length)) {
      int num = map[y][x];
      if (num == -1) {
        black++;
      } else if (num == 0) {
        gray++;
      } else {
        white++;
      }
      return;
    }
    count(y + length / 3, x + length / 3, length / 3);
    count(y + length / 3, x + (length / 3) * 2, length / 3);
    count(y + length / 3, x, length / 3);

    count(y + (length / 3) * 2, x + length / 3, length / 3);
    count(y + (length / 3) * 2, x + (length / 3) * 2, length / 3);
    count(y + (length / 3) * 2, x, length / 3);

    count(y, x + length / 3, length / 3);
    count(y, x + (length / 3) * 2, length / 3);
    count(y, x, length / 3);
  }

  static boolean isIntegrated(int y, int x, int length) {
    boolean flag = true;
    int num = map[y][x];

    for (int i = y; i < y + length; i++) {
      for (int j = x; j < x + length; j++) {
        if (map[i][j] != num) {
          flag = false;
          break;
        }
      }
    }

    return flag;
  }
}
