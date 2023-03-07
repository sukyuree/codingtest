import java.util.*;
import java.io.*;

public class Main_bj_16935_배열돌리기3_서울_20반_김태석{
    static int[][] input;
    static int temp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        input = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < R; i++){
            int optionNumber = Integer.parseInt(st.nextToken());
            rolling(optionNumber);
        }
        int column = input.length;
        int row = input[0].length;
        for(int i = 1; i < column; i++){
            for(int j = 1; j < row; j++){
                sb.append(input[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void rolling(int optionNumber){
        int N = input.length-1;
        int M = input[1].length-1;

        if(optionNumber == 1){
            for(int i = 1; i <= (N/2); i++){
                for(int j = 1; j <= M; j++){
                    temp = input[i][j];
                    input[i][j] = input[N-i+1][j];
                    input[N-i+1][j] = temp;
                }
            }
        }

        else if(optionNumber == 2){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= (M/2); j++){
                    temp = input[i][j];
                    input[i][j] = input[i][M-j+1];
                    input[i][M-j+1] = temp;
                }
            }

        }

        else if(optionNumber == 3){
            int[][] input_reverse = new int[M+1][N+1];
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    input_reverse[j][N-i+1] = input[i][j];
                }
            }
            input = input_reverse;
        }

        else if(optionNumber == 4){
            int[][] input_reverse = new int[M+1][N+1];
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    input_reverse[M-j+1][i] = input[i][j];
                }
            }
            input = input_reverse;
        }

        else if(optionNumber == 5){
            int[][] temp_array = new int[(N/2)+1][(M/2)+1];
            int n = 1;
            int m = 1;
            for(int i = (N/2)+1; i <= N; i++){
                m = 1;
                for(int j = 1; j <= (M/2); j++){
                    temp_array[n][m] = input[i][j];
                    m++;
                }
                n++;
            }

            n = (N/2)+1;
            for(int i = (N/2)+1; i <= N; i++){
                m = 1;
                for(int j = (M/2)+1; j <= M; j++){
                    input[n][m] = input[i][j];
                    m++;
                }
                n++;
            }

            n = (N/2)+1;
            for(int i = 1; i <= (N/2); i++){
                m = (M/2)+1;
                for(int j = (M/2)+1; j <= M; j++){
                    input[n][m] = input[i][j];
                    m++;
                }
                n++;
            }

            n = 1;
            for(int i = 1; i <= (N/2); i++){
                m = (M/2)+1;
                for(int j = 1; j <= (M/2); j++){
                    input[n][m] = input[i][j];
                    input[i][j] = temp_array[i][j];
                    m++;
                }
                n++;
            }
        }

        else if(optionNumber == 6){
            int[][] temp_array = new int[(N/2)+1][(M/2)+1];
            int n = 1;
            int m = 1;
            for(int i = 1; i <= (N/2); i++){
                for(int j = 1; j <= (M/2); j++){
                    temp_array[i][j] = input[i][j];
                }
            }

            // 2 -> 1
            for(int i = 1; i <= (N/2); i++){
                m = 1;
                for(int j = (M/2)+1; j <= M; j++){
                    input[n][m] = input[i][j];
                    m++;
                }
                n++;
            }

            // 3 -> 2
            n = 1;
            for(int i = (N/2)+1; i <= N; i++){
                m = (M/2)+1;
                for(int j = (M/2)+1; j <= M; j++){
                    input[n][m] = input[i][j];
                    m++;
                }
                n++;
            }
            
            // 4 -> 3
            n = (N/2)+1;
            for(int i = (N/2)+1; i <= N; i++){
                m = (M/2)+1;
                for(int j = 1; j <= (M/2); j++){
                    input[n][m] = input[i][j];
                    m++;
                }
                n++;
            }

            // 1 -> 4
            n = 1;
            for(int i = (N/2)+1; i <= N; i++){
                m=1;
                for(int j = 1; j <= (M/2); j++){
                    input[i][j] = temp_array[n][m];
                    m++;
                }
                n++;
            }
        }
    } 
}
