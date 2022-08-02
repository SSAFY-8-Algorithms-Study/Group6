package study_group_06;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
	int x, y;

	Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Problem_2573 {
	public static int[] dmY = { -1, 0, 1, 0 };
	public static int[] dmX = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] melt;
		int[][] visit;

		int curLandCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Stack<Point> S = new Stack<>();

		int year = 0;
		boolean isIce = false;

		while (true) {
			visit = new int[N][M];
			melt = new int[N][M];

			isIce = false;
			curLandCnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					if (visit[i][j] == 1) {
						continue;
					}

					if (map[i][j] > 0) {
						curLandCnt++;

						S.push(new Point(i, j));

						while (!S.isEmpty()) {
							Point pos = S.pop();

							for (int d = 0; d < 4; d++) {
								int dy = pos.y + dmY[d];
								int dx = pos.x + dmX[d];

								if (dy < 0 || N <= dy || dx < 0 || M <= dx) {
									continue;
								}

								if (visit[pos.y][pos.x] == 0 && map[dy][dx] == 0) {
									melt[pos.y][pos.x]++;
								}

								if (visit[dy][dx] == 1) {
									continue;
								}

								if (map[dy][dx] > 0) {
									S.push(new Point(dy, dx));
								}
							}

							visit[pos.y][pos.x] = 1;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						int meltHigh = map[i][j] - melt[i][j];
						map[i][j] = meltHigh < 0 ? 0 : meltHigh;
						isIce = true;
					}
				}
			}

			if (!isIce || curLandCnt > 1) {
				break;
			}

			year++;
		}

		if (curLandCnt > 1) {
			System.out.println(year);
		} else {
			System.out.println(0);
		}

		br.close();
	}

}
