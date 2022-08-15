import java.util.*;
import java.io.*;

public class FindNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        a.sort(Comparator.naturalOrder());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int number = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(a,number)).append("\n");
        }
        System.out.print(sb);

    }

    public static int binarySearch(List<Integer> arr, int number){
        int low = 0;
        int mid = 0;
        int high = arr.size()-1;

        while(low <= high){
            mid = (low + high)/2 ;
            if(arr.get(mid) == number ) return 1;
            else if(arr.get(mid) < number) low = mid + 1;
            else if(arr.get(mid) > number) high = mid - 1;
        }

        return 0;
    }
    
}
