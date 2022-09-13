package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22116 {
	static class Point{
		int x, y, cost;
		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.cost - o2.cost;
		}); 
		pq.add(new Point(0, 0, 0));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			max = Math.max(max, p.cost);
			if(p.x==N-1&&p.y==N-1) break;
			visited[p.x][p.y] = true;
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(visited[nx][ny]) continue;
				pq.add(new Point(nx, ny, Math.abs(map[nx][ny]-map[p.x][p.y])));
			}
		}
		
		System.out.println(max);

	}
}
