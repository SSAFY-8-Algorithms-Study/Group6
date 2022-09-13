package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15997 {
	static class Record {
		String A, B;
		double win, draw, lose;

		public Record(String A, String B, double win, double draw, double lose) {
			this.A = A;
			this.B = B;
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}
	}

	static String[] team;
	static Record[] record;
	static double[] probability;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		team = new String[4];
		for (int i = 0; i < 4; i++) {
			team[i] = st.nextToken();
		}
		record = new Record[6];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			double win = Double.parseDouble(st.nextToken());
			double draw = Double.parseDouble(st.nextToken());
			double lose = Double.parseDouble(st.nextToken());
			record[i] = new Record(A, B, win, draw, lose);
		}
		result = new int[6];
		probability = new double[4];
		perm(0);
		for (int i = 0; i < 4; i++) {
			System.out.println(probability[i]);
		}
	}

	static void perm(int idx) {
		if (idx == 6) {
			double prob = 1; // 확률
			int[] score = { 0, 0, 0, 0 }; // 승점
			for (int i = 0; i < 6; i++) {
				switch (result[i]) {
				case 0: // A팀 승리
					for (int j = 0; j < 4; j++) {
						if (team[j].equals(record[i].A)) {
							score[j] += 3;
						}
					}
					prob *= record[i].win;
					break;
				case 1: // 무승부
					for (int j = 0; j < 4; j++) {
						if (team[j].equals(record[i].A))
							score[j] += 1;
						else if (team[j].equals(record[i].B))
							score[j] += 1;
					}
					prob *= record[i].draw;
					break;
				case 2: // B팀 승리
					for (int j = 0; j < 4; j++) {
						if (team[j].equals(record[i].B))
							score[j] += 3;
					}
					prob *= record[i].lose;
					break;
				default:
					break;
				}
				
			}
			
			// 각 팀의 순위 매기기
			int[] rank = { 1, 1, 1, 1 };
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (score[j] > score[i]) {
						rank[i]++;
					}
				}
			}
			
			// 순위에 따른 확률 덧셈
			for(int i=0; i<4; i++) {
				// 3위나 4위는 진출 X이므로 확률에 더해주지 않음
				if(rank[i]==3 || rank[i]==4) continue;
				if(rank[i]==1) {
					int same = 0;
					for(int j=0; j<4; j++){
						if(rank[j]==1) {
							same++;
						}
					}
					// 1위가 세팀
					if(same==3) {
						probability[i] += prob/3*2;
					}
					// 1위가 네팀
					else if(same==4) {
						probability[i] += prob/4*2;
					}
					// 1위가 한팀이나 두팀이면 추첨 X
					else {
						probability[i] += prob;
					}
				}
				if(rank[i]==2) {
					int same = 0;
					for(int j=0; j<4; j++){
						if(rank[j]==2) {
							same++;
						}
					}
					// 2위가 두팀
					if(same==2) {
						probability[i] += prob/2;
					}
					// 2위가 세팀
					else if(same==3) {
						probability[i] += prob/3;
					}
					// 2위가 한팀이면 추첨 X (2위가 네팀인 경우는 없다.)
					else {
						probability[i] += prob;
					}
				}
			}
			return;
		}
		
		// 중복 순열 생성
		for (int i = 0; i < 3; i++) {
			result[idx] = i;
			perm(idx + 1);
		}
	}
}
