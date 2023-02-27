import java.io.*;
import java.util.*;

public class Solution_d4_3289_서로소집합_서울_20반_김태석 {
    static int N,M;
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb2 = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            p = new int[N+1];

            for(int i = 1; i <= N; i++){
                p[i] = i;
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(order == 0){
                    union(a,b);
                }
                else{
                    sb2.append(verify(a,b)?1:0);
                }
            }
            sb.append("#"+t+" ").append(sb2).append("\n");
        }
        System.out.print(sb.toString());
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
    static boolean verify(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return true;
        return false;
    }
}
