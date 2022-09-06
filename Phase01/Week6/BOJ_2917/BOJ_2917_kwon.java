package study_group_06.week06;

import java.io.*;
import java.util.*;

public class Problem_2917 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static class Point {
		int x, y;
		int weight;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.weight = 0;
		}

		public Point(int x, int y, int weight) {
			this(x, y);
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		int minDist = Integer.MAX_VALUE;

		Queue<Point> Qt = new LinkedList<>();
		PriorityQueue<Point> Qp = new PriorityQueue<>((o1, o2) -> o1.weight < o2.weight ? 1 : -1);
		Point start = null;
		Point camp = null;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				map[i][j] = 0;

				if (c == '+') {
					Qt.add(new Point(j, i));
					visit[i][j] = true;
				} else if (c == 'V') {
					start = new Point(j, i);
				} else if (c == 'J') {
					camp = new Point(j, i);
				}
			}
		}

		int distance = 0;
		while (!Qt.isEmpty()) {
			int qSize = Qt.size();
			distance++;

			for (int i = 0; i < qSize; i++) {
				Point p = Qt.poll();

				for (int d = 0; d < dx.length; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];

					if (nx < 0 || M <= nx || ny < 0 || N <= ny)
						continue;

					if (visit[ny][nx])
						continue;

					Qt.add(new Point(nx, ny));
					map[ny][nx] = distance;
					visit[ny][nx] = true;
				}
			}
		}

		visit = new boolean[N][M];
		visit[start.y][start.x] = true;
		start.weight = map[start.y][start.x];
		Qp.add(start);

		while (!Qp.isEmpty()) {
			Point p = Qp.poll();

			if (p.x == camp.x && p.y == camp.y)
				break;

			minDist = Math.min(minDist, p.weight);

			for (int d = 0; d < dx.length; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx < 0 || M <= nx || ny < 0 || N <= ny)
					continue;

				if (visit[ny][nx])
					continue;

				Qp.add(new Point(nx, ny, map[ny][nx]));
				visit[ny][nx] = true;
			}
		}

		System.out.println(minDist);

		br.close();
	}
}
