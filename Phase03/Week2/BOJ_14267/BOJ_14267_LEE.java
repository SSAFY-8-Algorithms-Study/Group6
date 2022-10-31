package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14267 {
	static ArrayList<Integer>[] sub;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sub = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			sub[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		st.nextToken(); // 1번 사장 -1 버림
		for (int i = 2; i <= N; i++) {
			int j = Integer.parseInt(st.nextToken());
			sub[j].add(i);
		}
		dp = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dp[j] += w;	
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(dp[i] + " ");
		}

		System.out.println(sb);

	}

	static void dfs(int j) {
		for (int i : sub[j]) {
			dp[i] += dp[j];
			dfs(i);
		}
	}
}
