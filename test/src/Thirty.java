import java.util.*;
import java.io.*;

public class Thirty {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"1|2|3|4|5|6|7|8|9|0",true);

        List<Integer> list = new ArrayList<>();

        int sum = 0;
        while(st.hasMoreTokens()){
            int k = Integer.parseInt(st.nextToken());
            list.add(k);
            sum+=k;
        }

        list.sort(Comparator.reverseOrder());

        int size = list.size();
        StringBuilder sb = new StringBuilder();
        if(list.get(size-1)!=0 || sum%3 != 0) System.out.println(-1);
        else {
            for(int i = 0; i < size; i++){
                sb.append(list.get(i));
            }
        }
        System.out.println(sb);

    }
    
}
