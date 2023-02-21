import java.io.*;
import java.util.*;

public class Main_bj_1764_듣보잡 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String,Integer> m = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String key = br.readLine();
            m.put(key,m.getOrDefault(key, 0)+1);
        }

        for(int i = 0; i < M; i++){
            String key = br.readLine();
            m.put(key,m.getOrDefault(key, 0)+1);
        }
        
        int count = 0;
        List<String> list = new ArrayList<>();
        for(String s : m.keySet()){
            if(m.get(s)==2){
                count++;
                list.add(s);
            } 
        }
        StringBuilder sb= new StringBuilder();
        Collections.sort(list);
        sb.append(count).append("\n");
        for(String s : list){
            sb.append(s).append("\n");
        }

        System.out.print(sb.toString());
    }
}
