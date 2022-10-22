package Phase03.Week1.BOJ_5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_seo {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int w,h, ans;
	static boolean escape;
	static char[][] map;
	static int[][] visited;
	static Queue<Point> fires, que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new int[h][w];
			escape = false;
			ans = 0;
			fires = new LinkedList<>();
			que = new LinkedList<>();
			
			for (int i=0; i<h; i++) {
				String str = br.readLine();
				for (int j=0; j<w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j]=='@') {
						map[i][j] = '.';
						que.add(new Point(i,j));
						visited[i][j] = 1;
					}
					if (map[i][j]=='*') fires.add(new Point(i,j));
				}
			} // end input
			
			bfs();
			
			
			if (escape) System.out.println(ans);
			else System.out.println("IMPOSSIBLE");
		}
	}

	
	private static void bfs() {
		while(!que.isEmpty()) {
			int size = fires.size();
			for (int i=0; i<size; i++) {
				Point now = fires.poll();
				for (int d=0; d<4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					if (nx>=h || nx<0 || ny>=w || ny<0) continue;
					if (map[nx][ny]=='#' || map[nx][ny]=='*') continue;
					map[nx][ny] = '*';
					fires.add(new Point(nx,ny));
				}
			}
			
			size = que.size();
			for (int i=0; i<size; i++) {
				Point now = que.poll();
				for (int d=0; d<4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					if (nx<0 || ny<0 || nx>=h || ny>=w) {
						ans = visited[now.x][now.y];
						escape = true;
						return;
					}
					if (map[nx][ny]=='#' || map[nx][ny]=='*' || visited[nx][ny]!=0) continue;
					visited[nx][ny] = visited[now.x][now.y]+1;
					que.add(new Point(nx, ny));
				}
			}

		}
	}

	
	private static void printMap() {
		System.out.println("map =========");
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		} 
		System.out.println("=============");
	}
	
	
	private static void printVisited() {
		System.out.println("visited =====");
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		} 
		System.out.println("=============");
	}
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
