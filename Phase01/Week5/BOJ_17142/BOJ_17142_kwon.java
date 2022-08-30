package study_group_06.week05;
import java.io.*;
import java.util.*;

public class Problem_17142 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int blankCnt;
	static int minTime;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Plant extends Point {
		boolean isVirus;

		Plant(int x, int y, boolean isVirus) {
			super(x, y);
			this.isVirus = isVirus;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		ArrayList<Plant> plant = new ArrayList<>();

		blankCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					blankCnt++;
				if (map[i][j] == 2)
					plant.add(new Plant(j, i, false));
			}
		}

		minTime = Integer.MAX_VALUE;

		if (blankCnt == 0)
			minTime = 0;
		else
			comb(0, M, map, plant);

		minTime = (minTime == Integer.MAX_VALUE) ? -1 : minTime;
		
		System.out.println(minTime);

		br.close();
	}

	static void bfs(int[][] map, ArrayList<Plant> plant) {
		boolean[][] visit = new boolean[map.length][map[0].length];

		LinkedList<Point> Q = new LinkedList<>();
		for (Plant p : plant) {
			if (p.isVirus) {
				Q.add(new Point(p.x, p.y));
				visit[p.y][p.x] = true;
			}
		}

		int qSize = 0;
		int time = 0;
		int tmp = blankCnt;

		Point p;
		int nx, ny;
		while (!Q.isEmpty()) {
			qSize = Q.size();
			time++;

			for (int i = 0; i < qSize; i++) {
				p = Q.poll();

				for (int d = 0; d < dx.length; d++) {
					nx = p.x + dx[d];
					ny = p.y + dy[d];

					if (nx < 0 || map[0].length <= nx || ny < 0 || map.length <= ny)
						continue;

					if (map[ny][nx] == 1)
						continue;

					if (visit[ny][nx])
						continue;

					if (map[ny][nx] == 0)
						tmp--;

					Q.add(new Point(nx, ny));
					visit[ny][nx] = true;
				}
			}

			if (time >= minTime)
				return;

			if (tmp <= 0)
				minTime = Math.min(minTime, time);
		}
	}

	static void comb(int idx, int cnt, int[][] map, ArrayList<Plant> plant) {
		if (cnt == 0) {
			bfs(map, plant);
			return;
		}

		for (int i = idx; i < plant.size(); i++) {
			plant.get(i).isVirus = true;
			comb(i + 1, cnt - 1, map, plant);
			plant.get(i).isVirus = false;
		}
	}
}
