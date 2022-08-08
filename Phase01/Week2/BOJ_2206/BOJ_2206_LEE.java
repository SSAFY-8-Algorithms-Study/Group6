package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n, m, max, min=99999999;
	static int[][] map, count, stuck;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로축 크기
		m = Integer.parseInt(st.nextToken()); // 가로축 크기
		map = new int[n][m]; // 지도
		count = new int[n][m]; // bfs로 최소경로 카운트
		stuck = new int[n][m]; // bfs돌렸을때 카운트 되지 않는 지역과 카운트 되는 지역을 분리
		visited = new boolean[n][m]; // 지나간 지점인지 체크

		count[0][0] = 1; // 시작점도 횟수에 포함 +1
		for(int i=0; i<n; i++) { // map 입력
			String s = br.readLine().trim();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		

		bfs(0,0);
		if(count[n-1][m-1]==0) { // (n,m) 지점까지 도달하지 못했다.
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(count[i][j]!=0&&map[i][j]==0) {
						stuck[i][j] = 1; // count가 0이 아닌 지역은 1
					}
					else if(count[i][j]==0&&map[i][j]==0) {
						stuck[i][j] = 2; // count가 0인 지역은 2
					}
					//아예 bfs되지 않는 지역은 stuck이 0이다.
				}
			}
			
			count[n-1][m-1] = 1; // 시작지점도 count함
			bfs(n-1, m-1); // (n,m)에서부터 bfs시작
			break_wall(2);
			
			if(min==99999999) // 만나지 못한 두 영역 사이를 벽 하나로는 이을 수 없었을 때
				System.out.println(-1);
			else // 벽 하나를 두고 두 사이를 연결
				System.out.println(min+1);
			
		}
		else {
			int[] temp = break_wall(1); // 이었을 때 최소가 되는 좌표 반환
			map[temp[0]][temp[1]] = 0;
			count = new int[n][m];
			visited = new boolean[n][m];
			count[0][0] = 1;
			bfs(0,0);
			System.out.println(count[n-1][m-1]);
		}
			
		
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int curx = pos[0];
			int cury = pos[1];
			for(int i=0; i<4; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||map[nx][ny]==1) continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				count[nx][ny] = count[curx][cury] + 1;

			}
		}
	}
	
	static int[] break_wall(int t) { // 어느 벽을 부숴야 최솟값을 반환할지에 대한 함수
		int[] temp = {0, 0};
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<4; k++) {
					if(map[i][j]==0) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==0) continue; // 바로 옆에는 벽이어야함
						for(int l=0; l<4; l++) {
							int nnx = nx + dx[l];
							int nny = ny + dy[l];
							if(t==1) { // 벽을 부수지 않고도 경로를 찾을 수 있을 때
								if(nnx<0||nny<0||nnx>=n||nny>=m||map[nnx][nny]==1) continue; // 벽 하나를 사이에 두고 두 지점을 연결할 수 있을 때
								if(max < Math.abs(count[i][j] - count[nnx][nny])) { // 어느 두 지점을 연결했을 때 최대로 경로를 줄일 수 있을까
									max = Math.abs(count[i][j] - count[nnx][nny]);
									temp = new int[]{nx,ny}; 
								}
							}
							else if(t==2) { // 벽을 꼭 부숴야지만 경로를 찾을 수 있을 때
								if(nnx<0||nny<0||nnx>=n||nny>=m||map[nnx][nny]==1||stuck[i][j]*stuck[nnx][nny]!=2||!visited[i][j]||!visited[nnx][nny]) continue; // 벽 하나를 사이에 두고 두 지점을 연결할 수 있을 때 + 두 지점이 서로 다른 stuck영역
								if(min > Math.abs(count[i][j] + count[nnx][nny])){ // 어느 두 지점을 연결했을 때 최소 경로끼리 만나게 될까
									min = Math.abs(count[i][j] + count[nnx][nny]);
								}
							}

						}
						
					}
				}
			}
		}
		return temp;

	}
	
}
