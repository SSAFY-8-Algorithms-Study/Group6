package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=i; j<N; j++) {
				sum += A[j];
				if(sum==M) {
					ans++;
					break;
				}
				else if(sum > M)
					break;
			}
		}
		
		System.out.println(ans);
	}
}
