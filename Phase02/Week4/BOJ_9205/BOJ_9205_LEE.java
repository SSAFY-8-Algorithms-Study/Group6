package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static class Point {
		int x, y;
		boolean visited;

		public Point(int x, int y, boolean visited) {
			this.x = x;
			this.y = y;
			this.visited = visited;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Point[] store = new Point[N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			store[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true);
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false);
			}
			st = new StringTokenizer(br.readLine());
			store[N + 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false);

			int[][] dist = new int[N+2][N+2];
			for (int i = 0; i <= N + 1; i++) {
				for (int j = 0; j <= N + 1; j++) {
					dist[i][j] = distance(store[i], store[j]);
				}
			}

			Queue<Point> q = new LinkedList<>();
			for (int i = 1; i <= N + 1; i++) {
				if (distance(store[0], store[i]) <= 1000) {
					store[i].visited = true;
					q.add(store[i]);
				}
			}

			boolean ans = false;
			while (!q.isEmpty()) {
				Point p = q.poll();
				if (p.x == store[N + 1].x && p.y == store[N + 1].y) {
					ans = true;
					break;
				}
				for (int i = 1; i <= N + 1; i++) {
					if (store[i].visited)
						continue;
					if (distance(p, store[i]) <= 1000) {
						store[i].visited = true;
						q.add(store[i]);
					}
				}
			}
			if (ans) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb);
	}

	static int distance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
