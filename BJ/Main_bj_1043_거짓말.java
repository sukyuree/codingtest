import java.io.*;
import java.util.*;

public class Main_bj_1043_거짓말 {
    static int N,M,R;
    static int tN;
    static int[] temp;
    static List<Integer>[] party;
    static boolean[] knowTruth;
    static boolean[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];
        knowTruth = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        tN = Integer.parseInt(st.nextToken());
        party = new List[M];
        if(tN!=0){
            for(int i = 1; i <= tN; i++){
                knowTruth[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for(int i = 0; i < M; i++){
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            for(int j = 0; j < R; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }

            if(R>=2){
                temp = new int[3];
                comb(1,1,i);
            }
        }
        bfs();
        int count = 0;
        for(int i = 0; i < M; i++){
            boolean flag = false;
            for(int num : party[i]){
                if(knowTruth[num]){
                    flag = true;
                }
            }
            if(!flag) count ++;
        }

        System.out.print(count);
    }

    static void comb(int cnt, int start, int index){
        if(cnt == 3){
            //System.out.println(temp[1]+" "+temp[2]);
            graph[temp[1]][temp[2]] = true;
            graph[temp[2]][temp[1]] = true;
            return;
        }
        for(int i = start; i <= party[index].size(); i++){
            temp[cnt] = party[index].get(i-1);
            comb(cnt+1,i+1,index);
        }
    }

    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(knowTruth[i]) q.offer(i);
        }

        while(!q.isEmpty()){
            int polled = q.poll();
            for(int i = 1; i <= N; i++){
                if(graph[polled][i]&&!knowTruth[i]){
                    //System.out.println("OFFER");
                    q.offer(i);
                    knowTruth[i] = true;
                }
            }
        }
    }
}