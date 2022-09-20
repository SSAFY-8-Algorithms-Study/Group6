package study_group_06.week08;

import java.io.*;
import java.util.*;

public class Problem_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> noHear = new HashMap<>(N);

		for (int i = 0; i < N; i++) {
			noHear.put(br.readLine(), 1);
		}

		ArrayList<String> noHearNoSee = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (noHear.get(name) != null)
				noHearNoSee.add(name);
		}

		noHearNoSee.sort((o1, o2) -> o1.compareTo(o2));

		sb.append(noHearNoSee.size()).append('\n');
		for (String s : noHearNoSee) {
			sb.append(s).append('\n');
		}

		System.out.println(sb);

		br.close();
	}
}
