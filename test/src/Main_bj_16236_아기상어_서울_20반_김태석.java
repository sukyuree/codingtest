import java.util.*;
import java.io.*;

class Shark{
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][] visited;
    int x;
    int y;
    int level = 2;
    int fishCount = 0;
    int distance = 0;
    boolean haveToCall = false;

    public Shark(int y, int x){
        this.y = y;
        this.x = x;
    }

    public void eat(){
        this.fishCount++;
        if(this.fishCount/level == 1) levelUp();
    }

    private void levelUp(){
        this.level += 1;
        fishCount = 0;
    }

    public void move(int[][] map){
        //if(!check(map)) return;
        int size = map[0].length;
        visited = new boolean[size][size];

        PriorityQueue<int[]> pq = new PriorityQueue<>((pq1,pq2)->{
            if(pq1[2]==pq2[2]&&pq2[0]==pq1[0]) return pq1[1]-pq2[1];
            if(pq1[2]==pq2[2]) return pq1[0] - pq2[0];
            return pq1[2] - pq2[2];
        });
        pq.offer(new int[]{this.y,this.x,0});
        visited[this.y][this.x] = true;
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int y = polled[0];
            int x = polled[1];
            int w = polled[2];

            if(map[y][x] != 0 && map[y][x] < this.level){
                distance += w;
                map[this.y][this.x] = 0;
                map[y][x] = 0;
                this.y = y;
                this.x = x;
                eat();
                return;
            }

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0&&ny<size&&nx>=0&&nx<size
                &&!visited[ny][nx]&&map[ny][nx] <= this.level){
                    pq.offer(new int[]{ny,nx,w+1});
                    visited[ny][nx] = true;
                }
            }
        }
        this.haveToCall = true;
    }

    // private boolean check(int[][] map){
    //     int count = 0;
    //     for(int i = 0; i < map[0].length; i++){
    //         for(int j = 0; j < map[0].length; j++){
    //             if(map[i][j]!=0&&map[i][j]<this.level) count++;
    //         }
    //     }
    //     return count==0?false:true;
    // }
}

public class Main_bj_16236_아기상어_서울_20반_김태석 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int sharkY = 0;
        int sharkX = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sharkX = j;
                    sharkY = i;
                }
            }
        }
        Shark shark = new Shark(sharkY,sharkX);
        while(!shark.haveToCall){
            shark.move(map);
        }
        System.out.print(shark.distance);
    }
}
