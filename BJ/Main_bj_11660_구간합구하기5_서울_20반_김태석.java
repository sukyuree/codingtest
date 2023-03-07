import java.util.*;
import java.io.*;

public class Main_bj_11660_구간합구하기5_서울_20반_김태석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] C = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                C[i][j] = C[i][j-1] + Integer.parseInt(st.nextToken());
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
            sb.append(sum).append("\n");
        }

        System.out.print(sb.toString());
    }
}
