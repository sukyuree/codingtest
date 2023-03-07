import java.util.*;
import java.io.*;

public class Main_bj_12865_평범한배낭 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[100001];
        boolean[] dpVisited = new boolean[100001];

        PriorityQueue<Integer>[] list = new PriorityQueue[100001];
        for(int i = 0; i <= 100000; i++){
            list[i] = new PriorityQueue<>((p1,p2)->p2-p1);
        }

        
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[index].offer(value);
        }

        dp[0] = 0;

        for(int i = 1; i <= K; i++){
            int max = 0;
            int finalIndex = 0;
            int J = 0;
            int finalJ = 0;
            int index = 0;
            int temp1 = 0;
            int temp2 = 0;
            for(int j = 1; j <= i; j++){
                if(dp[j]!=0&&dp[i-j]!=0&&!dpVisited[j]&&!dpVisited[i-j]&&j!=i-j){
                    temp1 = dp[j]+dp[i-j];
                    J = j;
                }
                if(!list[j].isEmpty()){
                    if(j == i){
                        temp2 = list[j].peek();
                        index = j;
                    }
                    else if(j<i&&dp[i-j]!=0&&!dpVisited[i-j]){
                        temp2 = list[j].peek() + dp[i-j];
                        index = j;
                    }
                }
                max = Math.max(max,Math.max(temp1,temp2));

                if(max == temp1){
                    finalIndex = 0;
                    finalJ = J;
                }
                else if(max == temp2){
                    finalIndex = index;
                    finalJ = 0;
                }
                
                if(temp1 == temp2){
                    finalIndex = 0;
                    finalJ = J;
                }
            }

            if(finalIndex == 0 && finalJ == 0) dp[i] = 0;
            else if(finalIndex == 0 && finalJ != 0){
                dp[i] = dp[finalJ] + dp[i - finalJ];
                dpVisited[finalJ] = true;
                dpVisited[i - finalJ] = true;
            }
            else if(finalIndex != 0 && finalJ == 0){
                dp[i] = list[finalIndex].poll() + dp[i - finalIndex];
                dpVisited[i-finalIndex] = true;
            }
        }

        for(int i = K; i >= 1; i--){
            if(dp[i]!=0){
                System.out.print(dp[i]);
                break;
            }
        }
    }
}
