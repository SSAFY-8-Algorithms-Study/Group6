package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1325 {
	static int n, m;
	static ArrayList<Integer>[] arr;
	static boolean[] visited; // 방문한 노드인지 구분
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b].add(a);
		}
		ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			visited[i] = true;
			dfs(i, i);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, ans[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (max == ans[i])
				sb.append(i + " ");
		}
		System.out.println(sb);

	}

	static void dfs(int x, int idx) {
		
		for (int i : arr[x]) {
			if (visited[i])
				continue;
			ans[idx]++;
			visited[i] = true;
			dfs(i, idx);
		}
	}
}
