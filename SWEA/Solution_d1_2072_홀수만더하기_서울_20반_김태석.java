import java.util.*;
import java.io.*;

class Solution_d1_2072_홀수만더하기_서울_20반_김태석
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int ans = 0;
			for(int j = 0; j < 10; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n%2==1) ans += n;
			}
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
}
