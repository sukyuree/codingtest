import java.io.*;
import java.util.*;

public class Main_bj_14891_톱니바퀴_서울_20반_김태석 {

  static String[] gear;
  static boolean[] isSpin;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    gear = new String[5];
    for (int i = 1; i <= 4; i++) {
      gear[i] = br.readLine();
    }
  
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int index = Integer.parseInt(st.nextToken());
      int direction = Integer.parseInt(st.nextToken());
      chain(index, direction);
    }

    System.out.println(getPoint());
  }
  
  static void chain(int index, int direction) {
    isSpin = new boolean[5];
    switch (index) {
      case (1):
        spinGear1(direction);
        break;
      case (2):
        spinGear2(direction);
        break;
      case (3):
        spinGear3(direction);
        break;
      case (4):
        spinGear4(direction);
        break;
    }
  }
  
  static void spinGear1(int direction) {
    if (isSpin[1])
      return;
    isSpin[1] = true;
    boolean flag = false;
    if (gear[1].charAt(2) != gear[2].charAt(6))
      flag = true;
    spin(1, direction);
    if (flag)
      spinGear2(direction * -1);
  }

  static void spinGear2(int direction) {
    if (isSpin[2])
      return;
    isSpin[2] = true;
    boolean flag1 = false;
    boolean flag2 = false;
    if (gear[2].charAt(6) != gear[1].charAt(2))
      flag1 = true;
    if (gear[2].charAt(2) != gear[3].charAt(6))
      flag2 = true;
    spin(2, direction);
    if(flag1)
      spinGear1(direction * -1);
    if(flag2)
      spinGear3(direction * -1);
  }
  
  static void spinGear3(int direction) {
    if (isSpin[3])
      return;
    isSpin[3] = true;
    boolean flag1 = false;
    boolean flag2 = false;
    if (gear[2].charAt(2) != gear[3].charAt(6))
      flag1 = true;
    if (gear[3].charAt(2) != gear[4].charAt(6))
      flag2 = true;
    spin(3, direction);
    if (flag1)
      spinGear2(direction * -1);
    if(flag2)
      spinGear4(direction * -1);
  }
  
  static void spinGear4(int direction) {
    if (isSpin[4])
      return;
    isSpin[4] = true;
    boolean flag = false;
    if (gear[3].charAt(2) != gear[4].charAt(6))
      flag = true;
    spin(4, direction);
    if(flag) spinGear3(direction * -1);
  }

  static int getPoint() {
    int sum = 0;
    for (int i = 1; i <= 4; i++) {
      sum += gear[i].charAt(0) == '0' ? 0 : Math.pow(2, i - 1);
    }
    return sum;
  }

  static void spin(int index, int direction) {
    if (direction == 1)
      clockWise(index);
    else
      counterClockWise(index);
  }
  static void clockWise(int index) {
    char last = gear[index].charAt(7);
    gear[index] = last + gear[index].substring(0, 7);
  }
  
  static void counterClockWise(int index) {
    char first = gear[index].charAt(0);
    gear[index] = gear[index].substring(1, 8) + first;
  }
}
