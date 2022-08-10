import java.util.*;

public class SelfNumber {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        int NthSum = 0;
        int temp = 0;

        for(int i = 1; i <= 10000; i++){
            NthSum = 0;
            temp = i;
            int Nth = (int)Math.log10(i);
            for(int j = Nth ; j>=0; j--){
                int a = temp/(int)Math.pow(10, j);
                NthSum += a;
                temp=temp-(a)*(int)Math.pow(10, j);
            }
            list.add(i+NthSum);
        }

        for(int i = 1; i <= 10000; i++){
            if(!list.contains(i)) System.out.println(i);
        }
    }
    
}
