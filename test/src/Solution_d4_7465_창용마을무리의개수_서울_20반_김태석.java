import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수_서울_20반_김태석 {
    static int N,M;
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = new int[N+1];
            make();
            for(int i = 1; i <= M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            verify(set);
            sb.append("#"+t+" ").append(set.size()).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void make() {
		for(int i = 1; i <= N; i++) p[i] = i;
	}
	
	static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		p[bRoot] = aRoot;
	}

    static void verify(Set<Integer> set){
        for(int i = 1; i <= N; i++) find(i);
        for(int i = 1; i <= N; i++){
            set.add(p[i]);
        }
    }
}
