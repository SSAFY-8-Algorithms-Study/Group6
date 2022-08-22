package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290 {
	public static void main(String[] args) throws IOException {
		// 문제 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String S = st.nextToken();
		int s = S.length();
		char[][] ans = new char[2*n+3][(n+3)*s-1];
		char[] lcd = new char[s];
		for(int i=0; i<s; i++) {
			lcd[i] = S.charAt(i);
		}
		// 공백으로 초기화 해주어야 한다.
		for(int i=0; i<2*n+3; i++) {
			for(int j=0; j<(n+3)*s-1; j++) {
				ans[i][j] = ' ';
			}
		}
		// 문제 입력 끝
		for(int i=0; i<s; i++) {
			switch(lcd[i]) {
			case '1':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				break;
			case '2':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[n+1][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[2*n+2][(n+3)*i+j] = '-';
				}
				break;
			case '3':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[n+1][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[2*n+2][(n+3)*i+j] = '-';
				}
				break;
			case '4':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[n+1][(n+3)*i+j] = '-';
				}
				break;
			case '5':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[n+1][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[2*n+2][(n+3)*i+j] = '-';
				}
				break;
			case '6':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[n+1][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[2*n+2][(n+3)*i+j] = '-';
				}
				break;
			case '7':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				break;
			case '8':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[n+1][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[2*n+2][(n+3)*i+j] = '-';
				}
				break;
			case '9':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[n+1][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[2*n+2][(n+3)*i+j] = '-';
				}
				break;
			case '0':
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i] = '|';
				}
				for(int j=n+2; j<2*n+2; j++) {
					ans[j][(n+3)*i+n+1] = '|';
				}
				for(int j=1; j<n+1; j++) {
					ans[0][(n+3)*i+j] = '-';
				}
				for(int j=1; j<n+1; j++) {
					ans[2*n+2][(n+3)*i+j] = '-';
				}
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<2*n+3; i++) {
			for(int j=0; j<(n+3)*s-1; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
