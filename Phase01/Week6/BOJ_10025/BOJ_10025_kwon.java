package study_group_06.week06;

import java.io.*;
import java.util.*;

public class Problem_10025 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] map = new int[1_000_000 + 1];

		int g, x;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			g = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map[x] = g;
		}

		int maxSum = 0;
		int curSum = 0;

		int left = 0, right = 0;

		for (right = 0; right < K * 2 + 1; right++) {
			if (right >= map.length)
				break;

			curSum += map[right];
		}

		maxSum = curSum;

		while (right < map.length) {
			curSum += map[right++];
			curSum -= map[left++];

			maxSum = Math.max(maxSum, curSum);
		}

		System.out.println(maxSum);

		br.close();
	}
}
