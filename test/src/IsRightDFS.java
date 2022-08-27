import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class IsRightDFS {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] order;
	static boolean flag;
	static int N, idx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i = 0 ; i <= N ; ++i) graph.add(new ArrayList<>());
		
		visited = new boolean[N + 1];
		order = new int[N];
		flag = true;
		idx = 1;
		
		for(int i = 0 ; i < N - 1 ; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; ++i) order[i] = Integer.parseInt(st.nextToken());
		
		if(order[0] != 1) {
			System.out.println(0);
			return;
		}
		
		dfs(1);
		
		if(flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
	}

	private static void dfs(int x) {
		if(visited[x]) return;
		
		visited[x] = true;
		
		HashSet<Integer> set = new HashSet<>();
		for(int next : graph.get(x)) {
			if(visited[next]) continue;
			set.add(next);
		}
		
		if(set.size() == 0) return;
		
		if(set.contains(order[idx])) {
			dfs(order[idx++]);
		} else {
			flag = false;
		}
	}
}