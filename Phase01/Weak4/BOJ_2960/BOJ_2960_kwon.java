package study_group_06.week04;

import java.io.*;
import java.util.*;

public class Problem_2960 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] nums = new int[N + 1];

		int p = 2;
		int cnt = 1;

		for (int i = p; i <= N; i++) {
			for (int j = i; j <= N; j += i) { // 배수만 탐색
				if (nums[j] == 0) // nums[j]가 0이면 아직 방문하지 않음(새로운 소수거나 그 소수의 배수)
					nums[j] = cnt++;
			}
		}

		for (int i = 2; i <= N; i++)
			if (nums[i] == K)
				System.out.println(i);

		br.close();
	}
}
