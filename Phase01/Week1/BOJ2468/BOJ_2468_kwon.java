package study_group_06;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

private class Point {
	int x, y;

	Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Problem_2468 {
	public static int[] dmY = { -1, 0, 1, 0 };
	public static int[] dmX = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int[][] visit;

		int high = 0;
		int curLandCnt = 0;
		int maxLandCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				high = Math.max(high, map[i][j]);
			}
		}

		Stack<Point> S = new Stack<>();

		for (int seaLevel = 0; seaLevel < high; seaLevel++) {
			// 해수면 상승
			visit = new int[N][N];
			curLandCnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if (visit[i][j] == 1) {
						continue;
					}
					
					if (map[i][j] > seaLevel) {
						curLandCnt++;
						
						S.push(new Point(i, j));

						while (!S.isEmpty()) {
							Point pos = S.pop();
							visit[pos.y][pos.x] = 1;

							for (int d = 0; d < 4; d++) {
								int dy = pos.y + dmY[d];
								int dx = pos.x + dmX[d];

								if (dy < 0 || N <= dy || dx < 0 || N <= dx) {
									continue;
								}
								
								if (visit[dy][dx] == 1) {
									continue;
								}

								if (map[dy][dx] > seaLevel) {
									S.push(new Point(dy, dx));
								}
							}
						}
					}
				}
			}
			maxLandCnt = Math.max(maxLandCnt, curLandCnt);
		}

		System.out.print(maxLandCnt);

		br.close();
	}
}
