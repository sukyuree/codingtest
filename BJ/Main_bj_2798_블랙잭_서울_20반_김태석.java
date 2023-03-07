import java.util.*;
import java.io.*;

public class Main_bj_2798_블랙잭_서울_20반_김태석{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int[] cardSet = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            cardSet[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    list.add(cardSet[i]+cardSet[j]+cardSet[k]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)<=M&&max<list.get(i)) max = list.get(i);
        }
        System.out.println(max);
    }
}