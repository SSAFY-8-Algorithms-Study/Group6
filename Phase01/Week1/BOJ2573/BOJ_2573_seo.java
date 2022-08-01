package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_seo {
	
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map; // 기존 지도
	//static int[][] current; // 바뀐 지도
	static int[][] visited; // 방문 지도
	static int n,m,count=0; // n,m,덩어리 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		int time=0;
		
		// map 채우기
		for (int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0 ; j<m ; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}
		
		
		while (true) {
			visited = new int[n][m]; // 방문 초기화
			count=0; // 덩어리 초기화
			int hieght = 0; // 최대 높이
			
			// 빙산이 몇 덩어리로 나뉘었는지 탐색
			for (int i=0 ; i<n ; i++) {
				for (int j=0 ; j<m ; j++) {
					if (hieght<map[i][j]) hieght = map[i][j]; // 최대 높이 저장
					// 만약 빙산이 안녹아있고, 방문하지 않았다면 => 해당 지점부터 bfs실행
					if(map[i][j]>0 && visited[i][j]==0) {
						bfs(i,j);
						count++; // 덩어리 수 더하기
					}
				}
			}
			
			//printMap(hieght);
			if (hieght==0) break; // 높이 모두 0이면 반복 종료
			if (count>=2) break; // 두덩어리 이상이면 반복 종료
			time++; // 1년 추가
			
			// 바닷물에 닿는 빙산 녹기
			visited = new int[n][m]; // 방문 초기화
			for (int i=0 ; i<n ; i++) {
				for (int j=0 ; j<m ; j++) {
					if(map[i][j]>0) map[i][j] -= melt(i,j); // 녹기
				}
			}
			
		}
		
		// 반복이 모두 끝나도 2 덩어리 이상이 아니라면 0 출력
		if (count<2) time=0;
		//System.out.println(sb);
		System.out.println(time);
	}


	// map[a][b]부터 bfs로 탐색하여 메소드 끝나면 count++
	private static void bfs(int a, int b) {
		
		// 큐 생성 후 시작점 추가와 방문 처리
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {a,b});
		visited[a][b]++;
				
		// 큐가 빌 때까지 노드 poll
		while (!que.isEmpty()) {
			int now[] = que.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			// 상하좌우 확인
			for ( int i=0 ; i<4 ; i++ ) {
				int x=nowX+dx[i];
				int y=nowY+dy[i];
				if ( x<0 || y<0 || x>=n || y>=m ) continue;
				// 이동 가능하면 해당 노드 추가와 방문처리 후 이동
				if (map[x][y]>0 && visited[x][y]<=0) {
					que.add(new int[] {x,y});
					visited[x][y]++;
				}
			}
		}
	}

	
	// map기준 주변 바닷물 수 만큼 빙하 높이 감소
	private static int melt(int a, int b) {
		int water=0;
		visited[a][b]++;
		for(int i=0 ; i<4 ; i++) {
			int x = dx[i]+a;
			int y = dy[i]+b;
			if ( x<0 || y<0 || x>=n || y>=m ) continue;
			if (map[x][y]<=0 && visited[x][y]<=0) water++;
		}
		// 빙산이 0보다 작아지는 것 방지
		if (map[a][b]-water<0) return map[a][b];
		else return water;
	}


	// map 확인용 임시 출력 함수
	private static void printMap(int t) {
		sb.append("=============time:"+t+"\n");
		for (int i=0 ; i<n ; i++) {
			for (int j=0 ; j<m ; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
	}
}
