import java.util.*;
import java.io.*;
 
class SWEA_20230206{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine(),"0|1",true);
            int size = st.countTokens();
            int[] A = new int [size];
            int[] B = new int [size];
            for(int j = 0; j < size; j++){
                B[j] = Integer.parseInt(st.nextToken());
            }
            int cnt = count(A,B);
            sb.append("#").append(i).append(" ")
              .append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int count(int[] A, int[] B){
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]==B[i]) continue;
            for(int j = i; j < A.length; j++){
                A[j] = B[i];
            }
            count++;
        }
        return count;
    }
}
