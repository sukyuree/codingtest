import java.util.*;

public class FindPrimeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();

        for(int i = M; i <= N; i++){
            if(isPrime(i)) System.out.println(i);
        }
    }
    
    public static boolean isPrime(int i){
        if(i == 1) return false;
        for(int j = 2; j <= Math.sqrt(i); j++){
            if(i%j==0) return false;
        }
        return true;
    }
}
