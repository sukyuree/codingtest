import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= N; i++){
            q.offer(i);
        }

        while(q.size()!=1){
            q.poll();
            int temp = q.poll();
            q.offer(temp);
        }
        System.out.println(q.poll());
    }
}
