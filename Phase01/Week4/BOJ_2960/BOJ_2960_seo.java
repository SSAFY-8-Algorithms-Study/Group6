package Study08_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960_seo {
	
	static boolean[] prime;
	static StringBuilder sb = new StringBuilder();
	
	static public void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		prime = new boolean[n+1];
		
		prime(n, k);
		
		System.out.println(sb);
	}

	// 에라토스테네스의 체
	private static void prime(int n, int k) {
		int count = 0;
		// 0과 1은 방문처리
		prime[0] = true; 
		prime[1] = true;
		
		loop:
		for ( int i=2 ; i<=n ; i++ ) { // 2부터 n까지
			for ( int j=i ; j<=n ; j=j+i ) { // 배수를 크기 순서대로 지우기
				if ( prime[j]==true ) continue; // 지워지지 않은 수만 적용
				prime[j]=true;
				count++;
				if ( k == count ) { // k번째가 되면 종료
					sb.append(j);
					break loop;
				}
			}
		}
	}
}
