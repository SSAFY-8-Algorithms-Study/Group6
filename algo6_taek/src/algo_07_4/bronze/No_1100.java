package algo_07_4.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] chess = new char[8][8];
		for(int i = 0; i < 8; i++) {
			String st = new StringTokenizer(br.readLine()).nextToken();
			for(int j = 0; j < 8; j++) {
				chess[i][j] = st.charAt(j);
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i + j) % 2 == 0 & chess[i][j] =='F') cnt++;
			}
		}
		System.out.println(cnt);
	}
}
