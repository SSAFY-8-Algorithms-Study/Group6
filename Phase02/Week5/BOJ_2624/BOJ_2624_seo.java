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
		int[] dp = new int[T+1]; // 0~T������
		Coin[] coin = new Coin[k]; // ���� k���� ���� ����
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = new Coin(Integer.parseInt(st.nextToken()), 
							   Integer.parseInt(st.nextToken()));
		}
		
		dp[0]=1; // ������������ ����ϱ� ���� 0���϶� 1���� ����� ����
		
		for (int i=0; i<k; i++) {
			int min = coin[i].price; // ���� ���� ���� = �� �������� ������ �ּҰ�
			for (int j=T; j>=min; j--) { // T������ min���� �޸������̼�
				for (int c=1; c<=coin[i].cnt; c++) { // ������ 1~�������������� �ݺ�
					if (j < min*c) break; // ���� ��ǥ ���ݺ��� ���� ������ Ŭ ��� ����
					dp[j] += dp[j - min*c]; // j�� ���� �� �ִ� ���� ������ ����� �� ������
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
