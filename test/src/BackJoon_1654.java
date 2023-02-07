import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class BackJoon_1654 {
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }
        long length = 1L;
        long sum = Long.MAX_VALUE;
        while(true){
            sum = 0;
            for(int i = 0; i < K; i++){
                sum += arr[i]/length;
            }
            if(sum < N) break;
            length++;
        }

        System.out.println(length-1);
    }
}
