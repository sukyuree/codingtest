import java.io.*;
import java.util.*;

public class Solution_프로세서연결하기_서울_20반_김태석 {
  static int N;
  static int[][] map;
  static List<int[]> cores;
  static int min;
  static int max;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for(int t = 1; t <= T; t++){
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];
      cores = new ArrayList<>();
      min = Integer.MAX_VALUE;
      max = Integer.MIN_VALUE;
      for(int i = 0 ; i < N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
          if(map[i][j]==1&&i!=N-1&&j!=N-1&&i!=0&&j!=0) cores.add(new int[]{i,j});
        }
      }
      dfs(0,0,map);
      sb.append("#"+t+" ").append(min).append("\n");
    }
    System.out.println(sb.toString());
  }

  static void dfs(int index, int count, int[][] map){
    if(index == cores.size()){
      if(count>max){
        //System.out.println("HI");
        max = count;
        min = lengthCounting(map);
      }
      else if(count==max){
        min = Math.min(min,lengthCounting(map));
      }
      return;
    }
    int y = cores.get(index)[0];
    int x = cores.get(index)[1];
    if(checkDown(y, x, map)) dfs(index+1, count+1, drawDown(y, x, map));
    if(checkUp(y, x, map)) dfs(index+1, count+1, drawUp(y, x, map));
    if(checkLeft(y, x, map)) dfs(index+1, count+1, drawLeft(y, x, map));
    if(checkRight(y, x, map)) dfs(index+1, count+1, drawRight(y, x, map));
    dfs(index+1, count, map);
  }
  static int lengthCounting(int[][] map){
    int length = 0;
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        if(map[i][j]==2) length++;
      }
    }
    //System.out.println(length);
    return length;
  }
  
  static int[][] mapCopy(int[][] map){
    int[][] temp = new int[N][N];
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        temp[i][j] = map[i][j];
      }
    }
    return temp;
  }
  static boolean checkLeft(int y, int x, int[][]map){
    if(x==0) return false;
    for(int j = x-1; j >=0; j--){
      if(map[y][j]!=0) return false;
    }
    return true;
  }
  static boolean checkRight(int y, int x, int[][]map){
    if(x==N-1) return false;
    for(int j = x+1; j < N; j++){
      if(map[y][j]!=0) return false;
    }
    return true;
  }
  static boolean checkUp(int y, int x, int[][]map){
    if(y==0) return false;
    for(int i = y-1; i >= 0; i--){
      if(map[i][x]!=0) return false;
    }
    return true;
  }
  static boolean checkDown(int y, int x, int[][]map){
    if(y==N-1) return false;
    for(int i = y+1; i < N; i++){
      if(map[i][x]!=0) return false;
    }
    return true;
  }
  static int[][] drawLeft(int y, int x, int[][]map){
    int[][] temp = mapCopy(map);
    for(int j = x-1; j >=0; j--){
      temp[y][j]=2;
    }
    return temp;
  }
  static int[][] drawRight(int y, int x, int[][]map){
    int[][] temp = mapCopy(map);
    for(int j = x+1; j < N; j++){
      temp[y][j]=2;
    }
    return temp;
  }
  static int[][] drawUp(int y, int x, int[][]map){
    int[][] temp = mapCopy(map);
    for(int i = y-1; i >= 0; i--){
      temp[i][x]=2;
    }
    return temp;
  }
  static int[][] drawDown(int y, int x, int[][]map){
    int[][] temp = mapCopy(map);
    for(int i = y+1; i < N; i++){
      temp[i][x]=2;
    }
    return temp;
  }
}
