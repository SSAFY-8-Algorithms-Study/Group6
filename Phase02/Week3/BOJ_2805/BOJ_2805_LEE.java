package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Integer[] tree = new Integer[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		int left = 0;
		int right = max;
		int mid = (left + right) / 2;

		while (left <= right) {
			long height = 0;
			for (int i = 0; i < N; i++) {
				height += tree[i] - mid > 0 ? tree[i] - mid : 0;
			}
			if (height > M) {
				left = mid + 1;
			} else if (height < M) {
				right = mid - 1;
			} else {
				break;
			}
			mid = (left + right) / 2;
		}
		System.out.println(mid);
	}
}
