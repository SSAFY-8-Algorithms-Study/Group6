	package silver;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.StringTokenizer;
	
	public class BOJ_11060 {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[] miro = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				miro[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[N];
			Arrays.fill(dp, 1000);
			dp[0] = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= miro[i]; j++) {
					if (i + j >= N)
						break;
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
			
			if(dp[N-1] == 1000)
				System.out.println(-1);
			else
				System.out.println(dp[N-1]);
		}
	}
