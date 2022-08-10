package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_seo {
	
	// 상하좌우
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int n, m;
	static int[][] map;
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<m; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(visited[n-1][m-1]+1);
	}

	private static void bfs(int a, int b) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {a,b});
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int nowx = now[0];
			int nowy = now[1];
			
			for (int i=0; i<4; i++) {
				int x = nowx+dx[i];
				int y = nowy+dy[i];
				if (x<0 || y<0 || x>=n || y>=m) continue;
				if (map[x][y]==1 && visited[x][y]==0) {
					visited[x][y] = visited[nowx][nowy]+1;
					que.add(new int[] {x,y});
				}

			}
		}

		
	}
}
