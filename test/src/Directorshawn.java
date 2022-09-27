import java.io.*;

public class Directorshawn{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String threeSix = "666";
        int count = 0;
        int num = 0;
        for(int i = 666; i < 10000000; i++){
            if(Integer.toString(i).contains(threeSix)) count++;

            if(count == N){
                num = i;
                break;
            }
        }
        System.out.println(num);
    }
}
