package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, wolf_cnt, sheep_cnt;
	static char[][] map;
	static ArrayList<Point> animal;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		animal = new ArrayList<>();
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'v'||map[i][j]=='k')
					animal.add(new Point(i, j));
			}
		}
		for (Point w : animal) {
			if (visited[w.x][w.y])
				continue;
			bfs(w.x, w.y);
		}
		System.out.println(sheep_cnt+" "+wolf_cnt);
	}

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		int w_cnt = 0;
		int s_cnt = 0;
		if(map[x][y]=='v')
			w_cnt++;
		else
			s_cnt++;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] == '#')
					continue;
				if (map[nx][ny] == 'v') {
					w_cnt++;
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
					continue;
				}
				if (map[nx][ny] == 'k') {
					s_cnt++;
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
					continue;
				}
				q.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
		
		if(w_cnt>=s_cnt) 
			wolf_cnt += w_cnt;
		else
			sheep_cnt += s_cnt;
	}
}
