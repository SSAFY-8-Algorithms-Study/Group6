package Study08_01; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_seo {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[101][101];
		int ans=0;
		
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j=0; j<10; j++) {
				for (int k=0; k<10; k++) {
					arr[a+j][b+k]++;
				}
			}
		}
		
		for (int j=1; j<=100; j++) {
			for (int k=1; k<=100; k++) {
				if(arr[j][k]>0) ans++;
			}
		}
		System.out.println(ans);
	}
}