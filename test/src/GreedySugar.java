import java.util.Scanner;

public class GreedySugar {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int rtn = 0;
        loop1:
        for(int i=0; i<=(N/3); i++){
            for(int j=0; j<=(N/5); j++){
                if(((i*3)+(j*5))==N){
                    rtn = i+j;
                    break loop1;
                }
                else{
                    rtn = -1;
                }
            }
        }
        System.out.println(rtn);
    }
}
