import java.io.*;
import java.util.*;

class BackJoon_11000{
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(a1,a2)->{
            if(a1[0]==a2[0]) return a1[1]-a2[1];
            return a1[0]-a2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);
        for(int i = 1; i < n; i++){
            
            if(pq.peek()<=arr[i][0]) pq.poll();
            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}