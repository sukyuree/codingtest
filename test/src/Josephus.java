import java.util.*;

public class Josephus{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++){
            q.offer(i);
        }
        StringBuilder output = new StringBuilder();

        output.append('<');
        while(q.size()>1){
            for(int i = 0; i < K-1; i++){
                int k = q.poll();
                q.offer(k);
            }
            output.append(q.poll()).append(", ");
        }
        output.append(q.poll()).append('>');
        System.out.println(output.toString());
    }
    
}
