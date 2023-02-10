import java.util.*;
import java.io.*;

public class Solution_d3_1225_암호생성기_서울_20반_김태석 {
    static ArrayDeque<Integer> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        

        for(int t = 1; t <= 10; t++){
            br.readLine();
            q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                q.addLast(Integer.parseInt(st.nextToken()));
            }
            hashing();

            sb.append("#").append(t).append(" ");
            while(!q.isEmpty()) sb.append(q.pollFirst()).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void hashing(){
        int i=0;
        
        int num = Integer.MAX_VALUE;
        while(num!=0){
            int subNum = (i%5)+1;
            num = q.pollFirst() - subNum;
            if(num<=0){
                num = 0;
                q.addLast(num);
                break;
            }
            q.addLast(num);
            i++;
        }
    }
}
