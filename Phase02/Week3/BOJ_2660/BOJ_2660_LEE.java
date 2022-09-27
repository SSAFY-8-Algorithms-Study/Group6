package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2660 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1)
				break;
			adjList[a].add(b);
			adjList[b].add(a);
		}

		int min_score = Integer.MAX_VALUE; // min_score 초기화
		int min_score_people = 0; // min_score를 동점으로 가진 사람이 몇명인지 체크
		ArrayList<Integer> member = new ArrayList<>(); // 회장인 멤버 리스트
		for (int i = 1; i <= N; i++) {
			int score = -1; // 회원의 점수
			int friend = 0;
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[N + 1];
			q.add(i);
			visited[i] = true;
			while (!q.isEmpty()) {
				int size = q.size();
				score++;
				for (int s = 0; s < size; s++) {
					int v = q.poll();
					friend++;
					for (int e : adjList[v]) {
						if (visited[e])
							continue;
						q.add(e);
						visited[e] = true;
					}
				}

			}

			if (friend == N) {
				if (score < min_score) {
					min_score = score;
					min_score_people = 1;
					member.clear();
					member.add(i);
				} else if (score == min_score) {
					min_score_people++;
					member.add(i);
				}
			}
		}

		System.out.println(min_score + " " + min_score_people);
		for (int i = 0; i < member.size(); i++) {
			System.out.print(member.get(i) + " ");
		}
	}
}
