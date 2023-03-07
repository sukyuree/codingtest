import java.util.*;
import java.io.*;

public class Main_bj_17471_게리맨더링_서울_20반_김태석 {
    static int N;
    static int[] people;
    static boolean[] visited;
    static boolean[] visitedForSubs;
    static boolean[][] graph;
    static int sumOfGroup1,sumOfGroup2;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new int[N+1];
        graph = new boolean[N+1][N+1];
        visitedForSubs = new boolean[N+1];
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        for(int i = 1; i <= N; i++){
            people[i] = Integer.parseInt(st.nextToken());
            sum += people[i];
        }
        
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            for(int j = 0; j < h; j++){
                int k = Integer.parseInt(st.nextToken());
                graph[i][k] = true;
                graph[k][i] = true;
            }
        }
        subs(1);

        if(min==Integer.MAX_VALUE || min == sum ) min = -1;
        System.out.print(min);
    }
    static void subs(int cnt){
        if(cnt == N+1){
            visited = new boolean[N+1];
            sumOfGroup1 = 0;
            sumOfGroup2 = 0;
            for(int i = 1; i <= N; i++){
                if(visitedForSubs[i]){
                    bfsForGroup1(i);
                    break;
                }
            }
            for(int i = 1; i <= N; i++){
                if(!visitedForSubs[i]){
                    bfsForGroup2(i);
                    break;
                }
            }
            boolean flag = true;
            for(int i = 1; i <= N; i++){
                if(!visited[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) min = Math.min(min,Math.abs(sumOfGroup1-sumOfGroup2));
            return;
        }
        visitedForSubs[cnt] = true;
        subs(cnt+1);
        visitedForSubs[cnt] = false;
        subs(cnt+1);
    }

    static void bfsForGroup1(int from){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(from);
        visited[from] = true;
        sumOfGroup1 += people[from];
        while(!q.isEmpty()){
            from = q.poll();
            for(int i = 1; i <= N; i++){
                if(visitedForSubs[i]&&graph[from][i]&&!visited[i]){
                    visited[i] = true;
                    sumOfGroup1 += people[i];
                    q.offer(i);
                }
            }
        }
    }

    static void bfsForGroup2(int from){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(from);
        visited[from] = true;
        sumOfGroup2 += people[from];
        while(!q.isEmpty()){
            from = q.poll();
            for(int i = 1; i <= N; i++){
                if(!visitedForSubs[i]&&graph[from][i]&&!visited[i]){
                    visited[i] = true;
                    sumOfGroup2 += people[i];
                    q.offer(i);
                }
            }
        }
    }
}