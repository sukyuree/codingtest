import java.util.*;
import java.io.*;

public class Main_bj_1697_숨바꼭질_서울_20반_김태석 {

    static int N;
    static int K;

    static int[] visited = new int[100001];

    static boolean[][] graph;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        int count = bfs();

        System.out.println(count);
    }

    static int bfs(){
        visited[N] = 0;
        q.offer(N);
        int count = 0;
        while (q.isEmpty() == false){
            N = q.poll();
            
            if (N == K){
                count =  visited[N];
                break;
            }
            
            if (N-1>=0 && visited[N-1] == 0){
                visited[N-1] = visited[N]+1;
                q.add(N-1);
            }
            if (N+1 <= 100000 && visited[N+1] == 0){
                visited[N+1] = visited[N]+1;
                q.add(N+1);
            }
            if (2*N <= 100000 && visited[2*N] == 0){
                visited[2*N] = visited[N] + 1;
                q.add(2*N);
            }
        }
        return count;
    }
    
}
