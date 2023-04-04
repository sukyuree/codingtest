import java.io.*;
import java.util.*;

public class Main_bj_10830_행렬제곱 {
  static final int MOD = 1000;
  static int N;
  static long B;
  static int[][] A;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(st.nextToken());
    B = Long.parseLong(st.nextToken());

    A = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] result = pow(A,B);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(result[i][j]%MOD + " ");
      }
      sb.append("\n");
    }
    System.out.print(sb.toString());
  }

  public static int[][] pow(int[][] arr, long count) {
 
		if(count == 1L) {
			return arr;
		}
		
		int[][] ret = pow(arr, count / 2);
		
		ret = multiply(ret, ret);
		
		if(count % 2 == 1L) {
			ret = multiply(ret, A);
		}
		
		return ret;
	}

  static int[][] multiply(int[][] arr1, int[][] arr2) {
		
		int[][] ret = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					ret[i][j] += (arr1[i][k] * arr2[k][j]);
					ret[i][j] %= MOD;	
				}
			}
		}
		return ret;
	}
}
