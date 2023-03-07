import java.util.*;
import java.io.*;

public class Main_bj_11779_최소비용구하기2_서울_20반_김태석 {
    static int N,M;
    static List<int[]>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int start,end;
    static int min;

    static class Point{
        int node;
        int weight;
        List<Integer> list = new ArrayList<>();

        public Point(int node, int weight, List<Integer> list){
            this.node = node;
            this.weight = weight;
            this.list = list;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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

        PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2)->p1.weight-p2.weight);
        List<Integer> list = new ArrayList<>();
        list.add(start);
        pq.offer(new Point(start,0,list));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Point polled = pq.poll();
            int from = polled.node;
            int weight = polled.weight;
            List<Integer> nodeList = polled.list;
            if(visited[from]) continue;
            visited[from] = true;

            if(from == end){
                min = weight;
                sb.append(min).append("\n");
                sb.append(nodeList.size()).append("\n");
                for(int i : nodeList) sb.append(i).append(" ");
            }

            for(int[] arr : graph[from]){
                int to = arr[0];
                int w = arr[1];
                if(!visited[to] && dist[to] > w + weight){
                    dist[to] = w+weight;
                    List<Integer> nextList = new ArrayList<>();
                    for(int i : nodeList) nextList.add(i);
                    nextList.add(to);
                    pq.offer(new Point(to, dist[to], nextList));
                }
            }

        }
        System.out.print(sb.toString());

    }
}
