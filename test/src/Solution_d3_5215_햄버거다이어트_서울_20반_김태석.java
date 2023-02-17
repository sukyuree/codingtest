import java.util.*;
import java.io.*;

public class Solution_d3_5215_햄버거다이어트_서울_20반_김태석 {
    static int N, L;
    static boolean[] visited;
    static int[][] h;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            h = new int[N][2];
            visited = new boolean[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                h[i][0] = Integer.parseInt(st.nextToken());
                h[i][1] = Integer.parseInt(st.nextToken());
            }
            max = Integer.MIN_VALUE;
            subs(0);
            sb.append("#"+t).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void subs(int cnt){
        if(cnt == N){
            int sumOfTaste = 0;
            int sumOfCal = 0;
            for(int i = 0; i < N; i++){
                if(visited[i]){
                    sumOfTaste += h[i][0];
                    sumOfCal += h[i][1];
                }
            }
            if(sumOfCal<=L) max = Math.max(sumOfTaste,max);
            return;
        }
        visited[cnt] = true;
        subs(cnt+1);
        visited[cnt] = false;
        subs(cnt+1);
    }
}
