package d0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1059_hwang {

	public static void main(String[] args) throws IOException {
		int cnt = 0; //좋은 구간 개수
		boolean Snnotequals = true; //S배열의 값과 n이 다른지 확인하는 boolean
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken()); //집합 크기 저장
		int[] S = new int[L]; 
		
		st = new StringTokenizer(br.readLine());
		//집합에 숫자 저장
		for(int i=0; i<S.length; i++) { 
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		
		Arrays.sort(S);
		
		//집합 S에 n값과 동일한 값이 있다면 0 출력
		for(int i=0; i<S.length; i++) {
			if(S[i] == n) {
				Snnotequals = false;
				System.out.println(0);
				break;
			}
		}
		
		if(Snnotequals) {
			if(n<=S[0]) {
				cnt = (n-0) * (S[0]-n)-1;
			}
			else {
				for(int i=1; i<S.length; i++) {
					if(n<=S[i]) {
						cnt = (n-S[i-1])*(S[i]-n)-1;
						break;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

}
