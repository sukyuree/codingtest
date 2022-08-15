import java.util.*;
import java.io.*;

public class NumSorting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int[] countlist = new int[10001];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            countlist[index] += 1;
        }

        for(int i = 1; i < 10001; i++){
            if(countlist[i] != 0){
                for(int j = 1; j <= countlist[i]; j++){
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
