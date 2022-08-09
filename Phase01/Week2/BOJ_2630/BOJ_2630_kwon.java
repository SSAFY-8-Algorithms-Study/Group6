package study_group_06.weak02;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_2630 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int exp = (int) (Math.log(N) / Math.log(2)); // log2(x)와 동일 한 기능. log의 성질을 기억할 것! logA(B) = logN(B)/logN(A)

		// 원본 보드의 1/2 크기 보드, 1/4 크기 보드, 1/8 크기 보드, ...를 만든다.
		// 이렇게 만들어도 원본 영역의 메모리의 2배 밖에 안 됨!
		// 2^n = 2^(n-1) + 2^(n-2) + 2^(n-3) + ... + 4 + 2 + 1
		int[][][] map = new int[exp + 1][][];
		for (int i = 0, n = N; i <= exp; i++, n /= 2) {
			map[i] = new int[n][n];
		}

		int white = 0;
		int blue = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int e = 0, n = N; e < exp; e++, n /= 2) {

			for (int i = 0; i < n; i += 2) {
				for (int j = 0; j < n; j += 2) {

					// [i][j], [i][j + 1], [i + 1][j], [i + 1][j + 1] 모두 같을 때
					// [i][j]칸이 차지하는 색종이 색에 따라 다음 보드에 색종이의 종류를 새로이 표시한다.
					if (map[e][i][j] == map[e][i][j + 1]
							&& map[e][i][j] == map[e][i + 1][j]
							&& map[e][i][j] == map[e][i + 1][j + 1]) {

						if (map[e][i][j] == 0) { // 0 : 하얀색일 때
							map[e + 1][i / 2][j / 2] = 0;
						} else if (map[e][i][j] == 1) { // 1 : 파란색일 때
							map[e + 1][i / 2][j / 2] = 1;
						} else { // -1 : 혼합일 때
							map[e + 1][i / 2][j / 2] = -1;
						}

						// 4 영역의 색이 모두 일치 하지 않을때, 각 칸의 색종이를 카운터에 가산하고 축소 보드에 -1을 표시한다.
					} else {
						for (int si = 0; si <= 1; si++) {
							for (int sj = 0; sj <= 1; sj++) {
								white = map[e][i + si][j + sj] == 0 ? white + 1 : white;
								blue = map[e][i + si][j + sj] == 1 ? blue + 1 : blue;
							}
						}
						map[e + 1][i / 2][j / 2] = -1;
					}
				}
			}
		}

		// 최종 보드는 1x1 사이즈 보드로 위의 메소드에서 처리하지 못하므로 별도로 처리한다.
		// 해당 코드가 없으면 모든 map이 단일색 (모두 하얀색 or 모두 파란색)으로 채워진 경우 체크할 수 없다.
		white = map[exp][0][0] == 0 ? white + 1 : white;
		blue = map[exp][0][0] == 1 ? blue + 1 : blue;

		sb.append(white).append("\n").append(blue);

		// 프린트 찍어보는 함수
//		print(map, N, exp);
		System.out.println(sb);

		br.close();
	}

//	static void print(int[][][] map, int N, int exp) {
//		for (int e = 0, n = N; e <= exp; e++, n /= 2) {
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(map[e][i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==========");
//		}
//	}
}
