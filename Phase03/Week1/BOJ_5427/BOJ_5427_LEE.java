package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			Point start = null;
			Queue<Point> fire = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '@') {
						start = new Point(i, j);
						map[i][j] = '.';
					}
					if (map[i][j] == '*') {
						fire.add(new Point(i, j));
					}
				}
			}
			Queue<Point> q = new LinkedList<>();
			q.add(start);
			boolean[][] visited = new boolean[H][W];
			visited[start.x][start.y] = true;
			boolean isPossible = false;
			int time = 1;
			loop: while (!q.isEmpty()) {
				int size = fire.size();
				for (int i = 0; i < size; i++) {
					Point p = fire.poll();
					for (int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if (nx < 0 || ny < 0 || nx >= H || ny >= W)
							continue;
						if (map[nx][ny] == '.') {
							map[nx][ny] = '*';
							fire.add(new Point(nx, ny));
						}
					}
				}

				size = q.size();
				for (int i = 0; i < size; i++) {
					Point p = q.poll();
					if (p.x == 0 || p.y == 0 || p.x == H - 1 || p.y == W - 1) {
						isPossible = true;
						break loop;
					}
					for (int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if (nx < 0 || ny < 0 || nx >= H || ny >= W)
							continue;
						if (visited[nx][ny])
							continue;
						if (map[nx][ny] == '.') {
							q.add(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
				time++;
			}
			if (isPossible)
				sb.append(time + "\n");
			else
				sb.append("IMPOSSIBLE\n");
		}
		
		System.out.println(sb);
	}
}
