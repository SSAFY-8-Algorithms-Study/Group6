package d0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1100_hwang {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] chess = new char[8][8];
		int fcnt = 0;
		
		for(int i=0; i<8; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String wb = st.nextToken();
			for(int j=0; j<8; j++) {
				chess[i][j] = wb.charAt(j);
				if(i%2==0) {
					if(j%2 == 0 && chess[i][j] == 'F')
						fcnt++;
				}
				else {
					if(j%2 == 1 && chess[i][j] == 'F')
						fcnt++;
				}
			}	
		}
		
		System.out.println(fcnt);

	}

}
