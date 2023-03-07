import java.util.*;
import java.io.*;

public class BackJoon_11729 {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    static void hanoi(int n, int from, int mid, int to){
        if(n==0) return;
        
        hanoi(n-1,from,to,mid);
        sb.append(from).append(" ").append(to).append("\n");
        count++;
        hanoi(n-1,mid,from,to);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        hanoi(K,1,2,3);
        System.out.println(count);
        System.out.print(sb.toString());
    }
}
