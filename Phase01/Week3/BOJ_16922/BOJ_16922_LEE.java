package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_16922 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int[] sum = new int[1771];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n-i; j++) {
				for(int k=0; k<=n-i-j; k++) {
					sum[cnt] += 1*i + 5*j + 10*k + 50*(n-i-j-k);
					cnt++;
				}
			}
		}
		
		HashSet<Integer> result = new HashSet<>();
		for(int i=0; i<cnt; i++) {
			result.add(sum[i]);
		}
		System.out.println(result.size());
	}
}
