package Week5.BOJ_2624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2624_seo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] dp = new int[T+1]; // 0~T원까지
		Coin[] coin = new Coin[k]; // 코인 k개에 대한 정보
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = new Coin(Integer.parseInt(st.nextToken()), 
							   Integer.parseInt(st.nextToken()));
		}
		
		dp[0]=1; // 기저조건으로 사용하기 위해 0원일때 1가지 경우라고 가정
		
		for (int i=0; i<k; i++) {
			int min = coin[i].price; // 현재 동전 가격 = 이 동전으로 가능한 최소값
			for (int j=T; j>=min; j--) { // T원에서 min까지 메모이제이션
				for (int c=1; c<=coin[i].cnt; c++) { // 동전을 1~가진갯수가까지 반복
					if (j < min*c) break; // 현재 목표 가격보다 만든 가격이 클 경우 종료
					dp[j] += dp[j - min*c]; // j를 만들 수 있는 직전 가격의 경우의 수 더해줌
				}
			}
		}
		
		System.out.println(dp[T]);
		
	}
	
	static class Coin {
		int price, cnt;
		public Coin(int price, int cnt) {
			this.price = price;
			this.cnt = cnt;
		}
	}
}
