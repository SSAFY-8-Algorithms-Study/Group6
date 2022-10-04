package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17179 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] S = new int[M + 2];
		int[] Q = new int[N];

		S[0] = 0;
		for (int i = 1; i < M + 1; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		S[M + 1] = L;

		for (int i = 0; i < N; i++) {
			Q[i] = Integer.parseInt(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			// 이분 탐색
			int left = 0;
			int right = L;
			int mid = (left + right) / 2;
			
			// 종료 조건
			while (left <= right) {
				int cnt = 0; // 조각의 갯수
				int prev = S[0]; // 0으로 초기화
				for (int j = 1; j < M + 2; j++) {
					if (S[j] - prev >= mid) { // 이전 조각과의 차이가  mid보다 크거나 같다면 케이크를 잘라야함
						cnt++;
						prev = S[j]; // 조각을 새로 잘랐기 때문에 덮어 씌움
					}
				}
				// 자른 횟수는 조각의 갯수 - 1
				if (cnt - 1 >= Q[i]) { // 기준(자른)횟수 보다 크거나 같다면 롤 케이크를 더 크게 자를 수도 있음
					left = mid + 1;
				} else if (cnt - 1 < Q[i]) { // 기준(자른)횟수 보다 작다면 롤케이크를 더 작게 잘라야 함
					right = mid - 1;
				}
				mid = (left + right) / 2;
			}
			sb.append(mid+"\n");
		}
		System.out.println(sb);

	}
}
