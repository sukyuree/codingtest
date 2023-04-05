import java.util.*;
import java.io.*;

public class Solution_d5_7793_오나의여신님_서울_20반_김태석 {
  static int N,M;
  static char[][] map;
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};
  static int min;
  static Queue<int[]> dq;
  static Queue<int[]> q;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for(int t = 1; t <= T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      q = new ArrayDeque<>();
      dq = new ArrayDeque<>();
      map = new char[N][M];
      min = Integer.MAX_VALUE;
      for(int i = 0; i < N; i++){
        String s = br.readLine();
        for(int j = 0; j < M; j++){
          map[i][j] = s.charAt(j);
          if(map[i][j]=='*'){
            dq.offer(new int[]{i,j});
          }
          else if(map[i][j]=='S'){
            q.offer(new int[]{i,j,0});
          }
        }
      }
      bfs();
      sb.append("#"+t+" ").append(min==Integer.MAX_VALUE?"GAME OVER":min).append("\n");
    }
    System.out.print(sb.toString());
  }

  static void bfs(){
    while(!q.isEmpty()){
      int dSize = dq.size();
      for(int i = 0; i < dSize; i++){
        int[] polled = dq.poll();
        int y = polled[0];
        int x = polled[1];
        for(int d = 0; d < 4; d++){
          int ny = y + dy[d];
          int nx = x + dx[d];
          if(ny>=0&&ny<N&&nx>=0&&nx<M && map[ny][nx]=='.'){
            dq.offer(new int[]{ny,nx});
            map[ny][nx]='*';
          }
        }
      }

      int size = q.size();
      for(int i = 0; i < size; i++){
        int[] polled = q.poll();
        int y = polled[0];
        int x = polled[1];
        int count = polled[2];
        for(int d = 0; d < 4; d++){
          int ny = y + dy[d];
          int nx = x + dx[d];
          if(ny>=0&&ny<N&&nx>=0&&nx<M){
            if(map[ny][nx]=='D'){
              min = Math.min(min,count+1);
              return;
            }
            else if(map[ny][nx]=='.'){
              map[ny][nx]='S';
              q.offer(new int[]{ny,nx,count+1});
            }
          }
        }
      }
    }
  }
}