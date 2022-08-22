import java.util.*;
import java.io.*;

public class GasStill {
    static int R;
    static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Boolean[][] map = new Boolean[R+1][C+1];

        for(int i = 1; i <= R; i++){
            st = new StringTokenizer(br.readLine(),".|x",true);
            for(int j = 1; j <= C; j++){
                if(st.nextToken().equals(".")) map[i][j] = true;
                else map[i][j] = false;
            }
        }

        int count = 0;
        for(int i = 1; i <= R; i++){
            //1열에서 시작 가능한곳부터 시작.
            if(dfs(map,i,1)){
                count++;
            }
        }
        //정답 출력
        System.out.println(count);
    }

    //배열 탐색 
    static boolean dfs(Boolean[][] map, int i, int j){
        map[i][j] = false;
        if(j == C) return true;

		// if(i > 1 && map[i-1][j+1])
		// 	if(dfs(map,i-1, j+1))
		// 		return true;
		// if(map[i][j+1])
		// 	if(dfs(map,i, j+1))
		// 		return true;
		// if(i < R && map[i+1][j+1])
		// 	if(dfs(map,i+1, j+1))
		// 		return true;

        if(i ==1){
            if(map[i][j+1]){
                if(dfs(map,i,j+1)) return true;
            }
            if(map[i+1][j+1]){
                if(dfs(map,i,j+1)) return true;
            }
        }

        if(i == R){
            if(map[i-1][j+1]){
                if(dfs(map,i-1,j+1)) return true;
            }
            if(map[i][j+1]){
                if(dfs(map,i,j+1)) return true;
            }
        }

        if(i<R&&1<i){
            if(map[i-1][j+1]){
                if(dfs(map,i-1,j+1)) return true;
            }
            if(map[i][j+1]){
                if(dfs(map,i,j+1)) return true;
            }
            if(map[i+1][j+1]){
                if(dfs(map,i+1,j+1)) return true;
            }
        }
        return false;
    }
}
