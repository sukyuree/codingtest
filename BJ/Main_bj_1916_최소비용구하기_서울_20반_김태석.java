import java.util.*;
import java.io.*;

public class Main_bj_1916_최소비용구하기_서울_20반_김태석 {
    static int N,M;
    static List<int[]>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int start,end;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        visited = new boolean[N+1];
        graph = new List[N+1];
        min = Integer.MAX_VALUE;

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[from].add(new int[]{to,w});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((pq1,pq2)->pq1[1]-pq2[1]);
        pq.offer(new int[]{start,0});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int from = polled[0];
            int weight = polled[1];
            if(visited[from]) continue;
            visited[from] = true;

            if(from == end){
                min = weight;
                break;
            }

            for(int[] arr : graph[from]){
                int to = arr[0];
                int w = arr[1];
                if(!visited[to] && dist[to] > w + weight){
                    dist[to] = w+weight;
                    pq.offer(new int[]{to,dist[to]});
                }
            }

        }

        System.out.print(min);

    }
}
