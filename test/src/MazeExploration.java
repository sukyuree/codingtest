import java.util.*;
import java.io.*;

public class MazeExploration {

    static boolean[][] visited;
    static boolean[][] graph;
    static int[][] count;
    static node tempNode = new node();
    static Queue<node> q = new LinkedList<>();
    static int N,M = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1][M+1];
        graph = new boolean[N+1][M+1];
        count = new int[N+1][M+1];
        for(int i = 1; i <=N; i++){
            st = new StringTokenizer(br.readLine(),"1|0",true);
            for(int j = 1; j <=M; j++){
                if(Integer.parseInt(st.nextToken())==1) graph[i][j] = true;
            }
        }
        int least = BFS();
        System.out.println(least);
    }

    public static void rightCheck(int i, int j){
        if(graph[i][j+1]&&!visited[i][j+1]){
            node temp = new node();
            temp.i = i;
            temp.j = j+1;
            q.offer(temp);
            visited[i][j+1] = true;
            count[i][j+1] = count[i][j]+1;
        }
    }
    public static void leftCheck(int i, int j){
        if(graph[i][j-1]&&!visited[i][j-1]){
            node temp = new node();
            temp.i = i;
            temp.j = j-1;
            q.offer(temp);
            visited[i][j-1] = true;
            count[i][j-1] = count[i][j]+1;
        }
    }
    public static void upCheck(int i, int j){
        if(graph[i-1][j]&&!visited[i-1][j]){
            node temp = new node();
            temp.i = i-1;
            temp.j = j;
            q.offer(temp);
            visited[i-1][j] = true;
            count[i-1][j] = count[i][j]+1;
        }
    }
    public static void downCheck(int i, int j){
        if(graph[i+1][j]&&!visited[i+1][j]){
            node temp = new node();
            temp.i = i+1;
            temp.j = j;
            q.offer(temp);
            visited[i+1][j] = true;
            count[i+1][j] = count[i][j]+1;
        }
    }
    public static int BFS(){
        count[1][1] = 1;
        tempNode.i = 1;
        tempNode.j = 1;
        visited[1][1] = true;
        q.offer(tempNode);
        while(!q.isEmpty()) {
			tempNode = q.poll();
            int i = tempNode.i;
            int j = tempNode.j;
			if(i==N && j==M) break;

			if(i==1&&j==1){
                rightCheck(i, j);
                downCheck(i, j);
            }
            //1,M일때 오른쪽 위쪽 불가
            if(i==1&&j==M){
                leftCheck(i, j);
                downCheck(i, j);
            }
            //1,1~M사이일때 위쪽 불가
            if(i==1&&j!=1&&j!=M){
                leftCheck(i, j);
                rightCheck(i, j);
                downCheck(i, j);
            }
            //N,1일때 왼쪽 아래쪽 불가
            if(i==N&&j==1){
                rightCheck(i, j);
                upCheck(i, j);
            }
            //N,M일때 오른쪽 아래쪽 불가
            if(i==N&&j==M){
                upCheck(i, j);
                leftCheck(i, j);
            }
            //N,1~M사이일때 아래쪽 불가
            if(i==N&&j!=1&&j!=M){
                upCheck(i, j);
                rightCheck(i, j);
                leftCheck(i, j);
            }
            //1~N사이,1일때 왼쪽 불가
            if(j==1&&i!=1&&i!=N){
                rightCheck(i, j);
                upCheck(i, j);
                downCheck(i, j);
            }
            //1~N사이,M일때 오른쪽 불가
            if(j==M&&i!=1&&i!=N){
                leftCheck(i, j);
                upCheck(i, j);
                downCheck(i, j);
            }
            //나머지 네방향 다 가능
            if(i!=1&&i!=N&&j!=1&&j!=M){
                //왼쪽체크
                leftCheck(i,j);
                //오른쪽체크
                rightCheck(i,j);
                //위쪽체크
                upCheck(i, j);
                //아래쪽체크
                downCheck(i, j);
			}
		}
        return count[N][M];
    }
}

class node{
    int i;
    int j;
}
