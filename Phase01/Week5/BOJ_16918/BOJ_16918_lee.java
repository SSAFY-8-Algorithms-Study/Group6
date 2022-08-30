package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918 {
	static int r, c;
	static char[][] arr, arr2, arr3;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		arr = new char[r][c]; // 초기 상태
		arr2 = new char[r][c]; // 폭탄이 모두 차있는 상태
		arr3 = new char[r][c]; // 초기 폭탄만 터진 상태
		
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		while(true) {
			if(n==1) {
				print(arr);
				break;
			}
			fill_bomb(arr2);
			n--;
			if(n==1) {
				print(arr2);
				break;
			}
			bomb2();
			n--;
			if(n==1) {
				print(arr2);
				break;
			}
			fill_bomb(arr);
			n--;
			if(n==1) {
				print(arr);
				break;
			}
			bomb();
			n--;
		}
		

	}
	
	static void bomb() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr2[i][j] == 'O') {
					arr[i][j] = '.';
					for(int k=0; k<4; k++) {
						int ni = i+di[k];
						int nj = j+dj[k];
						if(ni<0||nj<0||ni>=r||nj>=c) continue;
						arr[ni][nj] = '.';
					}
				}
			}
		}
	}
	static void bomb2() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i][j] == 'O') {
					arr2[i][j] = '.';
					for(int k=0; k<4; k++) {
						int ni = i+di[k];
						int nj = j+dj[k];
						if(ni<0||nj<0||ni>=r||nj>=c) continue;
						arr2[ni][nj] = '.';
					}
				}
			}
		}
	}
	
	static void fill_bomb(char[][] arr) {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				arr[i][j] = 'O';
			}
		}
	}
	
	static void print(char[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
