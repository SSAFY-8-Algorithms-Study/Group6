package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143 {
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	static int R, C, M, sum_size;
	static Shark[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Shark shark = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			map[shark.r][shark.c] = shark;
		}

		for (int i = 1; i <= C; i++) {
			catch_shark(i);
			move_shark();
		}

		System.out.println(sum_size);

	}

	static void catch_shark(int t) { // t초
		for (int i = 1; i <= R; i++) {
			if (map[i][t] != null) {
				sum_size += map[i][t].z;
				map[i][t] = null;
				break;
			}
		}
	}

	static void move_shark() { // 상어 이동
		Shark[][] temp_map = new Shark[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == null)
					continue;
				Shark shark = map[i][j];
				int time = shark.s;
				int dir = shark.d;
				int nx = shark.r;
				int ny = shark.c;
				
				// 반복이므로 2*(R-1), 2*(C-1) 이후에는 같은 방향과 자리로 되돌아 오는 것을 이용하여 반복문을 줄인다.
				if(dir==1||dir==2)
					time %= 2*(R-1);
				else
					time %= 2*(C-1);
				
				while (time > 0) {
					nx += dx[dir - 1];
					ny += dy[dir - 1];
					if (nx <= 0 || ny <= 0 || nx > R || ny > C) {
						nx -= dx[dir - 1];
						ny -= dy[dir - 1];
						dir = change_dir(dir);
						nx += dx[dir - 1];
						ny += dy[dir - 1];
					}
					time--;
				}
				if (temp_map[nx][ny] != null) {
					Shark prev_shark = temp_map[nx][ny];
					if (shark.z > prev_shark.z)
						temp_map[nx][ny] = new Shark(nx, ny, shark.s, dir, shark.z);
				} else
					temp_map[nx][ny] = new Shark(nx, ny, shark.s, dir, shark.z);
			}
		}
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = temp_map[i][j];
			}
		}
		// print(temp_map);
		// System.out.println(sum_size);
	}

	static int change_dir(int d) { // 벽 만나면 방향 전환
		if (d == 1)
			return 2;
		else if (d == 2)
			return 1;
		else if (d == 3)
			return 4;
		else
			return 3;
	}

	static void print(Shark[][] map) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == null)
					System.out.print(0 + " ");
				else
					System.out.print(map[i][j].z + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
