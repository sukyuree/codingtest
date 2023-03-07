import java.util.*;
import java.io.*;

public class Main_bj_1932_정수삼각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr[1] = Integer.parseInt(st.nextToken());
        dp[1] = arr[1];

        for(int i = 2; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[1] = Integer.parseInt(st.nextToken())+dp[1];
            for(int j = 2; j < i; j++){
                arr[j] = Math.max(dp[j-1],dp[j])+Integer.parseInt(st.nextToken());
            }
            arr[i] = Integer.parseInt(st.nextToken())+dp[i-1];
            for(int k = 1; k <= i; k++){
                dp[k] = arr[k];
            }
        }

        for(int i = 1; i <= N; i++){
            max = Math.max(max,dp[i]);
        }
        System.out.print(max);
    }
}
