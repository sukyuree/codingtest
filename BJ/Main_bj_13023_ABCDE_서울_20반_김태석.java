import java.io.*;
import java.util.*;

public class Main_bj_13023_ABCDE_서울_20반_김태석 {
    static int N,M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        int r = 0;
        int c = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[r].add(c);
            graph[c].add(r);
        }
        
        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            if(!visited[i]){
                dfs(1,i);
                if(flag) break;
            }
        }

        System.out.print(flag ? 1:0);
    }
    static void dfs(int cnt, int i){
        if(cnt==5){
            flag = true;
            return;
        }
        visited[i] = true;
        for(int j : graph[i]){
            if(!visited[j]){
                visited[j] = true;
                dfs(cnt+1,j);
                visited[j] = false;
            }
        }
    }
}
