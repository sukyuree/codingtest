import java.io.*;

public class Main_bj_3040_백설공주와일곱난쟁이_서울_20반_김태석 {
    static int[] nums;
    static int[] dwarfs;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        nums = new int[9];
        dwarfs = new int[7];
        for(int i = 0; i < 9; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        comb(0,0,0);
        System.out.print(sb.toString());
    }

    public static void comb(int cnt, int start, int sum){
        if(sum == 100&&cnt==7){
            for(int i = 0; i < 7; i++) sb.append(dwarfs[i]).append("\n");
        }
        if(cnt == 7) return;

        for(int i = start; i < 9; i++){
            dwarfs[cnt] = nums[i];
            comb(cnt+1,i+1,sum+nums[i]);
        }
    }
}
