import java.io.*;
import java.util.*;

public class Main_bj_1759_암호만들기_서울_20반_김태석 {
    static int L,C;
    static char[] a, b;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        b = new char[L];
        a = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            a[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(a);    

        comb(0,0);

        System.out.print(sb.toString());
    }

    static void comb(int cnt, int start){
        if(cnt == L){
            int count1 = 0;
            int count2 = 0;
            for(int i = 0; i < L; i++){
                if(b[i]=='a'||b[i]=='i'||b[i]=='e'||b[i]=='o'||b[i]=='u') count1++;
                else count2++;
            }
            if(count1<1||count2<2) return;
            for(int i = 0; i < L; i++){
                sb.append(b[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < C; i++){
            b[cnt] = a[i];
            comb(cnt+1,i+1);
        }
    }
}
