import java.io.*;
import java.util.*;

public class Solution_d3_6808_규영이와인영이의카드게임_서울_20반_김태석 {
    static int[] kCardSet;
    static int[] iCardSet;
    static int[] randomSet;
    static int win,lose;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            kCardSet = new int[9];
            iCardSet = new int[9];
            randomSet = new int[9];
            visited = new boolean[19];
            for(int i = 0; i < 9; i++){
                kCardSet[i] = Integer.parseInt(st.nextToken());
                visited[kCardSet[i]] = true;
            }
            for(int i = 0; i < 9; i++){
                for(int j = 1; j <= 18; j++){
                    if(!visited[j]){
                        iCardSet[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            win = 0; lose = 0;
            visited = new boolean[9];
            perm(0);

            sb.append("#"+t).append(" ").append(win+" "+lose).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void perm(int cnt){
        if(cnt == 9){
            int KyuYoung = 0;
            int InYoung = 0;
            for(int i = 0; i < 9; i++){
                if(kCardSet[i]>randomSet[i]) KyuYoung+=(kCardSet[i]+randomSet[i]);
                else InYoung+=(kCardSet[i]+randomSet[i]);
            }
            if(KyuYoung>InYoung) win++;
            else if(KyuYoung<InYoung) lose++;
            return;
        }
        for(int i = 0; i < 9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            randomSet[cnt] = iCardSet[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
