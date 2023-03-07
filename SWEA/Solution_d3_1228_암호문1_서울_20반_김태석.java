import java.util.*;
import java.io.*;

public class Solution_d3_1228_암호문1_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            br.readLine();
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens())
                list.add(Integer.parseInt(st.nextToken()));

            int orderSize = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= orderSize; i++){
                st.nextToken();
                int index = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                for(int j = 1; j <= num; j++){
                    int n = Integer.parseInt(st.nextToken());
                    list.add(index++,n);
                }
            }
            sb.append("#").append(t).append(" ");
            for(int i = 0 ; i < 10; i++) sb.append(list.get(i)).append(" "); 
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    
}
