package study_group_06.week05;

import java.io.*;
import java.util.*;

public class Problem_18429 {
	static int N, K;
	static int[] kits;
	static int[] select;
	static boolean[] visit;
	static int plan;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		kits = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			kits[i] = Integer.parseInt(st.nextToken());

		select = new int[N];
		visit = new boolean[N];
		plan = 0;

		perm(0);

		System.out.println(plan);

		br.close();
	}

	static void perm(int idx) {

		if (idx == N) {
			int weight = 500;
			for (int i = 0; i < N; i++) {
				weight = weight - K + select[i];
				if (weight < 500) {
					return;
				}
			}
			plan++;

			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;

			select[idx] = kits[i];
			visit[i] = true;
			perm(idx + 1);
			visit[i] = false;
		}
	}
}
