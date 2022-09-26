package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086 {
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1)
					continue;
				boolean[][] visited = new boolean[N][M];
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(i, j));
				visited[i][j] = true;
				int dist = 0;
				loop:
				while(!q.isEmpty()) {
					int size = q.size();
					dist++;
					for(int t=0; t<size; t++) {
						Point p = q.poll();
						for(int k=0; k<8; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							if(nx<0||ny<0||nx>=N||ny>=M)
								continue;
							if(visited[nx][ny])
								continue;
							if(map[nx][ny]==1)
								break loop;
							q.add(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
				max = Math.max(max, dist);
			}

		}
		
		System.out.println(max);
	}
}
