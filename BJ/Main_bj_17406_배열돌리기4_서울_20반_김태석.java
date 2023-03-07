import java.util.*;
import java.io.*;

public class Main_bj_17406_배열돌리기4_서울_20반_김태석 {
    static int N, M, K;
    static int[][] arr;
    static int[][] arrCopy;
    static int min;
    static int[][] order;
    static int[][] orderCopy;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        arr = new int[N+1][M+1];
        order = new int[K][3];
        orderCopy = new int[K][3];
        visited = new boolean[K];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
            order[i][2] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.print(min);
    }

    public static void rolling(int r, int c, int s){
        int startY = r-s;
        int endY = r+s;
        int startX = c-s;
        int endX = c+s;
        int size = endY - startY;
        int temp = 0;
        while(size>1){
            temp = arrCopy[startY][startX];
            // 왼쪽라인
            for(int i = startY; i < endY; i++) arrCopy[i][startX] = arrCopy[i+1][startX];
            // 아래라인
            for(int i = startX; i < endX; i++) arrCopy[endY][i] = arrCopy[endY][i+1];
            // 오른쪽라인
            for(int i = endY; i > startY; i--) arrCopy[i][endX] = arrCopy[i-1][endX];
            // 윗라인
            for(int i = endX; i > startX; i--) arrCopy[startY][i] = arrCopy[startY][i-1];
            arrCopy[startY][startX+1] = temp;
            
            startX++; startY++; endX--; endY--;
            size = endY - startY;
        }
    }

    public static void perm(int cnt){
        if(cnt == K){

            arrCopy = new int[N+1][M+1];
            for(int i = 1; i <= N; i++){
                arrCopy[i] = arr[i].clone();
            }

            for(int i = 0; i < K; i++){
                rolling(orderCopy[i][0],orderCopy[i][1],orderCopy[i][2]);
            }
            int arrCopyMin = arrValue();
            min = Math.min(min,arrCopyMin);
            return;
        }

        for(int i = 0; i < K; i++){
            if(visited[i]) continue;
            visited[i] = true;
            orderCopy[cnt] = order[i];
            perm(cnt+1);
            visited[i] = false;
        }

    }

    public static int arrValue(){
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= M; j++){
                sum += arrCopy[i][j];
            }
            min = Math.min(min,sum);
        }
        return min;
    }
}
