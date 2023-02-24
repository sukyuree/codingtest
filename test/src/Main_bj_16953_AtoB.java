import java.io.*;
import java.util.*;

public class Main_bj_16953_AtoB {
    static int A,B;
    static boolean flag;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        flag = false;

        dfs(A,1);

        System.out.print(flag ? count:-1);
    }

    static void dfs(int num, int cnt){
        if(num == B){
            flag = true;
            count = cnt;
            return;
        }
        if(num > B) return;

        dfs(num*2,cnt+1);

        StringBuilder sb = new StringBuilder();
        sb.append(num).append(1);
        dfs(Integer.parseInt(sb.toString()),cnt+1);
    }
}
