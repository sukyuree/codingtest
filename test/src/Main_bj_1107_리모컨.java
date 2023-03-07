import java.io.*;
import java.util.*;

public class Main_bj_1107_리모컨{
    static int N,M;
    static boolean[] broken;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        
        int difMin = Integer.MAX_VALUE;
        for(int i = 0; i <= 999999; i++){
            if(canMake(i)){
                difMin = Math.min(difMin,Integer.toString(i).length()+Math.abs(i-N));
            }
        }
        System.out.println(Math.min(difMin,Math.abs(N-100)));
        
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
