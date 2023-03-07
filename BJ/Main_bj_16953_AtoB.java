import java.io.*;
import java.util.*;

public class Main_bj_16953_AtoB {
    static long A,B;
    static boolean flag;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        flag = false;

        dfs(A,1);

        System.out.print(flag ? count:-1);
    }

    static void dfs(long num, int cnt){
        if(num == B){
            flag = true;
            count = cnt;
            return;
        }
        if(num > B) return;

        dfs(num*2,cnt+1);

        StringBuilder sb = new StringBuilder();
        sb.append(num).append(1);
        dfs(Long.parseLong(sb.toString()),cnt+1);
    }
}
