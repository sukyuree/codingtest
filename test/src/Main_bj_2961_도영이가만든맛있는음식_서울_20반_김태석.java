import java.util.*;
import java.io.*;

public class Main_bj_2961_도영이가만든맛있는음식_서울_20반_김태석 {
    static long[][] arr;
    static int N;
    static long MIN = Long.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new long[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(a1,a2)->(int)(Math.abs(a1[0]-a1[1])-Math.abs(a2[0]-a2[1])));
        cook(1,1,arr[0][0],arr[0][1]);
        System.out.print(MIN);
    }

    public static void cook(int cnt, int start,long mul, long sum){
        MIN = Math.min(MIN,Math.abs((long)(mul-sum)));
        if(cnt==N) return;
        long sour = 0L;
        long bitt = 0L;
        for(int i = start; i < N; i++){
            if(visited[i]) continue;
            MIN = Math.min(MIN,Math.abs((long)(mul-sum)));
            visited[i] = true;
            sour = arr[i][0]*mul;
            bitt = arr[i][1]+sum;
            cook(cnt+1,start+1,sour,bitt);
            sour /= mul;
            bitt -= sum;
            visited[i] = false;
        }
    }
}
