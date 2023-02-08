import java.io.*;
import java.util.*;

public class Solution_d4_1210_1210_Ladder_서울_20반_김태석{
    static int[][] ladder = new int[100][100];
    static int startX = 0, endX = 0;
    static int currentX = 0, currentY = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            br.readLine();
            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            findStartX();
            findEndX();
            sb.append("#").append(t).append(" ").append(endX).append("\n");
        }
        System.out.print(sb.toString());
    }

    //시작 지점의 x좌표 구하는 함수
    public static void findStartX(){
        for(int i = 0; i < 100; i++){
            if(ladder[99][i] == 2) startX = i;
        }
    }

    //도착 지점을 구하는 함수
    public static void findEndX(){
        currentX = startX;
        currentY = 98;
        while(currentY != 0){
            checkBothSides();
        }
        endX = currentX;
    }

    public static void checkBothSides(){
        if(currentX-1>=0&&ladder[currentY][currentX-1]==1){
            ladder[currentY][currentX] = -1;
            currentX--;
        }
        else if(currentX+1<100&&ladder[currentY][currentX+1]==1){
            ladder[currentY][currentX] = -1;
            currentX++;
        }
        else{
            ladder[currentY][currentX] = -1;
            currentY--;
        }
    }
}