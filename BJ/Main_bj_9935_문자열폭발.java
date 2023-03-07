import java.io.*;
import java.util.*;

public class Main_bj_9935_문자열폭발 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] s = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        char[] temp = new char[bomb.length];

        if(s.length<bomb.length){
            System.out.print(s);
            return;
        }
        for(int i = 0; i < bomb.length; i++){
            stack.push(s[i]);
        }

        for(int i = bomb.length; i <= s.length; i++){
            boolean flag = true;
            if(stack.size()>=bomb.length){
                for(int j = 0; j < bomb.length; j++){
                    temp[bomb.length-j-1] = stack.pop();
                }
                for(int j = 0; j < bomb.length; j++){
                    if(temp[j]!=bomb[j]){
                        flag = false;
                        break;
                    }
                }

                if(!flag){
                    for(int j = 0; j < temp.length; j++){
                        stack.push(temp[j]);
                    }
                }
            }
            if(i == s.length) continue;
            stack.push(s[i]);
        }

        if(stack.size()==0) sb.append("FRULA");
        else{
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            sb.reverse();
        }
        System.out.print(sb.toString());
    }
}
