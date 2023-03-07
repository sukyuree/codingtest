import java.io.*;
import java.util.*;

public class Solution_d3_1208_Flatten_서울_20반_김태석 {
    static int[] box = new int[100];
    static int max;
    static int min;
    static int dumpCount;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            dumpCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++){
                box[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(box);
            defineMinMax();
            dump();

            sb.append("#").append(t).append(" ")
              .append(minMaxSub()).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dump(){
        for(int i = 1; i <= dumpCount; i++){
            int sub = minMaxSub();
            if(sub==0||sub==1) break;
            box[0]++;
            box[99]--;
            Arrays.sort(box);
            defineMinMax();
        }
        
    }

    public static int minMaxSub(){
        return max - min;
    }

    public static void defineMinMax(){
        min = box[0];
        max = box[99];
    }
}
