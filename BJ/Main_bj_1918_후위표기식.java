import java.io.*;
import java.util.*;

public class Main_bj_1918_후위표기식 {
  static ArrayDeque<String> stack = new ArrayDeque<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), "*|(|)|+|-|/", true);

    while (st.hasMoreTokens()) {
      String s = st.nextToken();
      switch (s) {
        case "(":
          stack.push(s);
          break;
        case ")":
          while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
              stack.pop();
              break;
            }
            sb.append(stack.pop());
          }
          break;
        case "*":
          if (stack.isEmpty())
            stack.push(s);
          else {
            checkAndAdd1();
            stack.push(s);
          }
          break;
        case "/":
          if (stack.isEmpty())
            stack.push(s);
          else {
            checkAndAdd1();
            stack.push(s);
          }
          break;
        case "+":
          if (stack.isEmpty())
            stack.push(s);
          else {
            checkAndAdd2();
            stack.push(s);
          }
          break;
        case "-":
          if (stack.isEmpty())
            stack.push(s);
          else {
            checkAndAdd2();
            stack.push(s);
          }
          break;
        default:
          sb.append(s);
          break;
      }
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    System.out.println(sb.toString());
  }

  static void checkAndAdd1() {
    if (stack.isEmpty())
      return;
    while (stack.peek().equals("*") || stack.peek().equals("/")) {
      sb.append(stack.pop());
      if (stack.isEmpty())
        return;
    }
  }

  static void checkAndAdd2() {
    while (stack.peek().equals("*") || stack.peek().equals("/") ||
        stack.peek().equals("-") || stack.peek().equals("+")) {
      sb.append(stack.pop());
      if (stack.isEmpty())
        return;
    }
  }
}
