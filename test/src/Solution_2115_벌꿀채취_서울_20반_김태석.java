import java.util.*;
import java.io.*;

public class Solution_2115_벌꿀채취_서울_20반_김태석{
    static int N,M,C;
    static int[][] map;
    static int[] b;
    static int[] temp;
    static int max;
    static int[] maxArr;
    static int tempMax;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            b = new int[2];
            max = Integer.MIN_VALUE;
            map = new int[N][N];
            maxArr = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb1(0,0);
            if(N/M > 1){
                for(int i = 0; i < N; i++){
                    comb2(i,0,0);
                }
                Arrays.sort(maxArr);
                max = Math.max(max,maxArr[N-1]);
            }
            sb.append("#"+t+" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
    }

    // 가로줄 N개 중 2개 뽑기
    static void comb1(int cnt, int start){
        if(cnt == 2){
            int max1 = maxInLine(b[0]);
            int max2 = maxInLine(b[1]);
            max = Math.max(max,max1+max2);
            return;
        }

        for(int i = start; i < N; i++){
            b[cnt] = i;
            comb1(cnt+1,i+1);
        }
    }

    static void comb2(int index, int cnt, int start){
        if(cnt == 2){
            int num1 = b[0];
            int num2 = b[1];
            if(num2 < num1+M) return;
            if(num2+M > N) return;
            int powSum1 = powSum(index,num1);
            int powSum2 = powSum(index,num2);
            maxArr[index] = Math.max(maxArr[index],powSum1+powSum2);
            return;
        }
        for(int i = start; i < N; i++){
            b[cnt] = i;
            comb2(index, cnt+1, i+1);
        }
    }
    // 한 줄에서 최대 구하기
    static int maxInLine(int i){
        int max = Integer.MIN_VALUE;
        for(int j = 0; j <= N-M; j++){
            max = Math.max(max,powSum(i,j));
        }
        return max;
    }

    static int powSum(int i, int j){
        int powSum = 0;
        int sum = 0;
        for(int k = 0; k < M; k++){
            sum += map[i][j+k];
        }
        if(sum > C){
            sum = 0;
            tempMax = 0;
            temp = new int[M];
            visited = new boolean[M];

            for(int k = 0; k < M; k++){
                temp[k] = map[i][j+k];
            }
            subs(0);
            powSum = tempMax;
        }
        else{
            for(int k = 0; k < M; k++){
                powSum += map[i][j+k]*map[i][j+k];
            }
        }
        return powSum;
    }

    static void subs(int cnt){
        if(cnt == M){
            int sum = 0;
            int powSum = 0;
            for(int i = 0; i < M; i++){
                if(visited[i]) sum+=temp[i];
            }
            if(sum>C) return;
            for(int i = 0; i < M; i++){
                if(visited[i]) powSum += temp[i]*temp[i];
            }
            tempMax = Math.max(tempMax,powSum);
            return;
        }
        visited[cnt] = true;
        subs(cnt+1);
        visited[cnt] = false;
        subs(cnt+1);
    }
}