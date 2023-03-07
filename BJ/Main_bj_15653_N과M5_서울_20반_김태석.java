import java.util.*;
import java.io.*;

public class Main_bj_15653_N과M5_서울_20반_김태석 {
    static int N,M;
    static int[] arr;
    static int[] pArr;
    static boolean[] visited;
        static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        pArr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i-1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(0);
        System.out.print(sb.toString());
    }

    static void permutation(int cnt){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                sb.append(pArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            pArr[cnt] = arr[i];
            permutation(cnt+1);
            pArr[cnt] = 0;
            visited[i] = false;
        }
    }

}
