import java.io.*;
import java.util.*;

public class Sorting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(numbers);
        
        for(int value : numbers){
            sb.append(value).append('\n');
        }
        System.out.print(sb);
    }
}
