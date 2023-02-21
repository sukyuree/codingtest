import java.util.*;
import java.io.*;

public class Main_bj_2630_색종이만들기_서울_20반_김태석 {
	static int white = 0;
	static int green = 0;
	static int[][] spaces;
	
	static void cut(int r, int c, int size) {
		int sum = 0;
		for(int i = r, rEnd = r+size; i<rEnd; i++) {
			for(int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += spaces[i][j];
			}
		}
		
		if(sum == size * size) {// 모두 초록색
			green++;
		}else if(sum == 0) { // 모두 하얀색
			white++;
		}else { // 혼합된 상황
			// 4분할
			int half = size/2;
			cut(r, c, half);
			cut(r, c+half,  half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
		}
	}
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		spaces = new int[n][n];
		
		for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				spaces[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, n);
		
		System.out.println(white);
		System.out.println(green);
	}
}
