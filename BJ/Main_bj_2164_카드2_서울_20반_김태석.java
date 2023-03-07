import java.io.*;
import java.util.*;

public class Main_bj_2164_카드2_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 1 ; i <= N; i++){dq.offer(i);}
        while(dq.size()!=1){
            dq.poll();
            int temp = dq.poll();
            dq.offer(temp);
        }
        System.out.println(dq.poll());
    }
}
