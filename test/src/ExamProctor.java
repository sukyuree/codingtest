import java.util.*;
import java.io.*;

public class ExamProctor{

    static int N = 0;
    static int B = 0;
    static int C = 0;
    static int[] A;
    public static void main(String[] args) throws IOException{
        /*총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자의 수는 Ai명이다.

        감독관은 총감독관과 부감독관으로 두 종류가 있다. 총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고, 
        부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명이다.

        각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.

        각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오. */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long proctor = N;
        for(int i = 0; i < N; i++){
            proctor += howManySubProctor(A[i]);
        }
        System.out.println(proctor);
    }

    public static long howManySubProctor(int Aj){
        long num = 0;
        if(Aj - B < 0) num = 0;
        else if(((Aj - B)%C)==0) num = (Aj - B)/C;
        else num = (Aj - B)/C + 1;
        return num;
    }
}