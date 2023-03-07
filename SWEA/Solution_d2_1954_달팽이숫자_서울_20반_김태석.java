import java.util.*;
import java.io.*;

public class Solution_d2_1954_달팽이숫자_서울_20반_김태석 {
    static int[][] arr;
    static int size;
    
    static int d;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int currentX,currentY;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append("\n");
            size = Integer.parseInt(br.readLine());
            arr = new int[size][size];
            makeSnailArr();
            print();
        }
        System.out.print(sb.toString());
    }
    
    public static void makeSnailArr(){
        int totalSize = size*size;
        d = 0;
        currentX = -1;
        currentY = 0;
        for(int i = 1; i <= totalSize; i++){
            moveAndFill(i);
        }
    }

    public static void moveAndFill(int i){
        if(currentX+dx[d%4]>=0&&currentX+dx[d%4]<size
         &&currentY+dy[d%4]>=0&&currentY+dy[d%4]<size
         &&arr[currentY+dy[d%4]][currentX+dx[d%4]]==0){
            currentX += dx[d%4];
            currentY += dy[d%4];
         }
         else{
            d++;
            currentX += dx[d%4];
            currentY += dy[d%4];
         }
         arr[currentY][currentX] = i;
    }

    public static void print(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
}
