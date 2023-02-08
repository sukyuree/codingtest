import java.util.*;
import java.io.*;

public class Main_bj_15654_N과M6_서울_20반_김태석 {
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

        combination(0,0);
        System.out.print(sb.toString());
    }
    
    static void combination(int cnt, int start){
        if(cnt == M) {
            for(int i = 0; i < M; i++){
                sb.append(pArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            pArr[cnt] = arr[i];
            combination(cnt+1,i+1);
        }
    }
}
