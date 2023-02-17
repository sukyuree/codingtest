import java.io.*;
import java.util.*;

public class Solution_4008_숫자만들기_서울_20반_김태석{
    static int N;
    static int[] numArr;
    static int[] order;
    static int min, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());

            numArr = new int[N];
            order = new int[4];

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 4; i++){
                order[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) numArr[i] = Integer.parseInt(st.nextToken());
            dfs(numArr[0],1);

            sb.append("#"+t).append(" ").append(max-min).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void dfs(int calculated, int index){
        if(index==N){
            min = Math.min(min,calculated);
            max = Math.max(max,calculated);
        }

        for(int i = 0; i < 4; i++){
            if(order[i]==0) continue;
            order[i]--;

            switch(i){
                case(0) : dfs(calculated + numArr[index],index+1); break;
                case(1) : dfs(calculated - numArr[index],index+1); break;
                case(2) : dfs(calculated * numArr[index],index+1); break;
                case(3) : dfs(calculated / numArr[index],index+1); break;
            }

            order[i]++;
        }
    }
}