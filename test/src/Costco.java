import java.io.*;
import java.util.*;

public class Costco{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int Total = Integer.parseInt(st.nextToken());
        int Sum = 0;
        st = new StringTokenizer(br.readLine());
        int howmany = Integer.parseInt(st.nextToken());
        for(int i = 0; i < howmany; i++){
            st = new StringTokenizer(br.readLine());
            Sum += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }
        if(Sum == Total) System.out.println("Yes");
        else System.out.println("No");
    }
}