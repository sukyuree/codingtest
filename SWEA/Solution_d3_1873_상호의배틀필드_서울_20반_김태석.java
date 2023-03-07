import java.io.*;
import java.util.*;

public class Solution_d3_1873_상호의배틀필드_서울_20반_김태석 {
    static int H,W,tankY,tankX,tankDy,tankDx;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];

            tankY = 0;
            tankX = 0;
            tankDy = 0;
            tankDx = 0;

            for(int i = 0; i < H; i++){
               String s = br.readLine();
                for(int j = 0; j < W; j++){
                    map[i][j] = s.charAt(j);
                    if(s.charAt(j)=='<'){
                        tankY=i; tankX=j; tankDy=0; tankDx=-1;
                    }
                    else if(s.charAt(j)=='>'){
                        tankY=i; tankX=j; tankDy=0; tankDx=1;
                    }
                    else if(s.charAt(j)=='^'){
                        tankY=i; tankX=j; tankDy=-1; tankDx=0;
                    }
                    else if(s.charAt(j)=='v'){
                        tankY=i; tankX=j; tankDy=1; tankDx=0;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());

            String order = br.readLine();

            for(int i = 0; i < N; i++){
                char c = order.charAt(i);

                switch(c){
                    case('U'):{
                        tankDx = 0;
                        tankDy = -1;
                        if(canMove()&&map[tankY+tankDy][tankX+tankDx]=='.'){
                            map[tankY][tankX] = '.';
                            tankY += tankDy;
                            tankX += tankDx;
                        }
                        map[tankY][tankX] = '^';
                        break;
                    }
                    case('D'):{
                        tankDx = 0;
                        tankDy = 1;
                        if(canMove()&&map[tankY+tankDy][tankX+tankDx]=='.'){
                            map[tankY][tankX] = '.';
                            tankY += tankDy;
                            tankX += tankDx;
                        }
                        map[tankY][tankX] = 'v';
                        break;
                    }
                    case('L'):{
                        tankDx = -1;
                        tankDy = 0;
                        if(canMove()&&map[tankY+tankDy][tankX+tankDx]=='.'){
                            map[tankY][tankX] = '.';
                            tankY += tankDy;
                            tankX += tankDx;
                        }
                        map[tankY][tankX] = '<';
                        break;
                    }
                    case('R'):{
                        tankDx = 1;
                        tankDy = 0;
                        if(canMove()&&map[tankY+tankDy][tankX+tankDx]=='.'){
                            map[tankY][tankX] = '.';
                            tankY += tankDy;
                            tankX += tankDx;
                        }
                        map[tankY][tankX] = '>';
                        break;
                    }
                    case('S'):{
                        int bombY = tankY+tankDy;
                        int bombX = tankX+tankDx;
                        while(bombY>=0&&bombY<H&&bombX>=0&&bombX<W){
                            if(map[bombY][bombX]=='*'){
                                map[bombY][bombX]='.';
                                break;
                            }
                            else if(map[bombY][bombX]=='#'){
                                break;
                            }
                            bombY += tankDy;
                            bombX += tankDx;
                        }
                    }
                }
            }

            sb.append("#"+t).append(" ");

            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static boolean canMove(){
        int ny = tankY+tankDy;
        int nx = tankX+tankDx;
        if(ny>=0&&ny<H&&nx>=0&&nx<W) return true;
        return false;
    }
}
