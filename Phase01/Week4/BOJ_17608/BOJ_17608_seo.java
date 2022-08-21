package Study08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17608_seo {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result=0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int top=0;
		for (int i=n-1; i>=0; i--) {
			if(top<arr[i]) {
				result++;
				top = arr[i];
			}
		}
		
		System.out.println(result);
	}
}