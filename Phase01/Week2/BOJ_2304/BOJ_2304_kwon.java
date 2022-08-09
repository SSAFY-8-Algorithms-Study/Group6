package study_group_06.weak02;

// 같은 높이의 기둥이 2개 이상 있을 수 있으므로 같은 높이의 다른 기둥을 만났을 때도 새로 계산하도록 할 것

import java.io.*;
import java.util.StringTokenizer;

public class Problem_2304 {
	static int landLength = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int sumArea = 0;
		int px = 0, py = 0;
		int lowerIdx = 1000;
		int upperIdx = 1;
		int maxHeight = 0;
		int maxIdx = 0;

		int[] land = new int[landLength + 1];

		for (int p = 1; p <= N; p++) {
			st = new StringTokenizer(br.readLine());
			px = Integer.parseInt(st.nextToken());
			py = Integer.parseInt(st.nextToken());

			land[px] = py;
			if (py > maxHeight) {
				maxIdx = px;
				maxHeight = py;
			}

			upperIdx = Math.max(upperIdx, px);
			lowerIdx = Math.min(lowerIdx, px);
		}

//		print(land, lowerIdx, upperIdx);
//		System.out.println(maxIdx);

		int pillarMax = 0;
		int pillarIdx = 0;

		int leftSum = 0;
//		for (int i = lowerIdx; i < maxIdx; i++) { // 틀린 구문. 이러면 동일한 높이의 기둥이 2개 있을 때 문제가 발생, 아래도 원리는 동일
		for (int i = lowerIdx; i <= maxIdx; i++) {
			if (land[i] >= pillarMax) {
				leftSum += Math.abs(i - pillarIdx) * pillarMax;
				pillarMax = land[i];
				pillarIdx = i;
			}
		}

		pillarMax = 0;
		pillarIdx = 0;

		int rightSum = 0;
		for (int i = upperIdx; i >= maxIdx; i--) {
			if (land[i] >= pillarMax) {
				rightSum += Math.abs(i - pillarIdx) * pillarMax;
				pillarMax = land[i];
				pillarIdx = i;
			}
		}

		sumArea = leftSum + maxHeight + rightSum;

		System.out.println(sumArea);

		br.close();
	}

//	static void print(int[] land, int lower, int upper) {
//		for (int i = lower; i < upper; i++) {
//			System.out.printf("%4d", land[i]);
//		}
//		System.out.println();
//	}
}