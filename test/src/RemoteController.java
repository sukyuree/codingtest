import java.util.*;

public class RemoteController {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int CanNotUse = sc.nextInt();
        List<Integer> CanNotUseNum = new ArrayList<>();
        if(CanNotUse != 0){
            for (int i = 0; i < CanNotUse; i++){
                CanNotUseNum.add(sc.nextInt());
            }
        }
        sc.close();
        int nearByNum = nearByNum(N, CanNotUseNum);

        int firstCase = 0;
        int secondCase = 0;
        int CurrentChanel = 100;

        if (nearByNum == N){
            firstCase = plusMinusCount(CurrentChanel, N);
            secondCase = numberingCount(N);
        }
        else if(CanNotUse==10){
            firstCase = plusMinusCount(CurrentChanel, N);
            secondCase = plusMinusCount(CurrentChanel, N);
        }
        else{
            firstCase = plusMinusCount(CurrentChanel, N);
            secondCase = numberingCount(nearByNum) + plusMinusCount(nearByNum, N);
        }

        if(firstCase <= secondCase) System.out.println(firstCase);
        else System.out.println(secondCase);
        
    }

    public static boolean isAble(int N, List<Integer> list){
        int Nth =(int)Math.log10(N);
        for(int i = Nth; i>=0; i--){
            int isContained = N/(int)Math.pow(10, i);
            if(list.contains(isContained) == true){
                return false;
            }
            N=N-(isContained)*(int)Math.pow(10, i);
        }
        return true;
    }

    public static int nearByNum(int N, List<Integer> list){
        int min = 0;
        int difference = N;
        for(int i = 0; i<=1000000; i++){
            if(isAble(i, list) == true && Math.abs(i-N)<=difference){
                min = i;
                difference = Math.abs(i-N); 
            }
        }
        return min;
    }

    public static int plusMinusCount(int start, int destination){
        return Math.abs(destination-start);
    }

    public static int numberingCount(int N){
        if(N == 0) return 1;
        return (int)Math.log10(N)+1;
    }
}
