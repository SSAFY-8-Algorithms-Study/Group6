package study_group_06.week03;

import java.io.*;

public class Problem_16922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] countArr = new int[50 * N + 1];
		int count = 0;
		int sum = 0;

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N - i; j++) {
				for (int k = 0; k <= N - i - j; k++) {
					for (int l = 0; l <= N - i - j - k; l++) {
						if (i + j + k + l == N) {
							sum = i + (j * 5) + (k * 10) + (l * 50);
							countArr[sum]++;
						}
					}
				}
			}
		}

		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] != 0) {
				count++;
			}
		}

		System.out.println(count);

		br.close();
	}
}
