import java.io.*;
import java.util.*;

public class Main_bj_2263_트리의순회 {

  static int n;
  static int[] inOrder, postOrder, preOrder;
  static int idx;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(br.readLine());

    inOrder = new int[n];
    postOrder = new int[n];
    preOrder = new int[n];

    String[] sarr = br.readLine().split(" ");
    for (int i = 0; i < n; i++)
      inOrder[i] = Integer.parseInt(sarr[i]);

    sarr = br.readLine().split(" ");
    for (int i = 0; i < n; i++)
      postOrder[i] = Integer.parseInt(sarr[i]);

    findPreOrder(0, n - 1, 0, n - 1);

    for (int n : preOrder)
      sb.append(n).append(" ");

    System.out.print(sb.toString());
  }

  public static void findPreOrder(int is, int ie, int ps, int pe) {

    if (is <= ie && ps <= pe) {
      preOrder[idx++] = postOrder[pe];
      for (int i = is; i <= ie; i++) {
        if (inOrder[i] == postOrder[pe]) {
          findPreOrder(is, i - 1, ps, ps + i - is - 1);
          findPreOrder(i + 1, ie, ps + i - is, pe - 1);
          break;
        }
      }

    }
  }
}