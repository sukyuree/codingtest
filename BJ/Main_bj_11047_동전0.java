import java.io.*;
import java.util.*;

public class Main_bj_11047_동전0 {
    static int N,K;
    static int[] a;
    static int count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N];
        count = Integer.MAX_VALUE;
        visited = new boolean[N];

    }


}
