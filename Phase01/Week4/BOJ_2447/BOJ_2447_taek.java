package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
	static char[][] star;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 문제 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		star = new char[n][n];
		// 문제 입력 끝
		
		star(n);
		
		// 문제 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 별 찍기
	static void star(int n) {
		// 제일 작은 size 3*3 별 찍기
		star[0][0] = '*';
		star[0][1] = '*';
		star[0][2] = '*';
		star[1][0] = '*';
		star[1][1] = ' ';
		star[1][2] = '*';
		star[2][0] = '*';
		star[2][1] = '*';
		star[2][2] = '*';
		int t = 9;
		while(t<=n) {
			for(int i=0; i<t/3; i++) {
				for(int j=0; j<t/3; j++) {
					star[i][j] = star[i][j];
					star[i][t/3+j] = star[i][j];
					star[i][t/3*2+j] = star[i][j];
					star[t/3+i][j] = star[i][j];
					star[t/3+i][t/3+j] = ' ';
					star[t/3+i][t/3*2+j] = star[i][j];
					star[t/3*2+i][j] = star[i][j];
					star[t/3*2+i][t/3+j] = star[i][j];
					star[t/3*2+i][t/3*2+j] = star[i][j];
				}
			}
			t*=3; // 패턴은 3의 거듭제곱으로 커진다.
		}
		return;
	}
}
