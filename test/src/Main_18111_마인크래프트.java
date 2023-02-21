import java.util.*;
import java.io.*;

public class Main_18111_마인크래프트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] field = new int[N][M];
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                highest = Math.max(highest,field[i][j]);
                lowest = Math.min(lowest,field[i][j]);
            }
        }

        int min = Integer.MAX_VALUE;
        int height = 0;
        for(int h = lowest; h <= highest; h++){
            int time = 0;
            int block = B;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    int dif = field[i][j]-h;
                    if(dif==0) continue;

                    else if(dif>0){
                        block += dif;
                        time += dif*2;
                    }
                    else if(dif<0){
                        block += dif;
                        time -= dif;
                    }
                    
                }
            }
            if(block<0) continue;
            if(time<=min){
                min = time;
                height = h;
            }
        }
        System.out.print(min+" "+height);
    }

}
