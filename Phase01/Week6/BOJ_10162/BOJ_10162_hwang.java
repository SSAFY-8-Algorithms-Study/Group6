package day0904;

import java.util.Scanner;

public class BOJ_10162_hwang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		//분을 모두 초로 바꿔서 계산
		int a = T / 300;
		int b = (T % 300) / 60;
		int c = ((T % 300) % 60) / 10;
		int ansA = a, ansB = b, ansC = c;

		int ans = 0; //300, 60, 10으로 나눠지지 않는다면 -1 넣어줌.
		if ((300 * a) + (60 * b) + (10 * c) != T) {
			ans = -1;
		}

		if (ans == 0) {
			System.out.println(ansA + " " + ansB + " " + ansC);
		} else {
			System.out.println(ans);
		}

	}

}
