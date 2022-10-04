package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18353 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] soldier = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			soldier[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i=1; i<N; i++) {
			for(int j=0; j<=i; j++) {
				if(soldier[i]<soldier[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(N-max);

	}
}
