import java.util.*;
import java.io.*;

class Point{
    int v;
    int w;

    public Point(int v, int w){
        this.v = v;
        this.w = w;
    }
}
public class Main_bj_1753_최단경로 {
    static int N,M,start;
    static boolean[] visited;
    static PriorityQueue<Point>[] list;
    static int min;
    static boolean flag;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        list = new PriorityQueue[N+1];

        for(int i = 1; i <= N; i++) list[i] = new PriorityQueue<>((p1,p2)->p1.w-p2.w);

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Point(v,w));
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            flag = false;
            min = Integer.MAX_VALUE;
            dfs(start,i,0);
            sb.append(flag?min:"INF").append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dfs(int start, int destination, int wSum){
        if(start == destination){
            min = Math.min(min,wSum);
            flag = true;
            return;
        }
        for(Point p : list[start]){
            if(!visited[p.v]){
                visited[p.v] = true;
                dfs(p.v,destination,wSum+p.w);
                visited[p.v] = false;
            }
        }
    }
}
