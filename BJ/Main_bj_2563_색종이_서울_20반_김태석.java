import java.util.*;
import java.io.*;

public class Main_bj_2563_색종이_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[101][101];

        int area = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int dy = y; dy <= y+9; dy++){
                for(int dx = x; dx <= x+9; dx++){
                    if(!board[dy][dx]){
                        board[dy][dx] = true;
                        area++;
                    }
                }
            }
        }
        
        System.out.println(area);
    }

}