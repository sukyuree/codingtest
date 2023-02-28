import java.util.*;
import java.io.*;

public class Solution_d4_3124_최소스패닝트리 {
    static class Edge implements Comparable<Edge>{
		int from, to, weight;
		Edge(int from, int  to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return Integer.compare(weight, e.weight);
		}
	}
    
    static int N,E;
    static Edge[] edges;
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edges = new Edge[E];

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(from, to, weight);
            }
            Arrays.sort(edges);
            make();
            long result = 0L, cnt = 0L;
            for(Edge e : edges) {
                if(union(e.from, e.to)) {
                    result += e.weight;
                    if(++cnt==N) break;
                }
            }
            sb.append("#"+t+" ").append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void make() {
		p = new int[N+1];
		for(int i = 1; i <= N; i++) p[i] = i;
	}
	
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		p[bRoot]= aRoot; 
		return true;
	}
}
