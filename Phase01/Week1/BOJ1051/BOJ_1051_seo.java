package study;

import java.util.Scanner;

public class BOJ_1051_seo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int x=Math.min(n, m)-1; //정사각형 한변의 크기 저장할 변수 - 1
		int ans=0;
		int[][] square = new int[n][m];
		
		for ( int i=0 ; i<n ; i++ ) {
			String str = sc.next();
			for ( int j=0 ; j<m ; j++ ) {
				square[i][j]=str.charAt(j);
			}
		}
		
		
		Loop1:
		while(true)  {
			// 한변의 길이가 1이면
			if (x==0) {
				ans=1;
				break;
			}
			// 주어진 변의 크기 만큼 탐색
			for ( int i=0 ; i<n-x ; i++ ) {
				for ( int j=0 ; j<m-x ; j++) {
					int num=square[i][j];
					// 네 점 모두 같으면
					if (num==square[i+x][j] && num==square[i][j+x] 
							&& num==square[i+x][j+x]) {
						//System.out.println(i+" "+j);
						ans=(x+1)*(x+1);
						break Loop1; // 반복문 전체 종료
					}
				}
			}
			x--;
		}
		
		System.out.println(ans);
	}
}
