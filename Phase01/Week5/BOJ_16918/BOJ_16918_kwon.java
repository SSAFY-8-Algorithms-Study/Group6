package study_group_06.week05;

import java.io.*;
import java.util.*;

public class Problem_16918 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		String line;

		int timer = 1;

		for (int i = 0; i < R; i++) {
			line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == 'O')
					map[i][j] = 2;
				else
					map[i][j] = -1;
			}
		} // end input

		int nx, ny;

		while (timer != N) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = map[i][j] == -1 ? -1 : map[i][j] - 1;
				}
			}

			int[][] nextMap = new int[map.length][];
			for (int i = 0; i < map.length; i++)
				nextMap[i] = Arrays.copyOf(map[i], map[i].length);

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0) {
						nextMap[i][j] = -1;
						for (int d = 0; d < dx.length; d++) {
							nx = j + dx[d];
							ny = i + dy[d];

							if (nx < 0 || C <= nx || ny < 0 || R <= ny)
								continue;

							nextMap[ny][nx] = -1;
						}
					}
				}
			}

			map = nextMap;

			if (timer % 2 == 1) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == -1) {
							map[i][j] = 3;
						}
					}
				}
			}
			timer++;
			print(map);
		}
		print(map);

		br.close();
	}

	static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] + 1);
			}
			sb.append(' ');
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] == -1 ? '.' : 'O');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}