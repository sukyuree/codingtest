import java.util.*;
import java.io.*;

public class BackJoon_19598 {
    static long[][] lArr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[][] lArr = new long[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            lArr[i][0] = a;
            lArr[i][1] = b;
        }
        Arrays.sort(lArr,(l1,l2)->{
            if(l1[0]==l2[0]) return (int)(l1[1]-l2[1]);
            return (int)(l1[0]-l2[0]);
        });

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(lArr[0][1]);

        for(int i = 1; i < N; i++){
            if(pq.peek()<=lArr[i][0]) pq.poll();
            pq.add(lArr[i][1]);
        }
        System.out.println(pq.size());
    }
}
