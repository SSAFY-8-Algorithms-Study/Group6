package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
	static int white, blue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count_paper(arr, n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void count_paper(int[][] arr, int size) {
		int w=0, b=0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(arr[i][j]==0) {
					w++; 
				}
				else {
					b++;
				}
			}
		}
		if(w==size*size) white++;
		else if(b==size*size) blue++;
		else {
			for(int n=0; n<2; n++) {
				for(int m=0; m<2; m++) {
					int[][] arr2 = new int[size/2][size/2];
					for(int i=0; i<size/2; i++) {
						for(int j=0; j<size/2; j++) {
							arr2[i][j] = arr[i+size/2*n][j+size/2*m];
						}
					}
					count_paper(arr2, size/2);
				}
			}
		}
	}
}
