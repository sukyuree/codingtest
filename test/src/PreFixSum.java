import java.util.*;
import java.io.*;

public class PreFixSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer. parseInt(st.nextToken());

        Integer[] numbers = new Integer[N+1];
        int[] sumOfNumbers = new int[N+1];
        int[] prefix = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            sumOfNumbers[i] = sumOfNumbers[i-1]+numbers[i];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            prefix[i] = sumOfNumbers[k]-sumOfNumbers[j-1];
        }

        for (int i = 0; i < M; i++){
            System.out.println(prefix[i]);
        }
    }
    
}
