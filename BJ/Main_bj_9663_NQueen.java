import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_bj_9663_NQueen {

  public static int[] arr;
  public static int N;
  public static int count = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    nQueen(0);
    System.out.println(count);

  }

  public static void nQueen(int depth) {
    if (depth == N) {
      count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      arr[depth] = i;
      if (canMove(depth)) {
        nQueen(depth + 1);
      }
    }

  }

  static boolean canMove(int col) {

    for (int i = 0; i < col; i++) {
      if (arr[col] == arr[i]) {
        return false;
      }

      /*
       * 대각선상에 놓여있는 경우
       * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
       */
      else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
        return false;
      }
    }

    return true;
  }
}