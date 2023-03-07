import java.util.*;
import java.io.*;

public class Main_bj_11659_구간합구하기4_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer. parseInt(st.nextToken());

        int[] sumOfNumbers = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            sumOfNumbers[i] = sumOfNumbers[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(sumOfNumbers[k]-sumOfNumbers[j-1]).append("\n");
        }
        
        System.out.print(sb);
    }
    
}
