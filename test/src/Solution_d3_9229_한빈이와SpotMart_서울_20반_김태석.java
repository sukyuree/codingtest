import java.util.*;
import java.io.*;

public class Solution_d3_9229_한빈이와SpotMart_서울_20반_김태석 {
    static int N,M;
    static int[] arr;
    static int[] snacks;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            max = 0;
            snacks = new int[2];
            comb(0,0);
            if(max == 0) max = -1;
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void comb(int cnt, int start){
        if(cnt == 2){
            int sum = snacks[0]+snacks[1];
            if(sum<=M) max = Math.max(max,sum);
            return;
        }
        for(int i = start; i < N; i++){
            snacks[cnt] = arr[i];
            comb(cnt+1,i+1);
        }
    }
}
