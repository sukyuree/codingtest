import java.io.*;

public class Hansu {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int count = countHansu(N);

        System.out.println(count);
    }

    public static int countHansu(int N){
        int cnt = 0;
        
        if(N < 100){
            return N;
        }
        
        else {
            cnt = 99; 
            
            for(int i = 100; i <= N; i++){
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;
                
                if((hun - ten) == (ten - one)){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
}
