import java.io.*;
import java.util.*;

public class Main_bj_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String,String> m = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            m.put(key,value);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String key = br.readLine();
            sb.append(m.get(key)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
