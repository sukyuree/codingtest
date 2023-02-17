import java.io.*;
import java.util.*;

public class Main_bj_16435_스네이크버드_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] fruits = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            fruits[i] = Integer.parseInt(st.nextToken());            
        }
        Arrays.sort(fruits);

        for(int i = 0; i < N; i++){
            if(fruits[i]<=L) L++;
        }
        System.out.print(L);
    }
}
