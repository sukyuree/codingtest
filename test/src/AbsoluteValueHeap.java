import java.util.*;
import java.io.*;

public class AbsoluteValueHeap{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer obj1, Integer obj2) {
				if(Math.abs(obj1) > Math.abs(obj2)) {
					return Math.abs(obj1) - Math.abs(obj2);
				}else if(Math.abs(obj1) == Math.abs(obj2)) {
					return obj1 - obj2;
				}else {
					return -1;
				}
			}
		});

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            if(number == 0){
                if(pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            }
            else pq.offer(number);
        }
    }
}