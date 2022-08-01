package study;

import java.util.Scanner;

public class BOJ_1100_seo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 0;
		for ( int i=0 ; i<8 ; i++ ) {
			String str = sc.next(); // 칸 입력 정보 String으로 받음
			for ( int j=0 ; j<8 ; j++ ) {
				char ch = str.charAt(j); // 칸 입력 정보 char로 쪼갬
				if ( ch == 'F' ) {
					// 말이 있는 칸인데 흰색이면 증가
					if ( i%2==0 && j%2==0 ) count++; 
					else if ( i%2==1 && j%2==1 ) count++;
				}
					
			}
		}
		
		System.out.println(count);
	}
}
