import java.io.*;
import java.util.*;

public class Main_bj_16987_계란으로계란치기_서울_20반_김태석 {
    static final int S = 0;
    static final int W = 1;
    static int N;
    static int[][] eggs;
    static int max;
    static int[] temp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];
        max = Integer.MIN_VALUE;
        temp = new int[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        beatTheEgg(0, 0);
        System.out.print(max==Integer.MIN_VALUE?0:max);
        
    }

    static void beatTheEgg(int index, int count){
        if(index == N){
            max = Math.max(max,count);
            return;
        }
        if(eggs[index][S]<=0){
            beatTheEgg(index+1, count);
            return;
        }
        if(count==N-1){
            beatTheEgg(index+1, count);
            return;
        }

        int temp = count;
        // i = 0부터 시작. 3번 과정을 반복하기 때문
        for(int i = 0; i < N; i++){
            if(i == index) continue;
            if(eggs[i][S]<=0) continue;

            eggs[index][S] -= eggs[i][W];
            eggs[i][S] -= eggs[index][W];

            if(eggs[index][S]<=0) count++;
            if(eggs[i][S]<=0) count++;
            
            beatTheEgg(index+1,count);

            count = temp;
            eggs[index][S] += eggs[i][W];
            eggs[i][S] += eggs[index][W];
        }
    }
}
