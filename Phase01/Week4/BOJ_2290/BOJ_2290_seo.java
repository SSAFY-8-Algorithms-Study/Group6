package Study08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290_seo {
	
	static char[][] arr;
	static int s, nsize;
	static String n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken()); // 길이
		n = st.nextToken(); // 출력할 숫자들
		nsize = n.length(); // 숫자 개수
		
		arr = new char[2*s+3][(s+3)*nsize]; // 가로:(s+2+1)*숫자개수, 세로:2s+3
		for (int i=0; i<2*s+3; i++) {
			for (int j=0; j<(s+3)*nsize; j++) {
				arr[i][j] = ' ';
			}
		}
		
		LCDtest();
		
		for (int i=0; i<2*s+3; i++) {
			for (int j=0; j<(s+3)*nsize; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void LCDtest() {
		int idx=0;
		for (int i=0; i<nsize; i++) {
			int num = n.charAt(i)-'0';
			
			switch(num) {
			case 0:
				top(idx);
				bot(idx);
				rightTop(idx);
				rightBot(idx);
				leftTop(idx);
				leftBot(idx);
				break;
				
			case 1:
				rightTop(idx);
				rightBot(idx);
				break;
				
			case 2:
				top(idx);
				mid(idx);
				bot(idx);
				rightTop(idx);
				leftBot(idx);
				break;
				
			case 3:
				top(idx);
				mid(idx);
				bot(idx);
				rightTop(idx);
				rightBot(idx);
				break;
				
			case 4:
				leftTop(idx);
				mid(idx);
				rightTop(idx);
				rightBot(idx);
				break;
				
			case 5:
				top(idx);
				mid(idx);
				bot(idx);
				leftTop(idx);
				rightBot(idx);
				break;
				
			case 6:
				top(idx);
				mid(idx);
				bot(idx);
				leftTop(idx);
				leftBot(idx);
				rightBot(idx);
				break;
				
			case 7:
				top(idx);
				rightTop(idx);
				rightBot(idx);
				break;
				
			case 8:
				top(idx);
				mid(idx);
				bot(idx);
				leftTop(idx);
				leftBot(idx);
				rightTop(idx);
				rightBot(idx);
				break;
				
			case 9:
				top(idx);
				mid(idx);
				bot(idx);
				leftTop(idx);
				rightTop(idx);
				rightBot(idx);
				break;
			}
			
			idx += s+2+1;
		}
		
	}


	private static void top(int idx) {
		for (int i=1; i<(s+1); i++) {
			arr[0][idx+i] = '-';
		}
	}
	
	private static void mid(int idx) {
		for (int i=1; i<(s+1); i++) {
			arr[s+1][idx+i] = '-';
		}
		
	}
	
	private static void bot(int idx) {
		for (int i=1; i<(s+1); i++) {
			arr[2*s+2][idx+i] = '-';
		}
	}

	private static void rightTop(int idx) {
		for (int i=1; i<(s+1); i++) {
			arr[i][idx+s+1] = '|';
		}
	}

	private static void rightBot(int idx) {
		for (int i=s+2; i<(2*s+2); i++) {
			arr[i][idx+s+1] = '|';
		}
	}
	
	private static void leftTop(int idx) {
		for (int i=1; i<(s+1); i++) {
			arr[i][idx] = '|';
		}
	}
	
	private static void leftBot(int idx) {
		for (int i=s+2; i<(2*s+2); i++) {
			arr[i][idx] = '|';
		}
	}
}