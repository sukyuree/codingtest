import java.util.*;
import java.io.*;

public class FindPrimeNumberAndItsSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        boolean flag = true;
        int min = 0;
        int sum = 0;
        for(int i = N; i <= M; i++){
            if(isPrime(i) && flag){
                sum += i;
                flag = false;
                min = i;
            }
            else if(isPrime(i) && !flag){
                sum +=i;
            }
        }
        if(!flag){
            System.out.println(sum);
            System.out.println(min);
        }
        else{
            System.out.println("-1");
        }
    }

    public static boolean isPrime(int number){
        if(number == 1) return false;

        for(int i = 2; i <= Math.sqrt((int)number); i++){
            if(number%i == 0) return false;
        }
        return true;
    }
    
}
