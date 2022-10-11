import java.util.*;
import java.io.*;

public class LeaveTheCompany {
    static int max = 0;
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        T = new int[N+6];
        P = new int[N+6];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[N+6];
        int max = 0;
        for(int i = 1; i <= N+1; i++){
            dp[i] = Math.max(dp[i],max);

            dp[i+T[i]] = Math.max(dp[i]+P[i],dp[i+T[i]]);

            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
        
    }
}
