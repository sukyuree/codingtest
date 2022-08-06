import java.util.*;

public class Decomposition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        sc.close();
        int NthSum = 0;
        int temp = 0;
        for(int i = 1; i<N; i++){
            NthSum = 0;
            temp = i;
            int Nth = (int)Math.log10(i);
            for(int j = Nth ; j>=0; j--){
                int a = temp/(int)Math.pow(10, j);
                NthSum += a;
                temp=temp-(a)*(int)Math.pow(10, j);
            }
            if((i+NthSum) == N){
                list.add(i);
            }
        }
        list.sort(Comparator.naturalOrder());
        if(list.isEmpty()) System.out.println(0);
        else System.out.println(list.get(0));
    }
}
