package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2917 {
	static class Point {
		int x, y, w;

		public Point(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Queue<Point> tree = new LinkedList<>();
		Point V = new Point(0, 0, 0);
		Point J = new Point(0, 0, 0);
		boolean[][] visited2 = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = S.charAt(j);
				if (map[i][j] == '+') {
					tree.add(new Point(i, j, 0));
					visited2[i][j] = true;
				} else if (map[i][j] == 'V') {
					V = new Point(i, j, 0);
				} else if (map[i][j] == 'J') {
					J = new Point(i, j, 0);
				}
			}
		}

		int[][] map2 = new int[N][M];
		while(!tree.isEmpty()) {
			Point p = tree.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(visited2[nx][ny]) continue;
				tree.add(new Point(nx, ny, p.w+1));
				map2[nx][ny] = p.w+1; 
				visited2[nx][ny] = true;
			}
		}
		
		// print(map2, N, M);

		int min = map2[V.x][V.y];
		boolean[][] visited = new boolean[N][M];

		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
			return o2.w - o1.w;
		});

		pq.add(new Point(V.x, V.y, map2[V.x][V.y]));
		visited[V.x][V.y] = true;
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			min = Math.min(min, map2[p.x][p.y]);
			if (p.x == J.x && p.y == J.y)
				break;
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visited[nx][ny])
					continue;
				pq.add(new Point(nx, ny, map2[nx][ny]));
				visited[nx][ny] = true;
				
			}
		}
		System.out.println(min);

	}

	static int cal_distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static void print(int[][] map, int n, int m) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb);
	}

	static void print(char[][] map, int n, int m) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb);
	}
}
