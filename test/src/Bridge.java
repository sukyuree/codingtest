import java.util.*;
import java.io.*;

public class Bridge {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(combination(M,N));
        }
    }

    public static int combination(int n, int r){
        if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		// 1번 성질
		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
