import java.io.*;
import java.util.*;

public class Main_bj_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> qMap = new TreeMap<>();

            for (int k = 1; k <= K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (s.equals("I")) {
                    qMap.put(num, qMap.getOrDefault(num, 0) + 1);
                }
                else {
                    if (qMap.size() == 0)
                        continue;

                    int n = (num == 1) ? qMap.lastKey() : qMap.firstKey();
                    if (qMap.put(n, qMap.get(n) - 1) == 1)
                        qMap.remove(n);
                }
            }
            sb.append((qMap.size() == 0 ? "EMPTY\n" : qMap.lastKey() + " " + qMap.firstKey()+"\n"));
        }
        System.out.print(sb.toString());
    }
}
