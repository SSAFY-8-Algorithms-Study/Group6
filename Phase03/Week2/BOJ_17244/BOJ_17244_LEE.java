package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17244 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, cnt, min = Integer.MAX_VALUE;
	static char[][] map;
	static Point start, end;
	static ArrayList<Point> stub;
	static boolean[][] visited;
	static boolean[] used;
	static int[] result;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		stub = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S')
					start = new Point(i, j);
				if (map[i][j] == 'X')
					stub.add(new Point(i, j));
				if (map[i][j] == 'E')
					end = new Point(i, j);
			}
		}
		cnt = stub.size();
		used = new boolean[cnt];
		result = new int[cnt];
		perm(0);
		System.out.println(min);
	}

	static int bfs(int x, int y) {
		int idx = 0;
		int time = 0;
		while (true) {
			int sx, sy;
			if (idx < cnt) {
				sx = stub.get(result[idx]).x;
				sy = stub.get(result[idx]).y;
			} else {
				sx = end.x;
				sy = end.y;
			}

			visited = new boolean[N][M];
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(x, y));
			visited[x][y] = true;
			loop:
			while (!q.isEmpty()) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
					Point p = q.poll();
					if (p.x == sx && p.y == sy) {
						idx++;
						x = sx;
						y = sy;
						break loop;
					}
					for (int i = 0; i < 4; i++) {
						int nx = p.x + dx[i];
						int ny = p.y + dy[i];
						if (nx < 0 || ny < 0 || nx >= N || ny >= M)
							continue;
						if (visited[nx][ny])
							continue;
						if (map[nx][ny] == '#')
							continue;
						q.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
				time++;
			}
			if (idx == cnt + 1)
				break;
		}
		return time;
	}

	static void perm(int idx) {
		if (idx == cnt) {
			min = Math.min(min, bfs(start.x, start.y));
			return;
		}

		for (int i = 0; i < cnt; i++) {
			if (used[i])
				continue;
			result[idx] = i;
			used[i] = true;
			perm(idx + 1);
			used[i] = false;
		}
	}
}
