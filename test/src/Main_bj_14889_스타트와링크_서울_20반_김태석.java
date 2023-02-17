import java.io.*;
import java.util.*;

public class Main_bj_14889_스타트와링크_서울_20반_김태석 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;

        comb(0,0);

        System.out.println(min);
    }
    
    static void cal() {
        int sumA =0;
        int sumB =0;
        
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {            
                if(visited[i] && visited[j]) {
                    sumA+= (arr[i][j] + arr[j][i]);
                }else if(!visited[i] && !visited[j]) {
                    sumB+=(arr[i][j] + arr[j][i]);
                }
                
            }
        }
        
        min = Math.min(Math.abs(sumA-sumB), min);
    }
    
    static void comb(int cnt, int start) {
        if(cnt==N/2) {
            cal();
            return;
        }
        for(int i=start;i<N;i++) {
            visited[i] = true;
            comb(cnt+1, i+1);
            visited[i] = false;
        }
    }
}
