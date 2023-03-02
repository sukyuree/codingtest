import java.util.*;
import java.io.*;

public class Main_bj_12851_숨바꼭질2 {

    static int N;
    static int K;
    static int count1,count2;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        count1 = Integer.MAX_VALUE;
        count2 = 0;

        bfs();
        
        sb.append(count1).append("\n").append(count2);
        System.out.println(sb.toString());
    }

    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N,0});
        while (!q.isEmpty()){
            int[] polled = q.poll();
            N = polled[0];
            int count = polled[1];

            if(count1<count) break;
            if(N == K){
                if(visited[N] && count == count1) count2++;
                else{
                    visited[N] = true;
                    count2++;
                    count1 = count;
                }
            }
            visited[N] = true;
            // 앞으로 +1칸
            if(N+1<=100000 && !visited[N+1])q.offer(new int[]{N+1,count+1});

            // 뒤로 -1칸
            if(N-1>=0 && !visited[N-1]) q.offer(new int[]{N-1,count+1});
            
            // 점프 2*N
            if(2*N<=100000 && !visited[2*N]) q.offer(new int[]{2*N,count+1});
        }
    }
    
}
