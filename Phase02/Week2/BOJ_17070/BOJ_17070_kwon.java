package study_group_06.week08;

import java.io.*;
import java.util.*;

public class Problem_17070 {
	static int[] dx = { 1, 1, 0 };
	static int[] dy = { 0, 1, 1 };
	static int[] type = { 4, 3, 2 };

	static int N;
	static int[][] map;
	static int[][] visit;
	static int[][] pipe;
	static int cnt;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new int[N][N];
		pipe = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = map[i][j];
			}
		}

		cnt = 0;

		visit[0][0] = 4;
		visit[0][1] = 4;
		pipe[0][0] = 1;
		pipe[0][1] = 1;
		dfs(new Point(1, 0));

		System.out.println(cnt);

		br.close();
	}

	static void dfs(Point p) {
		if (p.x == N - 1 && p.y == N - 1) {
			printMap();
			cnt++;
			return;
		}

		int st = 0, ed = 0;
		if (visit[p.y][p.x] == 4) {
			st = 0;
			ed = dx.length - 1;
		} else if (visit[p.y][p.x] == 3) {
			st = 0;
			ed = dx.length;
		} else if (visit[p.y][p.x] == 2) {
			st = 1;
			ed = dx.length;
		}

		for (int d = st; d < ed; d++) {
			int nx = p.x + dx[d];
			int ny = p.y + dy[d];

			if (nx < 0 || N <= nx || ny < 0 || N <= ny)
				continue;

			if (visit[ny][p.x] == 1 || visit[p.y][nx] == 1 || visit[ny][nx] == 1)
				continue;

//			// 이게 있으면 이미 방문한 가로줄 체크를 못해버림
//			if (visit[ny][nx] == 4 && ny != N - 1)
//				continue;

			visit[ny][nx] = type[d];
			pipe[ny][nx] = cnt + 1;
			dfs(new Point(nx, ny));
		}
	}

	static void printMap() {
		StringBuilder sb = new StringBuilder();
		System.out.println(cnt + " ================");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append(" | ");
			for (int j = 0; j < visit[i].length; j++) {
				sb.append(visit[i][j]).append(' ');
			}
			sb.append(" | ");
			for (int j = 0; j < visit[i].length; j++) {
				sb.append(pipe[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
