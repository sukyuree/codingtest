import java.io.*;
import java.util.*;

public class Main_bj_2023_신기한소수_서울_20반_김태석 {
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        interestingPrimeNum("2");
        interestingPrimeNum("3");
        interestingPrimeNum("5");
        interestingPrimeNum("7");
 
        System.out.print(sb);
    }

    public static void interestingPrimeNum(String s){
        if(s.length()==N){
            if(isPrime(Integer.parseInt(s))) sb.append(s).append("\n");
            return;
        }
        for(int i = 1; i <= 9; i+=2){
            if(isPrime(Integer.parseInt(s+i))) interestingPrimeNum(s+i);
        }
    }

    public static boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i <= (int)Math.sqrt(n); i++) if(n%i == 0) return false;
        return true;
    }
}
