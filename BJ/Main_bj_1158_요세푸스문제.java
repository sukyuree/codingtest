import java.util.*;
import java.io.*;

public class BackJoon_1158 {
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
