package study_group_06.week04;

import java.io.*;
import java.util.*;

public class Problem_2290 {
	static final int[] segment = { 0b01111110, 0b00110000, 
								   0b01101101, 0b01111001, 
								   0b00110011, 0b01011011, 
								   0b01011111, 0b01110000, 
								   0b01111111, 0b01111011 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int S = Integer.parseInt(st.nextToken());
		String N = st.nextToken();

		// 최대 10개 문자, 가로는 S + 2(세로선 2줄) + 1(공백 1칸), 세로는 2S + 3(가로선 3줄)
		char[][] display = new char[S * 2 + 3][(S + 2 + 1) * N.length()];

		for (int n = 0; n < N.length(); n++) {
			int sgIdx = N.charAt(n) - '0';
			for (int i = 0; i < S; i++) {
				if ((segment[sgIdx] & (1 << 6)) == (1 << 6)) {
					display[0][1 + i + (S + 2 + 1) * n] = '-';
				}
				if ((segment[sgIdx] & (1 << 5)) == (1 << 5)) {
					display[1 + i][1 + S + (S + 2 + 1) * n] = '|';
				}
				if ((segment[sgIdx] & (1 << 4)) == (1 << 4)) {
					display[1 + S + 1 + i][1 + S + (S + 2 + 1) * n] = '|';
				}
				if ((segment[sgIdx] & (1 << 3)) == (1 << 3)) {
					display[1 + S + 1 + S][1 + i + (S + 2 + 1) * n] = '-';
				}
				if ((segment[sgIdx] & (1 << 2)) == (1 << 2)) {
					display[1 + S + 1 + i][(S + 2 + 1) * n] = '|';
				}
				if ((segment[sgIdx] & (1 << 1)) == (1 << 1)) {
					display[1 + i][(S + 2 + 1) * n] = '|';
				}
				if ((segment[sgIdx] & (1 << 0)) == (1 << 0)) {
					display[1 + S][1 + i + (S + 2 + 1) * n] = '-';
				}
			}
		}

		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[0].length; j++) {
				if (display[i][j] == 0)
					sb.append(" ");
				else
					sb.append(display[i][j]);
			}
			sb.append("\n");
		}

		System.out.print(sb);

		br.close();
	}
}
