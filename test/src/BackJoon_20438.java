import java.util.*;
import java.io.*;

public class BackJoon_20438 {
    static int N, K, Q, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] students = new int[N+3];
        boolean[] isSleep = new boolean[N+3];
        for(int i = 3; i <= N+2; i++) students[i] = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= K; i++){
            isSleep[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= Q; i++){
            int s = Integer.parseInt(st.nextToken());
            if(isSleep[s]) continue;
            for(int j = 3; j <= N+2; j++){
                if(j%s == 0&&!isSleep[j]) students[j] = 0;
            }
        }

        for(int i = 3; i <= N+2; i++) students[i] += students[i-1];

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(students[end]-students[start-1]).append("\n");
        }

        System.out.print(sb.toString());
    }
    
}