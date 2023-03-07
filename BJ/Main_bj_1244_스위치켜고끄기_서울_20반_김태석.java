import java.util.*;
import java.io.*;

class Main_jb_1244_스위치켜고끄기_서울_20반_김태석{
    static int N;
    static int[] sArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        sArr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            sArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int pNum = Integer.parseInt(st.nextToken());

        for(int i = 0; i < pNum; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switchControl(a,b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(sArr[i]).append(" ");
            if(i%20 == 0) sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    
    //스위치 조작 함수
    public static void switchControl(int a, int b){
        //남학생이 스위치 조작
        if(a==1){
            for(int i = 1; i <= N; i++){
                if(i%b==0) sArr[i] = (sArr[i]==0) ? 1 : 0;
            }
        }
        //여학생이 스위치 조작
        else{
            sArr[b] = (sArr[b]==0) ? 1 : 0;
            for(int i = 1; i <= N/2; i++){
                if(b-i<=0||b+i>N) break;

                if(sArr[b-i]==sArr[b+i]){
                    sArr[b-i] = (sArr[b-i]==0) ? 1 : 0;
                    sArr[b+i] = (sArr[b+i]==0) ? 1 : 0;
                }
                else break;
            }
        }
    }
}