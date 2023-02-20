import java.io.*;

public class Main_bj_1992_쿼드트리_서울_20반_김태석 {
    static int[][] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        dfs(0,0,N);
        System.out.print(sb.toString());
    }

    public static void dfs(int r, int c, int size){
        int sum = 0 ;
        
        for(int i = r, rEnd = r+size; i < rEnd; i++){
            for(int j = c, cEnd = c+size; j < cEnd; j++){
                sum += arr[i][j];
            }
        }
        if(sum == size * size){
            sb.append(1);
        }
        else if(sum == 0) {
            sb.append(0);
        }
        else{
            sb.append("(");
            int half = size/2;
            dfs(r, c, half);
			dfs(r, c+half,  half);
			dfs(r+half, c, half);
			dfs(r+half, c+half, half);
            sb.append(")");
        }
        
    }
}