import java.util.*;
import java.io.*;

public class Main_bj_2667_단지번호붙이기_서울_20반_김태석 {
    static ArrayList<Integer> list = new ArrayList<>();
    static char[][] board;
    static boolean[][] visited;
    static int N;
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]&&board[i][j]=='1') bfs(i,j);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i : list) sb.append(i).append("\n");
        System.out.print(sb.toString());
    }

    public static void bfs(int i, int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        int n = 0;
        while(!q.isEmpty()){
            int[] polled = q.poll();
            for(int d = 0; d < 4; d++){
                int ny = polled[0] + dy[d];
                int nx = polled[1] + dx[d];
                if(nx>=0&&nx<N&&ny>=0&&ny<N
                && !visited[ny][nx] && board[ny][nx]=='1'){
                    q.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
            n++;
        }
        list.add(n);
    }
}
