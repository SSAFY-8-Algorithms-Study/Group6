package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025_seo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[1_000_001];
		
		int sum = 0;
		int maxIce = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = g;
			sum += g;
		}
		
		// K가 arr 범위보다 작을 때
		if (K*2+1<1_000_001) {
			int ice = 0;
			for (int i=0; i<1_000_001; i++) { // 나머지 검사
				if (i >= K*2+1) {
					ice -= arr[i - (K*2+1)]; // 앞부분 자르기
		        }
				ice += arr[i]; // 뒷부분 더하기
				if (maxIce<ice) {
					maxIce = ice;
//					System.out.println(maxIce+" "+i);
				}
			}
		}
		// K가 arr 범위보다 클 때
		else {
			maxIce = sum;
		}
		
		System.out.println(maxIce);
	}
}
