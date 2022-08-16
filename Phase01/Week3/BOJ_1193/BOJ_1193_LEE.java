package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int cnt = 1;
		while(sum < n) {
			sum += cnt++;
		}
		int x = 0;
		int y = 0;
		if(cnt%2==0) {
			y = cnt - (sum - n + 1);
			x += sum - n + 1;
		}
		else {
			x = cnt - (sum - n + 1);
			y += sum - n + 1;
		}
		System.out.print(x+"/"+y);
	}
}
