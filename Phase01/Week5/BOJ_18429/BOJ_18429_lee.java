package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {
	static int n, k, ans;
	static int[] kit;
	static boolean[] used;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		kit = new int[n];
		for(int i=0; i<n; i++) {
			kit[i] = Integer.parseInt(st2.nextToken());
		}
		used = new boolean[n];
		perm(0, 500);
		System.out.println(ans);
	}
	
	static void perm(int idx, int weight) {
		if(idx==n) {
			ans++; // 성공적으로 만족했을 때마다 +1
			return;
		}
		for(int i=0; i<n; i++) {
			int w = weight + kit[i] - k; // 이번 타임의 중량
			if(used[i]||w<500) continue; // 중량이 500미만이거나 중복된 순열이면 패스
			used[i] = true;
			perm(idx+1, w);
			used[i] = false;
		}
	}
}
