import java.util.Scanner;

public class FindMathFraction {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();
        int special = 0;
        int sum = 0;
        int order = 0;

        for(int i = 1; i <= X; i++){
            if(X==1){
                special = 1;
                order = 1;
                break;
            }    

            sum = sum+i;

            if(sum<X && X<=sum+i+1){
                special = i+1;
                order = X - sum;
                break;
            }

            else if (sum == X){
                special = i;
                order = i;
                break;
            }
        }
        if(special%2 == 0){
            System.out.println(order+"/"+(special-order+1));
        }
        else{
            System.out.println((special-order+1)+"/"+order);
        }
    }
}
