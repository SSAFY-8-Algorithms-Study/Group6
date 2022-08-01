package study;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1059_seo {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt(); // 집합 s의 크기
		int ans=0; // 정답변수
		int sMin=-1, sMax=0;
		int[] s = new int[l]; // 집합 s
		for ( int i=0; i<l; i++) {
			s[i]=sc.nextInt(); // 집합 s의 원소 입력
		}
		int n = sc.nextInt();
		Arrays.sort(s); // 오름차순으로 정렬
		
		if (l==1) {
			ans=s[0]-l-1;
		}
		
		for ( int i=0; i<l-1; i++) {
			if (s[0]>n) {
				for ( int k=1; k<=n; k++ ) {
					for ( int j=k; j<s[0]; j++ ) {
						if (k==j || !(k<=n && j>=n)) continue;
						//System.out.println(k+" : "+j);
						ans++;
					}
				}
				break;
			}
			
			if (s[i]==n) {
				ans=0;
				break;
			}
			if (s[i]<n && s[i+1]>n) {
				sMin=s[i]+1;
				sMax=s[i+1]-1;
				//System.out.println(sMin+" ! "+sMax);
				for ( int k=sMin; k<=n; k++ ) {
					for ( int j=k; j<=sMax; j++ ) {
						if (k==j || !(k<=n && j>=n)) continue;
						//System.out.println(k+" : "+j);
						ans++;
					}
				}
				break;
			}
			if (i==l-2 && sMin==-1) ans=0;
		}
		
		System.out.println(ans);
	}
}
