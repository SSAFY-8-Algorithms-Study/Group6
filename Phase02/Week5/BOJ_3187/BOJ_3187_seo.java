package Week5.BOJ_3187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187_seo {
	
//	[c. 양치기 꿍]
//	빈 공간을 '.'(점)으로 나타내고 울타리를 '#', 늑대를 'v', 양을 'k'
//	같은 울타리 영역 안의 양들의 숫자가 늑대의 숫자보다 더 많을 경우 늑대가 전부 잡아먹힌다.
//	그 외의 경우는 양이 전부 잡아먹히겠지만 말이다.
	
//	[풀이]
//	1. 영역1을 bfs로 순회
//	2. 늑대와 양의 수를 비교해 살아남는 개체만 각 누적해 기록
//	3. 모든 영역 순회가 끝나면 종료
	
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	static int R,C, wolf, sheep;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		wolf=0; sheep=0;
		
		for (int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		} // end input
		
//		for (int i=0; i<R; i++) {
//			for (int j=0; j<C; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		} // check map
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				char ch = map[i][j];
				if ((ch=='v' || ch=='k') && !visited[i][j]) bfs(i,j);
			}
		}
		
		System.out.println(sheep+" "+wolf);
	}
	
	// bfs + 양 vs 늑대
	private static void bfs(int a, int b) {
		int v=0, k=0; // 늑대와 양 수 저장
		
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(a, b));
		visited[a][b] = true;
		if (map[a][b]=='v') v++;
		if (map[a][b]=='k') k++;
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			for (int d=0; d<4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx<0 || ny<0 || nx>=R || ny>=C || map[nx][ny]=='#' || visited[nx][ny]) continue;
				if (map[nx][ny]=='v') v++;
				if (map[nx][ny]=='k') k++;
				visited[nx][ny] = true;
				que.add(new Point(nx, ny));
			}
			
			
		} // end bfs 
		//printVisited();// check visited	
		//System.out.println(v+" "+k);
		// winner
		if (k>v) sheep += k;
		else wolf += v;
	}
	
	
	// bfs 방문체크 디버깅용
	static void printVisited() {
		System.out.println("---------");
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (visited[i][j]) System.out.print("o");
				else System.out.print("x");
			}
			System.out.println();
		} 
	}
	
	// 위치 정보에 사용할 객체
	static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}