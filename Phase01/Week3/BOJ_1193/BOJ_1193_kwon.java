package study_group_06.week03;

import java.io.*;

public class Problem_1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int step = 0;

		while (cnt != N) {
			step++;
			for (int i = 1; i <= step; i++) {
				cnt++;

				if (cnt == N) {
					if (step % 2 == 0)
						System.out.println(i + "/" + (step - i + 1));
					else
						System.out.println((step - i + 1) + "/" + i);

					break;
				}
			}
		}

		br.close();
	}
}
