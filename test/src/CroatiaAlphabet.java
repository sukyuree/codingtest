import java.io.*;

public class CroatiaAlphabet {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(int i = 0; i < str.length; i++){
            if(input.contains(str[i])) input = input.replace(str[i], "_");
        }
        System.out.println(input.length());
    }
}
