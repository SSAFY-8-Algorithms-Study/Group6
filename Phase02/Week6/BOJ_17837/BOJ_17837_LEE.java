package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17837 {
	static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", d=" + d + "]";
		}

	}

	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		Deque<Integer>[][] chess = new ArrayDeque[N + 1][N + 1]; // 말의 위치가 주어져 있는 체스판
		for (int i = 1; i <= N; i++) { // 맵 정보
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				chess[i][j] = new ArrayDeque<>();
			}
		}

		Point[] chessMan = new Point[K + 1]; // 체스말 K개
		chessMan[0] = new Point(0, 0, 0);
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			chessMan[i] = new Point(x, y, d);
			chess[x][y].addLast(i);
		}

		int time = 1;
		boolean isFinished = false;
		loop: while (time <= 1000) { // 1000 초과인 경우에는 게임이 종료되지 않는 다고 가정하고 finish
			for (int i = 1; i <= K; i++) {
				int x = chessMan[i].x;
				int y = chessMan[i].y;
				int nx = x + dx[chessMan[i].d];
				int ny = y + dy[chessMan[i].d];
				if (nx < 1 || ny < 1 || nx > N || ny > N || map[nx][ny] == 2) { // 맵을 벗어나거나 파란색
					chessMan[i].d = changeDirection(chessMan[i].d);
					nx = x + dx[chessMan[i].d];
					ny = y + dy[chessMan[i].d];
				}
				
				if (nx < 1 || ny < 1 || nx > N || ny > N || map[nx][ny] == 2) { // 방향을 바꿨는데도 맵을 벗어나거나 파란색
					continue;
				} else if (map[nx][ny] == 0) { // 하얀색
					int size = chess[x][y].size();
					boolean check = false;
					for (int j = 0; j < size; j++) {
						int k = chess[x][y].pollFirst();
						if (k == i)
							check = true;
						if (check) {
							chess[nx][ny].addLast(k);
							chessMan[k] = new Point(nx, ny, chessMan[k].d);
						} else
							chess[x][y].addLast(k);
					}
				} else if (map[nx][ny] == 1) { // 빨간색
					int size = chess[x][y].size();
					for (int j = 0; j < size; j++) {
						int k = chess[x][y].pollLast();
						chess[nx][ny].addLast(k);
						chessMan[k] = new Point(nx, ny, chessMan[k].d);
						if (k == i)
							break;
					}
				}

//				System.out.println(time);
//				for(int j=1; j<=K; j++) {
//					System.out.println(chessMan[j]);
//				}
//				System.out.println();
				
				if(chess[nx][ny].size()>=4) {
					isFinished = true;
					break loop;
				}
					
			}
			time++;
		}

		if (isFinished)
			System.out.println(time);
		else
			System.out.println(-1);

	}

	static int changeDirection(int d) {
		if (d == 1)
			return 2;
		else if (d == 2)
			return 1;
		else if (d == 3)
			return 4;
		else if (d == 4)
			return 3;

		return -1;
	}

}
