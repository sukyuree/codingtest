import java.io.*;
import java.util.*;

public class Main_bj_6987_월드컵_서울_20반_김태석 {
    static int[] teamA = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] teamB = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static boolean flag;
    static int[][] teams;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        teams = new int[6][3];
        for(int t = 1; t <= 4; t++){
            flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int team = 0; team < 6; team++){
                teams[team][0] = Integer.parseInt(st.nextToken()); // win
                teams[team][1] = Integer.parseInt(st.nextToken()); // draw
                teams[team][2] = Integer.parseInt(st.nextToken()); // lose
            }

            verify(0);
            
            sb.append(flag?1:0).append(" ");
        }
        System.out.print(sb.toString());
    }
    static void verify(int cnt){
        if(cnt == 15){
            boolean localFlag = true;
            for(int i = 0; i < 6; i++){
                if(teams[i][0]!=0||teams[i][1]!=0||teams[i][2]!=0)
                    localFlag = false;
            }
            if(localFlag) flag = true;
            return;
        }
        int indexA = teamA[cnt];
        int indexB = teamB[cnt];
        // indexA 팀이 이길 경우
        teams[indexA][0]--;
        teams[indexB][2]--;
        verify(cnt+1);
        teams[indexA][0]++;
        teams[indexB][2]++;

        // 비길 경우
        teams[indexA][1]--;
        teams[indexB][1]--;
        verify(cnt+1);
        teams[indexA][1]++;
        teams[indexB][1]++;

        // 질 경우
        teams[indexA][2]--;
        teams[indexB][0]--;
        verify(cnt+1);
        teams[indexA][2]++;
        teams[indexB][0]++;
    }
}
