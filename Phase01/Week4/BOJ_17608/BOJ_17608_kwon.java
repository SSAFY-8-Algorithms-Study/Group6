package study_group_06.week04;

import java.io.*;

public class Problem_17608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] sticks = new int[N];

		for (int i = 0; i < N; i++) {
			sticks[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;
		int high = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (high < sticks[i]) {
				high = sticks[i];
				cnt++;
			}
		}

		System.out.println(cnt);

		br.close();
	}
}
