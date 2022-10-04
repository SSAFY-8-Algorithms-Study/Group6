package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987 {
	static int[] win, draw, lose;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			int total_game_cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				total_game_cnt += win[j] + draw[j] + lose[j];
			}
			
			ans = false;
			if (total_game_cnt == 30) {
				game(0, 0, 1);
			}
			
			if (ans) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}

	}

	static void game(int idx, int team, int team2) {
		if (win[team] < 0 || draw[team] < 0 || lose[team] < 0)
			return;

		if (idx == 15) {
			for (int i = 0; i < 6; i++) {
				if (win[i] != 0 || draw[i] != 0 || lose[i] != 0)
					return;
			}
			ans = true;
			return;
		}

		if (idx == 5 || idx == 9 || idx == 12 || idx == 14) {
			team++;
			team2 = team + 1;
		}

		win[team]--;
		lose[team2]--;
		game(idx + 1, team, team2 + 1);
		win[team]++;
		lose[team2]++;

		draw[team]--;
		draw[team2]--;
		game(idx + 1, team, team2 + 1);
		draw[team]++;
		draw[team2]++;

		lose[team]--;
		win[team2]--;
		game(idx + 1, team, team2 + 1);
		lose[team]++;
		win[team2]++;
	}

}
