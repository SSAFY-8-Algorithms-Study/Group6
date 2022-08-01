package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468_seo {
	
	static int[][] map; // 높이값 저장 지도
	static boolean[][] visited; // 방문 확인 배열
	static int result; // 안전 지역 최대 개수
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n]; // 지도 초기화
		int minSize = 100; // 최소 높이
		int maxSize = 1; // 최대 높이
		
		// 지도 입력
		for (int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0 ; j<n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]>maxSize) maxSize=map[i][j]; // 최대높이 설정
				if (map[i][j]<minSize) minSize=map[i][j]; // 최소높이 설정
			}
		}
		
		// 모든 물에 잠기는 경우의 수 검사
		for ( int height=minSize ; height<=maxSize ; height++ ) {
			
			visited = new boolean[n][n]; // 방문 지도 초기화
			int count=0; // 해당 비 깊이에 따른 안전 구역 수 
			
			// 비에 잠긴 곳 방문 완료 처리
			for ( int i=0; i<n ; i++ ) {
				for (int j=0 ; j<n ; j++ ) {
					if (map[i][j]<height) visited[i][j]=true;
				}
			}
			
			// 비에 잠기지 않은 곳 (방문하지 않은 곳) 검사
			for ( int i=0; i<n ; i++ ) {
				for (int j=0 ; j<n ; j++ ) {
					if (!visited[i][j]) {
						check(i,j,n);
						count++;
					}
				}
			}
			
			if (count>result) result=count;
		}
		
		System.out.println(result);
	}
	
	static public void check(int a, int b, int n) {
		
		visited[a][b] = true; // 방문완료 처리
		
		// 상하좌우 탐색
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		for ( int i=0; i<4 ; i++ ) {
			int x = a+dx[i];
			int y = b+dy[i];
			if ( x<0 || y<0 || x>=n || y>=n ) continue;
			if ( !visited[x][y] ) check(x,y,n);
		}
	}
}
