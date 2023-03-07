import java.io.*;
import java.util.*;

public class Main_2805_나무자르기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        int maxNum = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum,trees[i]);
        }
        
        int answer = Integer.MIN_VALUE;
        int minNum = 0;
        int mid = (maxNum+minNum)/2;
        while(minNum<=maxNum){
            long sum = 0;
            mid = (maxNum+minNum)/2;
            for(int i = 0; i < N; i++){
                if(mid>trees[i]) continue;
                sum+=trees[i]-mid;
            }
            if(sum<M) maxNum = mid-1;
            else{
                if(mid >= answer) answer = mid;
                minNum = mid+1;
            }
        }
        System.out.print(answer);
    }
}