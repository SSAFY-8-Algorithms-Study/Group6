package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {
	static boolean[] diff, origin_diff;
	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] before = new char[N];
		char[] after = new char[N];
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			before[i] = s.charAt(i);
		}
		s = br.readLine();
		for (int i = 0; i < N; i++) {
			after[i] = s.charAt(i);
		}

		diff = new boolean[N + 2];
		origin_diff = new boolean[N + 2];
		for (int i = 0; i < N; i++) {
			if (before[i] != after[i]) {
				diff[i + 1] = true;
				origin_diff[i + 1] = true;
			}
		}

		for (int i = 1; i < N; i++) {
			if (diff[i]) {
				diff[i] = !diff[i];
				diff[i + 1] = !diff[i + 1];
				diff[i + 2] = !diff[i + 2];
				ans++;
			}
		}

		boolean check = true;
		for (int i = 1; i <= N; i++) {
			if (diff[i]) {
				check = false;
				break;
			}
		}

		int cnt1 = Integer.MAX_VALUE;
		if (check)
			cnt1 = ans;

		ans = 0;

		for (int i = 1; i <= N; i++) {
			diff[i] = origin_diff[i];
		}

		diff[1] = !diff[1];
		diff[2] = !diff[2];
		ans++;
		
		for (int i = 1; i < N; i++) {
			if (diff[i]) {
				diff[i] = !diff[i];
				diff[i + 1] = !diff[i + 1];
				diff[i + 2] = !diff[i + 2];
				ans++;
			}
		}

		check = true;
		for (int i = 1; i <= N; i++) {
			if (diff[i]) {
				check = false;
				break;
			}
		}

		int cnt2 = Integer.MAX_VALUE;
		if (check)
			cnt2 = ans;

		ans = Math.min(cnt1, cnt2);

		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.println(ans);
	}

}
