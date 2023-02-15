import java.io.*;
import java.util.*;

public class Solution_d4_1233_사칙연산유효성검사_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            boolean canCalculate = true;
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                if(i>N/2){
                    if(isSymbol(st.nextToken().charAt(0))) canCalculate = false;
                }
                else{
                    String[] tokens = new String[3];
                    int index = 0;
                    while(st.hasMoreTokens()) tokens[index++] = st.nextToken();
    
                    if(tokens[0]!=null&&!isSymbol(tokens[0].charAt(0))) canCalculate = false;
    
                    if(tokens[1]!=null&&isSymbol(tokens[1].charAt(0))) canCalculate = false;
    
                    if(tokens[2]!=null&&isSymbol(tokens[2].charAt(0))) canCalculate = false;
                }
            }
            if(canCalculate) sb.append("#").append(t).append(" ").append(1).append("\n");
            else sb.append("#").append(t).append(" ").append(0).append("\n");
        }
        System.out.print(sb.toString());
    }
    // * : 42
    // + : 43
    // - : 45
    // / : 47
    public static boolean isSymbol(char c){
        int n = (int)c;
        if(n==42||n==43||n==45||n==47) return true;
        return false;
    }
}
