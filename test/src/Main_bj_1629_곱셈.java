import java.util.*;
import java.io.*;

public class Main_bj_1629_곱셈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
  
        System.out.print(cal(A,B,C));
        
    }
    static long cal(long a, long b, long c){
        if(b==1) return a%c;

        long calcul = cal(a,b/2,c);

        if(b%2==1) return (calcul*calcul%c)*a%c;
        return calcul*calcul%c;
    }
}
