import java.util.*;
import java.io.*;

public class NumberCard {
    private static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] cardlist = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            cardlist[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardlist);

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int number = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cardlist, number) - lowerBound(cardlist, number)).append(" ");
        }

        System.out.println(sb);
    }
    
}
