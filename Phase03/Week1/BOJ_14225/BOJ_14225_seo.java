package Phase03.Week1.BOJ_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14225_seo {
	static int n;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		int total = 0;
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		visited = new boolean[total+2]; // 1~total+1±îÁö
		
		subset(0, 0);
		int ans = 1;
		while(true) {
			if (!visited[ans]) break;
			ans++;
		}
		
		System.out.println(ans);
	}

	private static void subset(int idx, int sum) {
		if (idx==n) {
			//System.out.println(sum);
			visited[sum] = true;
			return;
		}
		
		subset(idx+1, sum);
		subset(idx+1, sum+arr[idx]);
	}
}
