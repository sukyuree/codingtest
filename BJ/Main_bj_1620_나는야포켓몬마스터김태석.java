import java.util.*;
import java.io.*;

public class Main_bj_1620_나는야포켓몬마스터김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String,Integer> m1 = new HashMap<>();
        Map<Integer,String> m2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            m1.put(s,i);
            m2.put(i,s);
        }

        for(int i = 0; i < M; i++){
            String s = br.readLine();
            try{
                int n = Integer.parseInt(s);
                sb.append(m2.get(n)).append("\n");
            }catch(Exception e){
                sb.append(m1.get(s)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
