package study_group_06.week06;
import java.io.*;
import java.util.*;

public class Problem_9372 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		int N, M;

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 그래프를 연결할 필요도 없는 문제임 ㅋㅋㅋ
			for (int i = 0; i < M; i++)
				br.readLine(); // 연결 정보를 죄다 버려도 상관 없음!
			// 완전 연결 그래프의 최소 간선의 수는 모든 정점 - 1
			sb.append(N - 1).append('\n');
		}

		System.out.println(sb);

		br.close();
	}
}
