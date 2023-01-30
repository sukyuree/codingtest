import java.util.*;
import java.io.*;

public class Main_bj_15684_사다리조작_서울_20반_김태석 {
    static int N;
    static int M;
    static int H;
    static int ans;

    static int[][] ladder;

    static boolean isFinish = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H+1][N+1];
        //H는 점선 즉 가로축
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
            ladder[a][b+1] = -1;
        }

        // for(int i = 1; i <= H; i++){
        //     for(int j = 1; j < 2*N; j++){
        //         if(j%2 != 0) ladder[i][j] = 1;
        //     }
        // }
        
        // for(int i = 1; i <= H; i++){
        //     for(int j = 1; j < 2*N; j++){
        //         System.out.printf("%2d",ladder[i][j]);
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i <= 3; i++){
            ans = i;
            dfs(1,1,0);
            if(isFinish) break;
        }

        System.out.println((isFinish ? ans : -1));
        br.close();
    }

    public static void dfs(int x, int y, int addLine) {
        if(isFinish) return;

        if(ans == addLine){
            if(check()) isFinish = true;
            return;
        }

        for(int i = y; i <= H; i++){
            for(int j = x; j < N; j++){
                if(ladder[i][j]==0&&ladder[i][j+1]==0) {
                    ladder[i][j]=1;
                    ladder[i][j+1]=-1;

                    dfs(1,1,addLine+1);

                    ladder[i][j] = 0;
                    ladder[i][j+1] = 0;
                }
            }
        }
    }

    public static boolean check() {
        for(int i = 1; i <= N; i++){
            int y = 1;
            int x = i;

            while(y <= H){
                if(ladder[y][x]!=0) x+=ladder[y][x];
                y++;
            }

            if(x != i) return false;
        }
        return true;
    }
}
