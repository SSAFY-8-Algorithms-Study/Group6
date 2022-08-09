package study_group_06.weak02;

import java.io.*;
import java.util.*;

class Point {
	int x, y;
	int bomb;
	int score;
//	Point parent;

	Point(int x, int y, int bomb, int score) {
		this.x = x;
		this.y = y;
		this.bomb = bomb;
		this.score = score;
	}

//	Point(int x, int y, int bomb, int score, Point parent) {
//		this.x = x;
//		this.y = y;
//		this.bomb = bomb;
//		this.score = score;
//		this.parent = parent;
//	}
}

public class Problem_2206 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int goalX, goalY;

	static int N, M;
	static int[][] map;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new int[N][M];

		goalY = N - 1;
		goalX = M - 1;

		String line;

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
				visit[i][j] = map[i][j] == 1 ? 1 : 0;
			}
		}

		Queue<Point> Q = new LinkedList<>();

//		Q.add(new Point(0, 0, 1, 1, null));
		Q.add(new Point(0, 0, 1, 1));
		visit[0][0] = 2;

		Point pos = null;
		int bomb;
		int nx, ny;
//		long maxQueueSize = 0;
		while (!Q.isEmpty()) {
//			maxQueueSize = Math.max(maxQueueSize, Q.size());
			pos = Q.poll();

			if (pos.y == goalY && pos.x == goalX) {
				break;
			}

//			if (pos.bomb > 0) {
//				visit[pos.y][pos.x] = 2;
//			} else {
//				visit[pos.y][pos.x] = (visit[pos.y][pos.x] == 1) ? 1 : 3;
//			}

			for (int d = 0; d < 4; d++) {
				bomb = pos.bomb;
				nx = pos.x + dx[d];
				ny = pos.y + dy[d];

				if (ny < 0 || N <= ny || nx < 0 || M <= nx)
					continue;

				if (visit[ny][nx] == 2) {
					continue;
				}

				if (bomb > 0) {
					if (visit[ny][nx] == 1) {
						bomb--;
					}
					visit[ny][nx] = 2;
				} else {
					if (visit[ny][nx] == 1 || visit[ny][nx] == 3) {
						continue;
					}
					visit[ny][nx] = (visit[ny][nx] == 1) ? 1 : 3;
				}

//				Q.add(new Point(nx, ny, bomb, G, pos));
				Q.add(new Point(nx, ny, bomb, pos.score + 1));
			}
		}

//		printPath(pos);

		if (pos.x != goalX || pos.y != goalY) {
			System.out.println(-1);
		} else {
			System.out.println(pos.score);
		}

//		System.out.println(maxQueueSize);

		br.close();
	}

//	static void printPath(Point pos) {
//		int[][] mapClone = new int[N][];
//		for (int i = 0; i < N; i++) {
//			mapClone[i] = Arrays.copyOf(map[i], M);
//		}
//
//		while (pos != null) {
//			mapClone[pos.y][pos.x] = 9;
//			pos = pos.parent;
//		}
//
//		System.out.println("================");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(mapClone[i][j] == 9 ? '.' : (char)(mapClone[i][j] + '0'));
//			}
//			System.out.println();
//		}
//		System.out.println("================");
//	}
}
