import java.util.*;
import java.io.*;

public class Main_bj_1987_알파벳_서울_20반_김태석 {
    static int R,C,max=1;
    static boolean[] visited = new boolean[26];
    static char[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        visited[map[0][0]-65] = true;

        dfs(0,0,1);

        System.out.print(max);
        
    }

    static void dfs(int i, int j, int count){
        max = Math.max(max,count);
        int y = i;
        int x = j;
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny>=0&&ny<R&&nx>=0&&nx<C
            &&!visited[map[ny][nx]-65]){
                visited[map[ny][nx]-65] = true;
                dfs(ny,nx,count+1);
                visited[map[ny][nx]-65] = false;
            }
        }
    }
}
