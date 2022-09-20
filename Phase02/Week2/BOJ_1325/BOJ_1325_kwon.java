package study_group_06.week08;

import java.io.*;
import java.util.*;

public class Problem_1325 {
	static class Node {
		int no;
		int maxConn;
		ArrayList<Node> hasTrust;

		public Node(int no) {
			this.no = no;
			this.maxConn = 0;
			this.hasTrust = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Node[] v = new Node[N + 1];
		for (int i = 1; i <= N; i++)
			v[i] = new Node(i);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			if (v[to].hasTrust.add(v[from])) {
				v[to].maxConn = v[to].hasTrust.size();
			}
		}

		Queue<Node> Q = new LinkedList<>();

		ArrayList<Integer> result = new ArrayList<>();
		int maxConnect = -1;

		for (int i = 1; i <= N; i++) {
			boolean[] visit = new boolean[N + 1];

			Q.add(v[i]);
			visit[i] = true;

			int connect = 0;

			while (!Q.isEmpty()) {
				Node node = Q.poll();

				for (Node next : node.hasTrust) {
					if (!visit[next.no]) {
						Q.add(next);
						visit[next.no] = true;
						connect++;
					}
				}
			}

			if (connect > maxConnect) {
				maxConnect = connect;
				result.clear();
				result.add(i);
			} else if (connect == maxConnect) {
				result.add(i);
			}
		}

		for (int no : result) {
			sb.append(no).append(' ');
		}

		System.out.println(sb);

		br.close();
	}
}
