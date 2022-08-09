package study_group_06.weak02;

import java.io.*;
import java.util.*;

public class Problem_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] schedule = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(schedule, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 끝 시간을 기준으로 정렬
				if (o1[1] > o2[1]) {
					return 1;
				} else if (o1[1] < o2[1]) {
					return -1;
				} else {
					// 두개가 서로 같을 때, 시작 시간을 기준으로 다시 정렬
					if (o1[0] > o2[0]) {
						return 1;
					} else {
						return -1;
					}
				}
			}
		});

//		for (int i = 0; i < N; i++) {
//			System.out.print("(" + schedule[i][0] + ", " + schedule[i][1] + ") ");
//
//		}

		int maxSchedule = 1;
		int endTime = schedule[0][1];

		// 2번이나 틀림 ㅋㅋㅋ
		// 1번째 틀린 이유 : endTime < schedule[i][0] 이라 (1, 4)와 (4, 4)가 같이있으면 해결을 못함
		// 2번째 틀린 이유 : 시작시간 또한 정렬되어 있어야 함. 만약 (4, 4), (1, 4)와 같은 경우 종료시간만 정렬되서 모두 카운트 못함
		// 함정이 많은 문제라 유의할 점이 많음
		for (int i = 1; i < N; i++) {
			if (endTime <= schedule[i][0]) {
				maxSchedule++;
				endTime = schedule[i][1];
			}
		}

		System.out.println(maxSchedule);

		br.close();
	}
}
