import java.io.*;
import java.util.*;

public class Main_bj_1194_달이차오른다가자_서울_20반_김태석 {
  static int N, M;
  static char[][] map;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };
  static boolean[][][][][][][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    visited = new boolean[N][M][2][2][2][2][2][2];
    int startY = 0;
    int startX = 0;
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = s.charAt(j);
        if (map[i][j] == '0') {
          startY = i;
          startX = j;
        }
      }
    }
    System.out.print(bfs(startY, startX));
  }

  static int bfs(int startY, int startX) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[8] - pq2[8]);
    pq.offer(new int[] { 0, 0, 0, 0, 0, 0, startY, startX, 0 });
    visited[startY][startX][0][0][0][0][0][0] = true;
    while (!pq.isEmpty()) {
      int[] polled = pq.poll();
      int a = polled[0];
      int b = polled[1];
      int c = polled[2];
      int d = polled[3];
      int e = polled[4];
      int f = polled[5];
      int y = polled[6];
      int x = polled[7];
      int count = polled[8];

      

      for (int dd = 0; dd < 4; dd++) {
        int ny = y + dy[dd];
        int nx = x + dx[dd];
        if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != '#' && !visited[ny][nx][a][b][c][d][e][f]) {
          if(map[ny][nx]=='1') return count+1;

          if (map[ny][nx] >= 65 && map[ny][nx] <= 70) {
            if (polled[map[ny][nx] - 'A'] == 1) {
              pq.offer(new int[] { a,b,c,d,e,f,ny, nx, count + 1 });
            }
          }
          else if (map[ny][nx] >= 97) {
            int[] arr = {a,b,c,d,e,f,ny,nx,count+1};
            arr[map[ny][nx]-'a']=1;
            pq.offer(arr);
          }
          else{
            pq.offer(new int[] { a,b,c,d,e,f,ny, nx, count + 1 });
          }
          visited[ny][nx][a][b][c][d][e][f] = true;
        }
      }
    }
    return -1;
  }
}