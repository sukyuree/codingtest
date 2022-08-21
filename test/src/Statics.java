import java.util.*;
import java.io.*;

public class Statics {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];

        int sum = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
        }
        

        Arrays.sort(numbers);

        int average = (int)Math.round((double)sum/N);
        int center = numbers[(N/2)];
        int range = numbers[N-1] - numbers[0];
        int mode = 0;
        int count = 0;
        boolean isSecond = true;
        for (int i = 0; i < N; i++){
            int tempMode = numbers[i];
            int tempCount = 1;
            for(int j = i+1; j < N; j++){
                if(numbers[i] == numbers[j]){
                    tempMode = numbers[i];
                    tempCount++;
                }
                else break;
            }
            i += tempCount - 1;

            if(tempCount > count){
                mode = tempMode;
                count = tempCount;
                isSecond = true;
            }
            else if(tempCount == count && isSecond){
                mode = tempMode;
                count = tempCount;
                isSecond = false;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(average).append("\n");
        sb.append(center).append("\n");
        sb.append(mode).append("\n");
        sb.append(range);
        System.out.println(sb);
    }
}
