package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2922_seo {
	
//	[C. 즐거운 단어]
//	즐거운 단어, 즐겁지 않은 단어
	
//	[ 즐거운 단어 ]
//	- 모음이 연속해서 3번, 자음이 연속해서 3번 나오지 않음
//	- 반드시 L을 포함
	
//	[ 즐겁지 않은 단어 수정법 ] 
//	1. 보기 싫은 알파벳을 지우개로 지우고
//	2. 그 자리에 밑줄 (_)을 적는다
//	3. 밑줄 (_) 에 즐거운 단어를 만드는 알파벳을 적는다
	
//	=> 보기 싫은 알파벳이 주어지고, 즐거운 단어를 만들 수 있는 경우의 수?
	
	static int size;
	static long result;
	static String str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		size = str.length();
		result = 0;
		
		dfs(0,0,0,false,1); // 단어만들기 시작
		
		System.out.println(result);

	}

	private static void dfs(int idx, int a, int b, boolean L, long cnt) { // 자리, 모음, 자음
		
		if (idx==size) { // 단어가 완성됨
			if (!L) return; // L이 사용되지 않았으면 리턴
			result+=cnt; // 누적시킨 가능한 단어 수 합함
			return;
		}
		
		char now = str.charAt(idx);
		if (now=='_') { // 빈 곳이면
	        boolean A=true;
	        boolean B=true;
	        if(a==2) A=false; // 모음이 이미 두개이면 자음 쓰자
	        if(b==2) B=false; // 자음이 이미 두개이면 모음 쓰자
			// 모음 사용
			if (A) {
				dfs(idx+1, a+1, 0, L, cnt*5); // 모음 사용 
			}
			// 자음 사용
			if (B) {
				dfs(idx+1, 0, b+1, true, cnt); // L사용 
				dfs(idx+1, 0, b+1, L, cnt*20); // L 제외 모두 사용
				// 26 - 5(모음) - 1(L) = 20
			}
		}
		// 모음이면
		else if (now=='A'||now=='E'||now=='I'||now=='O'||now=='U') { 
			if (a==2) return; // 모음이 이미 두개이면 불가능하다
			dfs(idx+1, a+1, 0, L, cnt); 
		}
		else { // 자음이면
			if (b==2) return; // 자음이 이미 두개이면 불가능하다
			if (now=='L') dfs(idx+1, 0, b+1, true, cnt); // L 사용
			else dfs(idx+1, 0, b+1, L, cnt); 
		}

	}
}