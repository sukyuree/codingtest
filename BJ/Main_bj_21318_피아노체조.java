import java.io.*;
import java.util.*;

public class BackJoon_21318 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] playList = new int[N+1];
        int[] miss = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            playList[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int Q = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N-1; i++) if(playList[i]>playList[i+1]) miss[i] = 1;
        for(int i = 1; i <= N; i++) miss[i] += miss[i-1];

        for(int i = 1; i <= Q; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(miss[end]!=miss[end-1])
                sb.append((miss[end]-miss[start-1])-1).append("\n");
            else sb.append(miss[end]-miss[start-1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}