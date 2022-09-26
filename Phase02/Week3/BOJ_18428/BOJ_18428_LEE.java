package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, teacher_size, empty_size;
	static boolean ans;
	static boolean[] used;
	static int[] obstacle;
	static char[][] map, temp_map;
	static ArrayList<Point> teacher, empty;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		temp_map = new char[N][N];
		teacher = new ArrayList<>();
		empty = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				switch (map[i][j]) {
				case 'T':
					teacher.add(new Point(i, j));
				case 'X':
					empty.add(new Point(i, j));
				}
			}
		}
		teacher_size = teacher.size();
		empty_size = empty.size();
		used = new boolean[empty_size];
		obstacle = new int[3];

		perm(0);

		if (ans) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static void perm(int cnt) {
		if (cnt == 3) {
			deep_copy();
			for (int i = 0; i < 3; i++) {
				int x = empty.get(obstacle[i]).x;
				int y = empty.get(obstacle[i]).y;
				temp_map[x][y] = 'O';
			}

			boolean check = true;
			loop: for (int i = 0; i < teacher_size; i++) {
				for (int j = 0; j < 4; j++) {
					int x = teacher.get(i).x;
					int y = teacher.get(i).y;
					while (true) {
						x = x + dx[j];
						y = y + dy[j];
						if (x < 0 || y < 0 || x >= N || y >= N)
							break;
						if (temp_map[x][y] == 'O')
							break;
						if (temp_map[x][y] == 'S') {
							check = false;
							break loop;
						}
					}
				}
			}
			if (check) {
				ans = true;
			}

			return;
		}

		for (int i = 0; i < empty_size; i++) {
			if (used[i])
				continue;

			obstacle[cnt] = i;
			used[i] = true;
			perm(cnt + 1);
			used[i] = false;
		}
	}

	static void deep_copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp_map[i][j] = map[i][j];
			}
		}
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(temp_map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
	}
}
