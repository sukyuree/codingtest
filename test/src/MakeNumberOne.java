import java.util.*;

public class MakeNumberOne{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        Integer[] dp = new Integer[N+1];
        dp[0] = 0;
        dp[1] = 0;
        System.out.println(recur(N,dp));
    }
        
    public static int recur(int N,Integer[] dp){
        if (dp[N] == null) {
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1,dp), Math.min(recur(N / 3 , dp), recur(N / 2, dp))) + 1;
			}
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3 , dp), recur(N - 1 , dp)) + 1;
			} 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2 , dp), recur(N - 1, dp)) + 1;
			}
			else {
				dp[N] = recur(N - 1, dp) + 1;
			}
		}
		return dp[N];
	}
}