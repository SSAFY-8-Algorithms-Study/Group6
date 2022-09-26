package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		int[] sum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(stair[1]);
		}
		else if(N==2) {
			System.out.println(stair[1]+stair[2]);
		}
		else {
			sum[0] = 0;
			sum[1] = stair[1];
			sum[2] = stair[1] + stair[2];
			for (int i = 3; i <= N; i++) {
				sum[i] = Math.max(sum[i - 2] + stair[i], sum[i - 3] + stair[i - 1] + stair[i]);
			}
			System.out.println(sum[N]);
		}

	}
}
