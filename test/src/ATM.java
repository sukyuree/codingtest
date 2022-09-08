import java.util.*;
import java.io.*;

public class ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] time = new int[N];
        for(int i = 0 ; i < N; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int temp = 0;
        int sum = 0;
        for(int i = 0 ; i < N; i++){
            temp+=time[i];
            sum+=temp;
        }
        System.out.println(sum);
    }
    
}
