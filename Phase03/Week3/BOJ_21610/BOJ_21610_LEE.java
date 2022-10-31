package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Point> cloud = new LinkedList<>();
		cloud.add(new Point(N - 1, 0));
		cloud.add(new Point(N - 1, 1));
		cloud.add(new Point(N - 2, 0));
		cloud.add(new Point(N - 2, 1));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int size = cloud.size();

			boolean[][] visited = new boolean[N][N];

			for (int j = 0; j < size; j++) {
				Point p = cloud.poll();
				int nx = (p.x + dx[d - 1] * (s % N) + N) % N;
				int ny = (p.y + dy[d - 1] * (s % N) + N) % N;
				cloud.add(new Point(nx, ny));
				visited[nx][ny] = true;
				A[nx][ny] += 1;
			}


//			System.out.println("----이동후 비내림----");
//			print(A, N);

			for (int j = 0; j < size; j++) {
				int cnt = 0;
				Point p = cloud.poll();
				for (int k = 1; k < 8; k += 2) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (A[nx][ny] > 0)
						cnt++;
				}
				A[p.x][p.y] += cnt;
			}

//			System.out.println("------대각선 물-----");
//			print(A, N);

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (A[r][c] >= 2 && !visited[r][c]) {
						cloud.add(new Point(r, c));
						visited[r][c] = true;
						A[r][c] -= 2;
					}
				}
			}


//			print(A, N);
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += A[i][j];
			}
		}

		System.out.println(ans);
	}

	static void print(int[][] map, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
