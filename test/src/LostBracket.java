import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LostBracket{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"+|-",true);
        List<Integer> Number = new ArrayList<>();
        List<String> PlusOrMinus = new ArrayList<>();
        int sum = 0;
        int sign = 1;
        while(st.hasMoreTokens()){
            Number.add(Integer.parseInt(st.nextToken()));
            if(st.hasMoreTokens()) PlusOrMinus.add(st.nextToken());
        }
        for(int i = 0; i<Number.size()-1; i++){
            sum += Number.get(i)*sign;
            if(PlusOrMinus.get(i).equals("-"))
                sign = -1;
        }
        sum += Number.get(Number.size()-1)*sign;
        System.out.println(sum);
    }
}