package study_group_06.week04;

import java.io.*;

public class Problem_2447 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 실수 연산이라서 int형 변환시 제대로 값이 안 나올 수 있음
		// ex) 5.999996은 int casting시 5가 됨
		int exp = (int) Math.ceil((Math.log(N) / Math.log(3))); 
//		System.out.println(exp);

		int pow;
		boolean isDrawing;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pow = 1;
				isDrawing = true;
				for (int e = 1; e <= exp; e++) {
					if ((i / pow) % 3 == 1 && (j / pow) % 3 == 1)
						isDrawing = false;
					pow *= 3;
				}

				if (isDrawing)
					sb.append("*");
				else
					sb.append(" ");

			}
			sb.append("\n");
		}

		System.out.print(sb);

		br.close();
	}
}
