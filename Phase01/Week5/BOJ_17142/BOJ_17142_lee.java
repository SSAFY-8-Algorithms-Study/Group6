package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142 {
	static class Virus {
		int x, y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, empty_space, min = Integer.MAX_VALUE;
	static int[][] lab, origin_lab;
	static ArrayList<Virus> virus;
	static Queue<Virus> active_virus;
	static Virus[] init_active_virus;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 연구소 크기 n x n
		m = Integer.parseInt(st.nextToken()); // 바이러스 갯수
		empty_space = 0; // 빈 칸 갯수
		origin_lab = new int[n][n]; // 연구소 초기화시키는 데 사용될 origin배열 초기화
		lab = new int[n][n]; // 연구소 배열 초기화
		virus = new ArrayList<>(); // 바이러스 좌표 배열 초기화
		active_virus = new LinkedList<>(); // 활성화된 바이러스가 들어갈 Queue 초기화
		init_active_virus = new Virus[m]; // 조합으로 시작하는 바이러스를 m개만큼 담아주는 배열 초기화
		for (int i = 0; i < n; i++) { // 연구소 지도 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				origin_lab[i][j] = Integer.parseInt(st.nextToken());
				if (origin_lab[i][j] == 2)
					virus.add(new Virus(i, j)); // 바이러스는 바이러스 목록에 추가
				if (origin_lab[i][j] == 0)
					empty_space++; // 빈공간 갯수 세기
			}
		}
		init_lab();
		comb(0, 0);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void comb(int idx, int cnt) {
		if (cnt == m) { // 함수 리턴 조건, 배열이 모두 채워졌을 때
			active_virus.clear(); // 활성화된 바이러스 큐 초기화
			visited = new boolean[n][n]; // bfs를 돌릴 때마다 visited체크 배열 초기화
			// init_lab(); // 연구실 배열 원래 상태로 초기화
			min = Math.min(min, bfs()); // 최소값 찾기
			// print();
			return; 
		}
		// 시작 활성 바이러스 배열 조합 찾기
		for (int i = idx; i < virus.size(); i++) {
			init_active_virus[cnt] = virus.get(i);
			comb(i + 1, cnt + 1);
		}
	}

	// 연구소 배열 origin으로 초기화
	static void init_lab() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				lab[i][j] = origin_lab[i][j];
			}
		}
	}

	// 연구소를 바이러스로 오염시키기 위한 bfs
	static int bfs() {
		for (int i = 0; i < m; i++) { // 시작 활성화 바이러스
			active_virus.add(init_active_virus[i]);
			int x = init_active_virus[i].x;
			int y = init_active_virus[i].y;
			visited[x][y] = true; // 바이러스 시작 지점 visited체크
			// lab[x][y] = 3;
		}

		int cnt = 0;
		int empty = empty_space; // 빈 공간 갯수
		while (!active_virus.isEmpty()) { // 더 이상 활성화된 바이러스가 없을 때까지 반복
			if (empty == 0) {
				return cnt; // 빈 공간이 없으면 cnt 리턴
			}
			int size = active_virus.size();
			for (int i = 0; i < size; i++) {
				Virus v = active_virus.poll();
				for (int j = 0; j < 4; j++) {
					int nx = v.x + dx[j];
					int ny = v.y + dy[j];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue; // 배열범위 벗어나면 continue
					if (visited[nx][ny])
						continue; // 이미 방문했으면 continue
					if (lab[nx][ny] == 1)
						continue; // 벽이면 continue
					active_virus.add(new Virus(nx, ny)); // 큐에 삽입
					visited[nx][ny] = true; // 큐에 들어간 노드 제크
					if (lab[nx][ny] == 0)
						empty--; // 빈 공간에 바이러스가 퍼졌을 때만 빈 공간 1개 감소
					// lab[nx][ny] = 9;
				}
			}
			cnt++;
		}
		return Integer.MAX_VALUE; // 모든 빈 칸에 바이러스를 퍼뜨릴 수 없다면
	}

	// lab print
	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(lab[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
