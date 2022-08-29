import java.util.*;
import java.io.*;

public class ThreeDice {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        if(first == second && second == third){
            System.out.println(10000+first*1000);
        }
        else if(first == second){
            System.out.println(1000+first*100);
        }
        else if(second == third){
            System.out.println(1000+second*100);
        }
        else if(first == third){
            System.out.println(1000+third*100);
        }
        else{
            List<Integer> temp = new ArrayList<>();
            temp.add(first);
            temp.add(second);
            temp.add(third);
            temp.sort(Comparator.naturalOrder());
            System.out.println(temp.get(2)*100);
        }

    }
    
}
