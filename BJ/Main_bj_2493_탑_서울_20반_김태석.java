import java.io.*;
import java.util.*;

public class Main_bj_2493_탑_서울_20반_김태석{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            int index = i;
            int height = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                stack.push(new int[]{index,height});
                sb.append(0).append(" ");
            }
            else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append(0).append(" ");
                        stack.push(new int[]{index,height});
                        break;
                    }
                    
                    if(stack.peek()[1]>=height){
                        sb.append(stack.peek()[0]).append(" ");
                        stack.push(new int[]{index,height});
                        break;
                    }
                    else stack.pop();
                }
            }
        }
        System.out.print(sb.toString());
    }
}