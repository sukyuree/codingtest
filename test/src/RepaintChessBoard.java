import java.util.*;
import java.io.*;

public class RepaintChessBoard{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] Board = new int[N+1][M+1];
        int[][] sampleBoard1 = {{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},
                                {0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},
                                {0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},
                                {0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0}
                                };
        int[][] sampleBoard2 = {{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},
                                {1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},
                                {1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},
                                {1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},
                                {1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},
                                };

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(),"W|B",true);
            for(int j = 1; j <= M; j++){
                String thisToken = st.nextToken();
                if(thisToken.equals("B")) Board[i][j] = 1;
                else if(thisToken.equals("W")) Board[i][j] = 0;
            }
        }
        
        int min = 0;
        int finalMin = M*N;
        for(int i = 1; i <= N-7; i++){
            for(int j = 1; j <= M-7; j++){
                int sample1Min = 0;
                int sample2Min = 0;
                StringBuilder sb = new StringBuilder();
                for(int k = i; k <= i+7; k++){
                    for(int l = j; l <= j+7; l++){
                        sb.append(Board[k][l]);
                    }
                }
                
                st = new StringTokenizer(sb.toString(),"1|0",true);
                for(int p = 0; p < 8; p++){
                    for(int q = 0; q < 8; q++){
                        int BorW = Integer.parseInt(st.nextToken());
                        if(sampleBoard1[p][q]!=BorW) sample1Min++;
                        if(sampleBoard2[p][q]!=BorW) sample2Min++;
                    }
                }
                if(sample1Min>sample2Min) min = sample2Min;
                else min = sample1Min;

                if(min<finalMin) finalMin = min;
            }
        }
        System.out.println(finalMin);
    }
}