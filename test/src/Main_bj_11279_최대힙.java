import java.io.*;
import java.util.*;

public class Main_bj_11279_최대힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2) -> p2-p1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0) pq.offer(num);
            else if(num == 0){
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
