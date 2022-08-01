package algo_07_4.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_2573 {
	public static class Arr {
		private boolean visited;
		private int i;
		private int j;
		public Arr(boolean visited, int i, int j) {
			this.visited = visited;
			this.i = i;
			this.j = j;
		}
 	}
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		int[][] arr3 = new int[n][m];
		Arr[][] arr2 = new Arr[n][m];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		int year = 0; // 몇년이 지났는지에 대한 변수
		while(true) {
			boolean check = false; // 빙하가 모두 녹았는가?
			year++;

			for(int i=1; i<n-1; i++) {
				for(int j=1; j<m-1; j++) {
					if(arr[i][j] > 0) {
						check = true;
						int cnt = 0;
						for(int k=0; k<4; k++) {
							if(arr[i+dx[k]][j+dy[k]] == 0) {
								cnt++;
							}
						}
						arr3[i][j] = arr[i][j] - cnt > 0 ? arr[i][j] - cnt : 0; // 0 미만이면 0으로 계산
					}

				}
			}
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<m-1; j++) {
					arr[i][j] = arr3[i][j]; // arr에 1년 후 빙산 모양 저장
					arr2[i][j] = new Arr(false, i, j);  // arr2 초기화
				}
			}

			if(!check) { // 빙하가 둘로 나누어지기 전에 모두 녹았다면 반복문을 빠져나가고 0을 출력한다.
				year = 0; 
				break;
			}
			
			int iceberg = 0; // 빙산의 갯수
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<m-1; j++) {
					if(arr[i][j]>0) {
						iceberg++;
					}
				}
			}
			
			int connected_iceberg = 0; // 이어져있는 빙산의 갯수
			Stack<Arr> stack = new Stack<>();
			loopOut:
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<m-1; j++) {
					if(arr[i][j]>0) {
						stack.push(arr2[i][j]);
						connected_iceberg++;
						arr2[i][j].visited = true;
						while(!stack.isEmpty()) {
							boolean check2 = false; // 사방이 바다인지 확인
							for(int k=0; k<4; k++) {
								if(arr[stack.peek().i+dx[k]][stack.peek().j+dy[k]] > 0 && !arr2[stack.peek().i+dx[k]][stack.peek().j+dy[k]].visited) {
									check2 = true;
									stack.push(arr2[stack.peek().i+dx[k]][stack.peek().j+dy[k]]);
									connected_iceberg++;
									stack.peek().visited = true;
									break;
								}
							}
							if(!check2) { // 사방이 바다이거나 방문한 빙산이면 pop
								stack.pop();
							}
						}
						break loopOut;
					}
				}
			}
			if(iceberg != connected_iceberg) { // 분리되었다면 break
				break;
			}
		}
		System.out.println(year);

	}
}
