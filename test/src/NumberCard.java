import java.util.*;
import java.io.*;

public class NumberCard {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Integer> card = new ArrayList<>();
        List<Integer> numOfCard = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int input = Integer.parseInt(st.nextToken());
            if(!card.contains(input)){
                card.add(input);
                numOfCard.add(1);
            }
            else{
                int index = card.indexOf(input);
                numOfCard.set(index,numOfCard.get(index)+1);
            }
        }

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int number = Integer.parseInt(st.nextToken());
        
            if(card.contains(number)){
                int index = card.indexOf(number);
                sb.append(numOfCard.get(index)).append(" ");
            }
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
    
}
