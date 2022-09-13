package day0908;

import java.util.Scanner;

public class BOJ_20363_hwang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		//두 수를 더하고 
		//둘 중 더 작은 수를 10으로 나눈 값을 더한다.
		int sum = X + Y + (Math.min(X, Y)/10);
		
		System.out.println(sum);
		
	}
}
