import java.util.*;
import java.io.*;

public class Main_bj_11723_집합 {
    static int[] arr = new int[20];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("all")||order.equals("empty")){
                lets(order,0);
                continue;
            }
            int num = Integer.parseInt(st.nextToken());
            lets(order,num);
        }
        System.out.print(sb.toString());
    }

    static void lets(String order, int num){
        switch(order){
            case("add") : if(arr[num-1]==0) arr[num-1] = num; break;
            case("remove") : arr[num-1] = 0; break;
            case("check") : sb.append((arr[num-1]!=0)?1:0).append("\n"); break;
            case("toggle") : arr[num-1] = (arr[num-1]!=0)?0:num; break;
            case("all") : for(int i = 1; i <= 20; i++) arr[i-1] = i; break;
            case("empty") : arr = new int[20]; break;
        }
    }
}
