package study_group_06.week06;

import java.io.*;

public class Problem_10162 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] cnt = new int[3];

		if (N % 10 == 0) {
			while (N != 0) {
				if (N / 300 > 0) {
					N -= 300;
					cnt[0]++;
				} else if (N / 60 > 0) {
					N -= 60;
					cnt[1]++;
				} else {
					N -= 10;
					cnt[2]++;
				}
			}

			for (int n : cnt)
				sb.append(n).append(' ');

			System.out.println(sb);

		} else {
			System.out.println(-1);
		}

		br.close();
	}
}
