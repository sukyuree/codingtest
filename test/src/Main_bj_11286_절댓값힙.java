import java.util.*;
import java.io.*;

public class Main_bj_11286_절댓값힙{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2)->{
            if(Math.abs(p1) == Math.abs(p2)) return p1 - p2;
            return Math.abs(p1)-Math.abs(p2);
        });
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            if(number == 0){
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else pq.offer(number);
        }

        System.out.print(sb.toString());
    }
}
