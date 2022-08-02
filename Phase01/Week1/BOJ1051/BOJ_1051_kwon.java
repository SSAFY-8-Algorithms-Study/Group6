package study_group_06;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int maxSize = 0;
		int maxSide = (N < M) ? N : M;
		for (int n = 1; n < maxSide; n++) {
			for (int i = 0; i < N - n; i++) {
				for (int j = 0; j < M - n; j++) {
					if ((map[i][j] == map[i][j + n]) && (map[i][j] == map[i + n][j])
							&& (map[i][j] == map[i + n][j + n])) {
						if (maxSize < n) {
							maxSize = n;
						}
					}
				}
			}
		}

		maxSize = (maxSize + 1) * (maxSize + 1);
		System.out.println(maxSize);

		br.close();
	}
}
