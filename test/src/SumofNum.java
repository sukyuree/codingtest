import java.util.*;
import java.io.*;

public class SumofNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N+1][N+1];
        int[] B = new int[M];
        int[][] C = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                C[i][j] = C[i][j-1] + A[i][j];
            }
        }

        for (int k = 1; k <= M; k++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int i = x1; i <= x2; i++){
                sum = sum + (C[i][y2] - C[i][y1-1]);
            }
            B[k-1] = sum;
        }
        for(int i = 0; i < M; i++){
            System.out.println(B[i]);
        }
    }
}
