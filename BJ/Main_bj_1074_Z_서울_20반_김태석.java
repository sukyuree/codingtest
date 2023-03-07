import java.util.*;
import java.io.*;

public class Main_bj_1074_Z_서울_20반_김태석{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        
        int size = (int)Math.pow(2, N);

        System.out.println(find(r,c,size,0));
    }
    static int find(int r, int c, int size, int count) {
        if(size == 1) return count;

        if(r < size/2 && c < size/2){ 
            count = find(r,c,size/2,count+(size*size/4)*0);
        }
        else if(r < size/2 && c >= size/2){
            count = find(r,c-size/2,size/2,count+(size*size/4)*1);
        }
        else if(r >= size/2 && c < size/2){
            count = find(r-size/2,c,size/2,count+(size*size/4)*2);
        }
        else if(r >= size/2 && c >= size/2){
            count = find(r-size/2,c-size/2,size/2,count+(size*size/4)*3);
        }

        return count;
	}
}
