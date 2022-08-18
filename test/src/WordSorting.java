import java.util.*;
import java.io.*;

public class WordSorting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<String> wordlist = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            wordlist.add(br.readLine());
        }

        wordlist.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        for(int i = 0 ; i < wordlist.size(); i ++){
            System.out.println(wordlist.get(i));
        }
    }
    
}
