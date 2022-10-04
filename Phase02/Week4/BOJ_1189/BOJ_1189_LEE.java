package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, K, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		visited = new boolean[R][C];
		visited[R-1][0] = true;
		dfs(new Point(R-1, 0), 1);
		System.out.println(ans);
	}

	static void dfs(Point p, int cnt) {
		if (p.x == 0 && p.y == C - 1) {
			if (cnt == K)
				ans++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (visited[nx][ny])
				continue;
			if(map[nx][ny]=='.') {
				visited[nx][ny] = true;
				dfs(new Point(nx, ny), cnt + 1);	
				visited[nx][ny] = false;
			}
		}
	}
}
