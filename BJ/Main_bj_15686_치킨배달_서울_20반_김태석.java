import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달_서울_20반_김태석 {
    static int N,M;
    static int[][] board;
    static int numOfChickenShop;
    static int min;
    static int[][] chickenXY;
    static int[][] aliveChicken;
    static List<int[]> shopList = new ArrayList<>();
    static List<int[]> homeList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        numOfChickenShop = 0;
        min = Integer.MAX_VALUE;
        aliveChicken = new int[M][2];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2){
                    numOfChickenShop++;
                    shopList.add(new int[]{i,j});
                }
                else if(board[i][j]==1){
                    homeList.add(new int[]{i,j});
                }
            }
        }
        chickenXY = shopList.toArray(new int[0][0]);

        comb(0,0);

        System.out.print(min);
    }

    public static void comb(int cnt, int start){
        if(cnt == M){
            int sum = 0;
            for(int i = 0; i < homeList.size(); i++){
                int y = homeList.get(i)[0];
                int x = homeList.get(i)[1];
                int minValue = Integer.MAX_VALUE;
                for(int j = 0; j < aliveChicken.length; j++){
                    int cy = aliveChicken[j][0];
                    int cx = aliveChicken[j][1];
                    minValue = Math.min(minValue,Math.abs(y-cy)+Math.abs(x-cx));
                }
                sum+=minValue;
            }
            min = Math.min(min,sum);
            return;
        }

        for(int i = start; i < numOfChickenShop; i++){
            aliveChicken[cnt] = chickenXY[i];
            comb(cnt+1,i+1);
        }
    }
}
