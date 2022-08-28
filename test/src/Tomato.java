import java.util.*;
import java.io.*;

public class Tomato {
    static int N,M;
    static int startX,startY;
    static int[][] graph;
    static ArrayList<Integer> temp;
    static Queue<ArrayList<Integer>> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int xy = Integer.parseInt(st.nextToken());
                if(xy == 1){
                    temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.offer(temp);
                }
                graph[i][j] = xy;
            }
        }
        
        int date = bfs();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j]==0){
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(date);

    }
    static void leftCheck(int x, int y){
        if(graph[x][y-1]==0){
            temp = new ArrayList<>();
            temp.add(x);
            temp.add(y-1);
            q.offer(temp);
            graph[x][y-1] = graph[x][y]+1;
        }
    }

    static void rightCheck(int x, int y){
        if(graph[x][y+1]==0){
            temp = new ArrayList<>();
            temp.add(x);
            temp.add(y+1);
            q.offer(temp);
            graph[x][y+1] = graph[x][y]+1;
        }
    }

    static void upCheck(int x, int y){
        if(graph[x-1][y]==0){
            temp = new ArrayList<>();
            temp.add(x-1);
            temp.add(y);
            q.offer(temp);
            graph[x-1][y] = graph[x][y]+1;
        }
    }

    static void downCheck(int x, int y){
        if(graph[x+1][y]==0){
            temp = new ArrayList<>();
            temp.add(x+1);
            temp.add(y);
            q.offer(temp);
            graph[x+1][y] = graph[x][y]+1;
        }
    }

    static int bfs(){
        int date = 0; 
        while(!q.isEmpty()){
            temp = q.poll();
            int x = temp.get(0);
            int y = temp.get(1);
            //System.out.println(x+" "+y);
            //1,1일때 왼쪽 위쪽 불가
            if(x==1&&y==1){
                rightCheck(x, y);
                downCheck(x, y);
                //if(graph[x][y+1]!=0&&graph[x+1][y]!=0) return -1;
            }
            //1,M일때 오른쪽 위쪽 불가
            if(x==1&&y==M){
                leftCheck(x, y);
                downCheck(x, y);
                //if(graph[x][y-1]!=0&&graph[x-1][y]!=0) return -1;
            }
            //1,1~M사이일때 위쪽 불가
            if(x==1&&y!=1&&y!=M){
                leftCheck(x, y);
                rightCheck(x, y);
                downCheck(x, y);
                //if(graph[x][y+1]!=0&&graph[x+1][y]!=0&&graph[x][y-1]!=0) return -1;
            }
            //N,1일때 왼쪽 아래쪽 불가
            if(x==N&&y==1){
                rightCheck(x, y);
                upCheck(x, y);
                //if(graph[x][y+1]!=0&&graph[x-1][y]!=0) return -1;
            }
            //N,M일때 오른쪽 아래쪽 불가
            if(x==N&&y==M){
                upCheck(x, y);
                leftCheck(x, y);
                //if(graph[x-1][y]!=0&&graph[x][y-1]!=0) return -1;
            }
            //N,1~M사이일때 아래쪽 불가
            if(x==N&&y!=1&&y!=M){
                upCheck(x, y);
                rightCheck(x, y);
                leftCheck(x, y);
                //if(graph[x][y+1]!=0&&graph[x-1][y]!=0&&graph[x][y-1]!=0) return -1;
            }
            //1~N사이,1일때 왼쪽 불가
            if(y==1&&x!=1&&x!=N){
                rightCheck(x, y);
                upCheck(x, y);
                downCheck(x, y);
                //if(graph[x][y+1]!=0&&graph[x-1][y]!=0&&graph[x+1][y]!=0) return -1;
            }
            //1~N사이,M일때 오른쪽 불가
            if(y==M&&x!=1&&x!=N){
                leftCheck(x, y);
                upCheck(x, y);
                downCheck(x, y);
                //if(graph[x-1][y]!=0&&graph[x+1][y]!=0&&graph[x][y-1]!=0) return -1;
            }
            //나머지 네방향 다 가능
            if(x!=1&&x!=N&&y!=1&&y!=M){
                //왼쪽체크
                leftCheck(x,y);
                //오른쪽체크
                rightCheck(x,y);
                //위쪽체크
                upCheck(x, y);
                //아래쪽체크
                downCheck(x, y);
                //if(graph[x-1][y]!=0&&graph[x+1][y]!=0&&graph[x][y-1]!=0&&graph[x][y-1]!=0) return -1;
            }
            date = graph[x][y];
        }

        return date-1;
    }
}
