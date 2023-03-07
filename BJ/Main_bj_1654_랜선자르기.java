import java.io.*;
import java.util.*;

public class BackJoon_1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long sum = 0;
        long max = Long.MIN_VALUE;

        long[] arr = new long[K];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        long min = 1;
        long mid = 0;

        while(min <= max){
            mid = (max+min)/2;
            sum = 0;

            for(long l : arr) sum+=l/mid;
            if(sum<N) max = mid-1;
            else min = mid+1;

            
        }
        System.out.println(max);
    }
}