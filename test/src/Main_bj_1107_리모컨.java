import java.io.*;
import java.util.*;

public class Main_bj_1107_리모컨{
    static int currentChanel = 100;
    static int N,M;
    static boolean[] broken;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        int click = 0;
        int click2 = 0;
        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        
        int difMin = 1000000;
        for(int i = 0; i <= 999999; i++){
            if(canMake(i)){
                if(Math.abs(difMin-N)>Math.abs(i-N)) difMin = i;
            }
        }

        click = Integer.toString(difMin).length();
        
        if(difMin>N){
            while(difMin!=N){
                difMin--;
                click++;   
            }
        }
        else if(difMin<N){
            while(difMin!=N){
                difMin++;
                click++;
            }
        }

        click2 = Math.abs(N-currentChanel);
        System.out.println(Math.min(click,click2));
        
    }

    static boolean canMake(int n){
        boolean can = true;
        String nToString = Integer.toString(n);
        for(int i = 0; i < nToString.length(); i++){
            if(isBroken(nToString.charAt(i))){
                can = false;
                break;
            }
        }

        return can;
    }

    static boolean isBroken(char c){
        return broken[c-'0'];
    }
}