import java.util.*;
import java.io.*;

public class Main_bj_5430_AC {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder mainSB = new StringBuilder();
    StringTokenizer st;
    ArrayDeque<Integer> deq;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      String orderSet = br.readLine();
      int len = Integer.parseInt(br.readLine());
      deq = new ArrayDeque<>();
      st = new StringTokenizer(br.readLine(), "[],");
      for (int i = 0; i < len; i++) {
        deq.add(Integer.parseInt(st.nextToken()));
      }

      boolean flag = true;

      boolean currentState = true; // true면 q , false면 statck

      for (int i = 0; i < orderSet.length(); i++) {
        char c = orderSet.charAt(i);
        if (c == 'R') {
          currentState = !currentState;
        } else {
          if (deq.isEmpty()) {
            mainSB.append("error").append("\n");
            flag = false;
            break;
          } else if (currentState)
            deq.pollFirst();
          else
            deq.pollLast();
        }
      }

      if (flag) {
        mainSB.append("[");
        while (!deq.isEmpty()) {
          if (currentState)
            mainSB.append(deq.pollFirst());
          else
            mainSB.append(deq.pollLast());

          if (deq.isEmpty())
            continue;
          mainSB.append(",");
        }
        mainSB.append("]");
        mainSB.append("\n");
      }
    }
    System.out.print(mainSB.toString());
  }
}
