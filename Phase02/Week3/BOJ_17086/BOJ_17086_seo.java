package Week3.BOJ_17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_seo {
	
	//  이동은 인접한 8방향(대각선 포함)
	static int[] dx = {-1,1,0,0,1,1,-1,-1}; // 상하좌우대각선
	static int[] dy = {0,0,-1,1,-1,1,-1,1};	
	static int N, M, ans;
	static int map[][], visited[][];
	
	// 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리
	// => 안전 거리의 최댓값
	// bfs로 거리에 최소값을 갱신
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end
		
//		for(int i=0; i<r; i++) {
//			for(int j=0; j<c; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		} // check input
		
		bfs();
		System.out.println(ans);
		
	}
	
	
	private static void bfs() {
		ans = -1;
		Queue<Point> que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) { // 상어있는 곳 add
					que.add(new Point (i, j));
				}
			}
		}
		
		while (!que.isEmpty()) {
			Point now = que.poll();
			
			for (int i = 0; i < 8; i++) {
				
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				if (visited[nextX][nextY] != 0 || map[nextX][nextY] == 1) continue;
				visited[nextX][nextY] = visited[now.x][now.y]+1;
				if (visited[nextX][nextY] > ans) ans = visited[nextX][nextY]; // 최댓값 갱신
				que.add(new Point(nextX,nextY));
			}
		
		}
	}


	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
