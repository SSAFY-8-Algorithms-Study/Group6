package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2624 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] coin = new int[K][2];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coin[i][0] = Integer.parseInt(st.nextToken());
			coin[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[T + 1];
		dp[0] = 1;
		for (int i = 0; i < K; i++) {
			for (int j = T; j >= coin[i][0]; j--) {
				for (int k = 1; k <= coin[i][1]; k++) {
					if (j - coin[i][0] * k < 0)
						break;
					dp[j] += dp[j - coin[i][0] * k];
				}
			}
		}

		System.out.println(dp[T]);

	}
}
