import java.util.*;
import java.io.*;

public class Main_bj_2468_요세푸스_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++){
            q.offer(i);
        }

        /*
         * int result = 0;
         * for(int i = 1; i <= N; i++){
         *      result = (result+K)%i;
         * }
         */
        sb.append('<');
        while(q.size()>1){
            for(int i = 0; i < K-1; i++){
                int k = q.poll();
                q.offer(k);
            }
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append('>');
        System.out.println(sb.toString());

        br.close();
    }
    
}
