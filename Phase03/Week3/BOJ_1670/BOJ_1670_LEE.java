package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1670 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		
		dp[0] = 1;
		
		for(int i=2; i<=N; i+=2) {
			for(int j=2; j<=i; j+=2) {
				dp[i] += dp[i-j]*dp[j-2];
				dp[i] %= 987654321;
			}
		}
		
		System.out.println(dp[N]);
		
	}
}