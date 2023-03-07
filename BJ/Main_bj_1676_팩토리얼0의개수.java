import java.util.*;
import java.io.*;

public class Main_bj_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i = 1; i <= 3; i++){
            if(Math.pow(5,i)<N){
                sum += N/Math.pow(5,i);
            }
        }
        System.out.print(sum);
    }
}
