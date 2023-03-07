import java.io.*;

public class Main_bj_1003_피보나치함수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] zeroArr = new int[41];
        int[] oneArr = new int[41];
        zeroArr[0] = 1;
        oneArr[1] = 1;

        for(int i = 2; i <= 40; i++){
           zeroArr[i] =  zeroArr[i-1] + zeroArr[i-2];
           oneArr[i] =  oneArr[i-1] + oneArr[i-2];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(zeroArr[num]+" "+oneArr[num]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
