import java.util.*;
import java.io.*;

public class Main_bj_12891_DNA비밀번호_서울_20반_김태석 {
    static int S,P,count = 0;
    static int[] option = new int[4];
    static int[] counter = new int[4];
    static char[] cArr;
    static int start = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        cArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            option[i] = Integer.parseInt(st.nextToken());
        }
        check();
        System.out.print(count);
    }

    public static void check(){
        for(int i = start; i < P; i++){
            switch(cArr[i]){
                case('A') : counter[0]++; break;
                case('C') : counter[1]++; break;
                case('G') : counter[2]++; break;
                case('T') : counter[3]++; break;
            }
        }
        if(isVerified()) count++;
        start++;
        while(start<=(S-P)){
            subAndAdd();
            if(isVerified()) count++;
            start++;
        }
    }

    public static void subAndAdd(){
        switch(cArr[start-1]){
            case('A') : counter[0]--; break;
            case('C') : counter[1]--; break;
            case('G') : counter[2]--; break;
            case('T') : counter[3]--; break;
        }
        switch(cArr[start+P-1]){
            case('A') : counter[0]++; break;
            case('C') : counter[1]++; break;
            case('G') : counter[2]++; break;
            case('T') : counter[3]++; break;
        }
    }

    public static boolean isVerified(){
        for(int i = 0; i < 4; i++) if(option[i]>counter[i]) return false;
        return true;
    }
}
