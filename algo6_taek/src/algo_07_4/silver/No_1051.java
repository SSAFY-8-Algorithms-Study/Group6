package algo_07_4.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String st2 = new StringTokenizer(br.readLine()).nextToken();
			for(int j = 0; j < m; j++) {
				if(st2.charAt(j) == ' ') {
					arr[i][j] = 0;
				}
				arr[i][j] = st2.charAt(j);
			}
		}
		
		int max = 1;
		int length = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = j + 1; k < m; k++) {
					if (arr[i][j]==arr[i][k] && i+k-j < n) {
						if(arr[i][j] == arr[i+k-j][j] && arr[i][j] == arr[i+k-j][k]) { // 정사각형인지 체크
							length = k-j+1;
							max = max > length ? max : length;
						}
					}
				}
			}
		}

		System.out.println(max*max);
	}
}
