package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] arr = new boolean[100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		for(int a=0; a<n; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					if(!arr[i][j]) arr[i][j] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
