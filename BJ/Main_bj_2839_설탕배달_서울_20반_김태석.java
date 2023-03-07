import java.io.*;

public class Main_bj_2839_설탕배달_서울_20반_김태석 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int rtn = 0;
        loop1:
        for(int i=0; i<=(N/3); i++){
            for(int j=0; j<=(N/5); j++){
                if(((i*3)+(j*5))==N){
                    rtn = i+j;
                    break loop1;
                }
                else{
                    rtn = -1;
                }
            }
        }
        System.out.println(rtn);
    }
}