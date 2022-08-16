package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16922 {
	
	static char[] arr; //로마 문자 배열
	static int count; //N개의 로마 문자 조합 가능 개수
	static char[] roma; //N개의 로마 문자 조합 저장 배열
	static int N;
	static boolean[] num; //로마 

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new char[]{'I', 'V', 'X', 'L'};
		count=0;
		roma = new char[N];
		num = new boolean[1001];
		
		comb(0, 0); // 중복조합 호출
		System.out.println(count);
	
	}
	
	static void comb(int cnt, int start) {
		if(cnt == N) { 
			int sum=0;
			int romanum=0;
			for(int i=0; i<cnt; i++) { //중복이 허용되지만 로마 문자로 이루어진 숫자의 중복은 허용하지 않기 때문에 숫자 중복 제외하기 위한 for문
				
				switch(roma[i]) {
					case 'I' : romanum = 1;
					break;
					case 'V' : romanum = 5;
					break;
					case 'X' : romanum = 10;
					break;
					case 'L' : romanum = 50;
					break;
				}
				sum +=romanum;
			}
			
			if(num[sum]==false) {
				num[sum] = true;
				count++;
			}
			return;
		}
		else {
			for(int i=start; i<arr.length; i++) {
				roma[cnt] = arr[i];
				comb(cnt+1, i);
			}
		}
	}

}
