package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14225 {
	static int N;
	static int[] S;
	static ArrayList<Integer> sum2;
	static boolean[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		result = new boolean[N];
		sum2 = new ArrayList<>();
		subset(0);
		Collections.sort(sum2);
		int min = 1;
		int idx = 0;
		while (true) {
			if (idx == sum2.size())
				break;
			if (min == sum2.get(idx)) {
				min++;
				idx++;
			} else if (min > sum2.get(idx)) {
				idx++;
			} else {
				break;
			}
		}
		System.out.println(min);
	}

	static void subset(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (result[i]) {
					sum += S[i];
				}
			}

			sum2.add(sum);
			return;
		}
		result[idx] = true;
		subset(idx + 1);
		result[idx] = false;
		subset(idx + 1);
	}
}
