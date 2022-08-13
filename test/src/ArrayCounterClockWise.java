import java.util.*;
import java.io.*;

public class ArrayCounterClockWise {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int copyN = N;
        int copyM = M;
        int R = Integer.parseInt(st.nextToken());
        Integer[][] array = new Integer[N+1][M+1];
        int enumNumber = Math.min(N,M);
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int count = 0; count < R; count++){
            N = copyN;
            M = copyM;
            for(int depth = 1; depth <= enumNumber/2; depth++){
                int temp = array[depth][depth];
                
                //위쪽 반시계
                for(int m = depth; m < M; m++){
                    array[depth][m] = array[depth][m+1];
                }
                //오른쪽 반시계
                for(int n = depth; n < N; n++){
                    array[n][M] = array[n+1][M];
                }
                //아래쪽 반시계
                for(int m = M; m > depth; m--){
                    array[N][m] = array[N][m-1];
                }
                //왼쪽 반시계
                for(int n = N; n > depth; n--){
                    if(n-1 == depth) array[n][depth] = temp;
                    else array[n][depth] = array[n-1][depth];
                }
                N = N-1;
                M = M-1;
            }
        }

        for(int i = 1; i <= copyN; i++){
            for(int j = 1; j <= copyM; j++){
                System.out.print(array[i][j]+" ");
                if(j == copyM) System.out.println();
            }
        }
    }
    
}
