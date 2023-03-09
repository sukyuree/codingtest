import java.util.*;
import java.io.*;

public class Main_bj_9375_패션왕김태석 {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      HashMap<String, Set<String>> map = new HashMap<>();
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String type = st.nextToken();
        if (map.containsKey(type)) {
          map.get(type).add(s);
        } else {
          Set<String> set = new HashSet<>();
          set.add(s);
          map.put(type, set);
        }
      }

      int mul = 1;
      for (String key : map.keySet()) {
        int n = map.get(key).size() + 1;
        mul *= n;
      }
      sb.append(mul - 1).append("\n");
    }
    System.out.print(sb.toString());
  }
}
