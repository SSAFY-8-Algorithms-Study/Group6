package study_group_06;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1059 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());

		int[] element = new int[L];

		for (int i = 0; i < L; i++) {
			element[i] = Integer.parseInt(st.nextToken());
		}

		int upperMin = 1001;
		int lowerMax = 0;

		for (int i = 0; i < L; i++) {
			if (element[i] == n) {
				upperMin = n + 1;
				lowerMax = n - 1;
				break;
			}

			if (element[i] > n) {
				upperMin = Math.min(upperMin, element[i]);
			}

			if (element[i] < n) {
				lowerMax = Math.max(lowerMax, element[i]);
			}
		}

		// System.out.println(upperMin + " " + lowerMax);
		int range = (upperMin - n) * (n - lowerMax) - 1;

		System.out.println(range);

		br.close();
	}
}
