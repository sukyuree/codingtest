import java.io.*;
import java.util.*;

public class Main_bj_15683_감시 {
    static int N,M;
    static int min;
    static List<int[]> cctvList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        cctvList = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0&&map[i][j]!=6) cctvList.add(new int[]{i,j});
            }
        }
        
        dfs(0,map);

        System.out.print(min);
    }

    static void dfs(int cnt, int[][] map){
        if(cnt == cctvList.size()){
            min = Math.min(min,countBlindSpot(map));
            return;
        }
        int[] cctv = cctvList.get(cnt);
        int y = cctv[0];
        int x = cctv[1];
        int[][] tempMap;
        switch(map[y][x]){
            case(1) : 
                tempMap = mapCopy(map);
                seeRight(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeDown(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeLeft(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeUp(tempMap,y,x);
                dfs(cnt+1,tempMap);
                break;
            case(2) : 
                tempMap = mapCopy(map);
                seeRight(tempMap,y,x);
                seeLeft(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeUp(tempMap,y,x);
                seeDown(tempMap,y,x);
                dfs(cnt+1,tempMap);
                break;
            case(3) : 
                tempMap = mapCopy(map);
                seeUp(tempMap,y,x);
                seeRight(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeRight(tempMap,y,x);
                seeDown(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeDown(tempMap,y,x);
                seeLeft(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeLeft(tempMap,y,x);
                seeUp(tempMap,y,x);
                dfs(cnt+1,tempMap);
                break;
            case(4) : 
                tempMap = mapCopy(map);
                seeUp(tempMap,y,x);
                seeRight(tempMap,y,x);
                seeDown(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeUp(tempMap,y,x);
                seeRight(tempMap,y,x);
                seeLeft(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeUp(tempMap,y,x);
                seeDown(tempMap,y,x);
                seeLeft(tempMap,y,x);
                dfs(cnt+1,tempMap);

                tempMap = mapCopy(map);
                seeRight(tempMap,y,x);
                seeDown(tempMap,y,x);
                seeLeft(tempMap,y,x);
                dfs(cnt+1,tempMap);
                break;
            case(5) : 
                tempMap = mapCopy(map);
                seeUp(tempMap,y,x);
                seeRight(tempMap,y,x);
                seeDown(tempMap,y,x);
                seeLeft(tempMap,y,x);
                dfs(cnt+1,tempMap);
                break;
        }
    }

    static void seeRight(int[][]map, int i, int j){
        for(int x = j+1; x < M; x++){
            if(map[i][x]==6) break;
            if(map[i][x]==0) map[i][x] = -1;
        }
    }

    static void seeLeft(int[][]map, int i , int j){
        for(int x = j-1; x >= 0; x--){
            if(map[i][x]==6) break;
            if(map[i][x]==0) map[i][x] = -1;
        }
    }

    static void seeUp(int[][]map, int i, int j){
        for(int y = i-1; y >= 0; y--){
            if(map[y][j]==6) break;
            if(map[y][j]==0) map[y][j] = -1;
        }
    }

    static void seeDown(int[][]map, int i , int j){
        for(int y = i+1; y < N; y++){
            if(map[y][j]==6) break;
            if(map[y][j]==0) map[y][j] = -1;
        }
    }

    static int[][] mapCopy(int[][] map){
        int[][] tempMap = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                tempMap[i][j] = map[i][j];
            }
        }
        return tempMap;
    }

    static int countBlindSpot(int[][] map){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0) count++;
            }
        }
        return count;
    }
}
