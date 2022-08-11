import java.util.*;
import java.io.*;

public class VPS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            Stack<String> stack = new Stack<String>();
            st = new StringTokenizer(br.readLine(), "(|)",true);
            int length = st.countTokens();
            stack.push(st.nextToken());
            for(int j = 0; j < length-1; j++){
                if(stack.isEmpty()) stack.push(st.nextToken());
                else{
                    String temp = stack.pop();
                    String token = st.nextToken();
                    if(!(temp+token).equals("()")){
                        stack.push(temp);
                        stack.push(token);
                    }
                }
            }

            if(stack.isEmpty()) answer.add("YES");
            else answer.add("NO");
        }

        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }

    }
    
}
