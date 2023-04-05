import java.io.*;
import java.util.*;

public class Main_bj_15961_회전초밥_서울_20반_김태석 {
  static int N,d,k,c;
  static int[] sushi;
  static int max;
  static int count;
  static int[] kindOfSushi; 
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    max = 0;
    
    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    kindOfSushi = new int[d+1];
    sushi = new int[N];
    for(int i = 0; i < N; i++){
      sushi[i] =  Integer.parseInt(br.readLine());
    }
    slidingWindow();
    System.out.print(max);
  }

  static void slidingWindow(){
    for(int i = 0; i < k; i++){
      if(kindOfSushi[sushi[i]]==0){
        count++;
      }
      kindOfSushi[sushi[i]]++;
    }
    serviceCheck();

    for(int i = 1; i < N; i++){
      moveLeft(i);
      fillRight((i+k-1)%N);
      serviceCheck();
    }
  }
  static void moveLeft(int index){
    kindOfSushi[sushi[index-1]]--; 
    if(kindOfSushi[sushi[index-1]]==0) count--;
  }

  static void serviceCheck(){
    boolean plus = false;
    if(kindOfSushi[c]==0){
      count++;
      plus = true;
    }
    max = Math.max(max,count);
    if(plus)count--;
  }

  static void fillRight(int index){
    if(kindOfSushi[sushi[index]]==0) count++;
    kindOfSushi[sushi[index]]++;
  }
}
