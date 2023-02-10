import java.util.*;
import java.io.*;

public class Solution_d4_1218_괄호짝짓기_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> dq;
        for(int t = 1; t <= 10; t++){
            int length = Integer.parseInt(br.readLine());
            String line = br.readLine();
            dq = new ArrayDeque<>();
            Loop1:
            for(int i = 0; i < length; i++){
                switch(line.charAt(i)){
                    case(']') : {
                        if(dq.isEmpty()||dq.peekLast()!='['){dq.add('a'); break Loop1;}
                        else if(dq.peekLast()=='['){dq.pollLast(); break;}
                    }
                    case('}') : {
                        if(dq.isEmpty()||dq.peekLast()!='{'){dq.add('a'); break Loop1;}
                        else if(dq.peekLast()=='{'){dq.pollLast(); break;}
                    }
                    case('>') :{
                        if(dq.isEmpty()||dq.peekLast()!='<'){dq.add('a'); break Loop1;}
                        else if(dq.peekLast()=='<'){dq.pollLast(); break;}
                    } 
                    case(')') : {
                        if(dq.isEmpty()||dq.peekLast()!='('){dq.add('a'); break Loop1;}
                        else if(dq.peekLast()=='('){dq.pollLast(); break;}
                    }
                    default : dq.add(line.charAt(i));
                }
            }
            if(dq.size()!=0) sb.append("#").append(t).append(" ")
                               .append("0").append("\n");
            else sb.append("#").append(t).append(" ")
                   .append("1").append("\n");
        }

        System.out.print(sb.toString());
    }
}
