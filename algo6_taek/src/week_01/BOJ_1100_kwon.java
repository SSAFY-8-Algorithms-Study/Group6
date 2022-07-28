package week_01;

import java.io.*;

public class BOJ_1100_kwon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int piece = 0;
		int padding = 0;

		// 보드의 생김새를 봤을 때
		// 0줄은 [흰-검-흰-검-흰-검-흰-검]
		// 1줄은 [검-흰-검-흰-검-흰-검-흰] 이며,
		// 1줄의 형태는 0줄에 검은색 칸을 하나 더 추가한 검-[흰-검-흰-검-흰-검-흰-검]과 같다.
		// 그러므로 홀수 줄 일 때 마다 패딩을 추가하여 일괄된 자리값을 얻도록 한다.

		for (int i = 0; i < 8; i++) {
			line = br.readLine().trim();
			padding = (i % 2 == 0) ? 0 : 1; // 패딩이 필요한 줄인가 아닌가 계산. 삼항 연산자 사용

			for (int j = 0; j < 8; j++) {
				if (line.charAt(j) == 'F') { // 보드에 기물'F'가 있는 경우 체크
					piece += ((j + padding) % 2 == 0) ? 1 : 0; // 기물이 하얀색 칸 위에 있는가 체크
				}
			}
		}

		System.out.println(piece);

		br.close();
	}
}
