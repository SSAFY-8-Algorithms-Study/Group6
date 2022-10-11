package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] ans = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				ans[i][j] = map[i][j];
			}
		}
		
		// floyd warshall 220ms
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(ans[i][k]==1&&ans[k][j]==1)
						ans[i][j] = 1;
				}
			}
		}

		// bfs 2600ms
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				Queue<Integer> q = new LinkedList<>();
//				boolean[][] visited = new boolean[N][N];
//				if(map[i][j]==1) {
//					q.add(j);
//					visited[i][j] = true;
//					ans[i][j] = 1;
//					while(!q.isEmpty()) {
//						int x = q.poll();
//						for(int y=0; y<N; y++){
//							if(visited[x][y])
//								continue;
//							if(map[x][y]==1) {
//								q.add(y);
//								visited[x][y] = true;
//								ans[i][y] = 1;
//							}
//						}
//					}
//				}
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ans[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
