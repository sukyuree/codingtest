import java.io.*;
import java.util.*;

public class Main_bj_1058_친구_서울_20반_김태석 {
  static int N;
  static int[][] map;
  static final int INF = 987654321;
  static int max;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    max = 0;
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), "Y|N", true);
      for (int j = 0; j < N; j++) {
        map[i][j] = st.nextToken().equals("N") ? INF : 1;
      }
      map[i][i] = 0;
    }

    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
        }
      }
    }
    
    for (int i = 0; i < N; i++) {
      int count = 0;
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 || map[i][j] == 2)
          count++;
      }
      max = Math.max(max, count);
    }

    System.out.print(max);
  }
}
