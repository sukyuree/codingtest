import java.io.*;

public class Solution_d4_1227_미로2_서울_20반_김태석_dfs {
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
    static int isDetination;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t= 1; t <= 10; t++){
            br.readLine();
            isDetination = 0;
            board = new char[100][100];
            visited = new boolean[100][100];
            for(int i = 0; i < 100; i++){
                board[i] = br.readLine().toCharArray();
            }
            dfs(1,1);
            sb.append("#").append(t).append(" ").append(isDetination).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int i, int j){
        if(board[i][j]=='3'){
            isDetination = 1;
            return;
        }
        visited[i][j] = true;
        for(int d = 0; d < 4; d++){
            int nx = j + dx[d];
            int ny = i + dy[d];
            if(nx>=0&&nx<100&&ny>=0&&ny<100
            && !visited[ny][nx] && board[ny][nx]!='1'){
                dfs(ny,nx);
            }
        }
    }
}
