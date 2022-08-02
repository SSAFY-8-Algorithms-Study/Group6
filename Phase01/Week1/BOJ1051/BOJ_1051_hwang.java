package d0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_hwang {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] ractangle = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] NMarr = br.readLine().split("");
			for(int j=0; j<M; j++) {
				ractangle[i][j] = Integer.parseInt(NMarr[j]);
				
			}
		}
	
		

		int area = 1; //정사각형의 넓이
		int maxarea = 1;
		
		for(int i=0; i<N; i++) {//정사각형 이동
			for(int j=0; j<M; j++) {
				for(int d=1; d<Math.min(N, M); d++) {
					if(i+d<N && j+d<M && ractangle[i+d][j] == ractangle[i][j] && ractangle[i][j+d] == ractangle[i][j] 
							&& ractangle[i+d][j+d] == ractangle[i][j]) { 
						
						area = (d+1) * (d+1);
						maxarea = Math.max(area,  maxarea);
					
					}
				
				}
			}
		}
		System.out.println(maxarea);
	}

	
}
