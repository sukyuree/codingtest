import java.util.*;
import java.io.*;

public class BackJoon_1874{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int index = 1;
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            int number = Integer.parseInt(br.readLine());
            if(index<=number){
                for(int j = index; j <= number; j++){
                    deq.add(j);
                    sb.append("+").append("\n");
                }
                index = number+1;
                deq.removeLast();
                sb.append("-").append("\n");
            }
            else if(deq.getLast().equals(number)){
                sb.append("-").append("\n");
                deq.removeLast();
            }
            else{
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
        
        System.out.print(sb.toString());
    }
}