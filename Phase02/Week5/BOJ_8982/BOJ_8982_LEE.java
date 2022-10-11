package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_8982 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int water = 0;
		int[][] line = new int[N / 2 + 1][4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		line[0][1] = Integer.parseInt(st.nextToken());
		line[0][0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N / 2; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			line[i][0] = x1;
			line[i][1] = y1;
			line[i][2] = x2;
			line[i][3] = y2;
		}
		st = new StringTokenizer(br.readLine());
		line[N / 2][1] = Integer.parseInt(st.nextToken());
		line[N / 2][0] = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());
		int[][] hole = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for (int j = 1; j < N / 2; j++) {
				if (line[j][0] == x1 && line[j][1] == y1 && line[j][2] == x2 && line[j][3] == y2) {
					hole[i][0] = j;
					hole[i][1] = Math.min(line[j - 1][0], x1);
					hole[i][2] = Math.min(line[j + 1][0], x1);
				}
			}
		}

		Arrays.sort(hole, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[] h = new int[N / 2 + 1];
		for (int i = 0; i < K; i++) {
			h[hole[i][0]] = line[hole[i][0]][0];
			int temp = hole[i][1];
			for (int j = hole[i][0] - 1; j >= 1; j--) {
				temp = Math.min(temp, line[j][0]);
				h[j] = Math.max(h[j], temp);
			}
			temp = hole[i][2];
			for(int j=hole[i][0] + 1; j<N/2; j++) {
				temp = Math.min(temp, line[j][0]);
				h[j] = Math.max(h[j], temp);
			}
		}
		
		for(int i=1; i<N/2; i++) {
			if(line[i][0] > h[i])
				water += (line[i][3] - line[i][1]) * (line[i][0] - h[i]);
		}

//		for (int i = 1; i < N/2; i++) {
//			System.out.print(h[i]+" ");
//		}
//		System.out.println();
		System.out.println(water);
	}
}
