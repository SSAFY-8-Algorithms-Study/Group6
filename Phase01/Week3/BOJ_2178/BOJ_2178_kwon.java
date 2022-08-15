package study_group_06.week03;

import java.io.*;
import java.util.*;

class Point {
	int x, y;
	int score;

	Point(int x, int y, int score) {
		this.x = x;
		this.y = y;
		this.score = score;
	}
}

public class Problem_2178 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] visit = new int[N][M];

		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
				visit[i][j] = map[i][j] == 1 ? 0 : 1;
			}
		}

		Queue<Point> Q = new LinkedList<>();

		Q.add(new Point(0, 0, 1));
		visit[0][0] = 1;

		Point pos = null;
		int nx, ny;
		while (!Q.isEmpty()) {
			pos = Q.poll();

			if (pos.x == M - 1 && pos.y == N - 1)
				break;

			for (int d = 0; d < dx.length; d++) {
				nx = pos.x + dx[d];
				ny = pos.y + dy[d];

				if (nx < 0 || M <= nx || ny < 0 || N <= ny)
					continue;

				if (visit[ny][nx] == 1)
					continue;

				Q.add(new Point(nx, ny, pos.score + 1));
				visit[ny][nx] = 1;
			}
		}
		
		System.out.println(pos.score);

		br.close();
	}
}
