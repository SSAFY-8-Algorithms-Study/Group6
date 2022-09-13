package day0908;

import java.util.Scanner;

public class BOJ_9655_hwang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		//주어진 수가 짝수면 창영이가 이김.
		if(num%2==0) {
			System.out.println("CY");
		} else { //홀수면 상근이가 이김.
			System.out.println("SK");
		}
	}

}
