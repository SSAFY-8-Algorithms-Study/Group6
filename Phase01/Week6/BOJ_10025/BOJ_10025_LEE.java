package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ice = new int[1000001];
		
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ice[x] = g;
			if(x<=2*K) {
				max += ice[x];
			}
		}
		
		int temp = max;
		for(int i=K; i<1000001-K-1; i++) {
			temp -= ice[i-K];
			temp += ice[i+K+1];
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}
}