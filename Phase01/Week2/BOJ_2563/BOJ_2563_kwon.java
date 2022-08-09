package study_group_06.weak02;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_2563 {
	static int blackSize = 10;
	static int whiteSize = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		boolean[][] whitePaper = new boolean[whiteSize][whiteSize];

		int sumArea = 0;
		int tx = 0, ty = 0;

		for (int p = 1; p <= N; p++) {
			st = new StringTokenizer(br.readLine());
			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());

			for (int i = ty; i < ty + 10; i++) {
				for (int j = tx; j < tx + 10; j++) {
					if (!whitePaper[i][j]) {
						whitePaper[i][j] = true;
						sumArea++;
					}
				}
			}
//			print(whitePaper, sumArea);
		}

		System.out.println(sumArea);

		br.close();
	}

//	static void print(boolean[][] p, int sum) {
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				System.out.print(p[i][j] ? "X": ".");
//			}
//			System.out.println();
//		}
//		System.out.println(sum);
//	}
}