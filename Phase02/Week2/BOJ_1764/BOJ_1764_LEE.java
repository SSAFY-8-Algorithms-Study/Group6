package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] A = new String[N + M];
		for (int i = 0; i < N + M; i++) {
			A[i] = br.readLine();
		}

		Arrays.sort(A);
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < N + M - 1; i++) {
			if (A[i].equals(A[i + 1])) {
				cnt++;
				sb.append(A[i] + "\n");
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}
}
