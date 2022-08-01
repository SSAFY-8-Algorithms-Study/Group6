package algo_07_4.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_2468 {
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	public static class Arr {
		private boolean check;
		private boolean visited;
		private int i;
		private int j;
		public Arr(boolean check, boolean visited, int i, int j) {
			this.check = check;
			this.visited = visited;
			this.i = i;
			this.j = j;
		}
 	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int[][] arr = new int[n][n];
		Arr[][] arr2 = new Arr[n][n];
		Stack<Arr> stack = new Stack<>();
		int max_area = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int h = 1; h <= 100; h++) {
			int area = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] >= h) {
						arr2[i][j] = new Arr(true, false, i, j);
					}
					else {
						arr2[i][j] = new Arr(false, false, i, j);
					}
				}
			}

			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr2[i][j].check == true) {
						stack.push(arr2[i][j]);
						arr2[i][j].visited = true;
						while(!stack.isEmpty()) {
							boolean check = false; // 사방이 물에 잠겨있는지 체크
							for(int k = 0; k < 4; k++) {
								// array가 범위를 벗어나는지 체크, 방문했던 노드인지 체크, 건물이 잠기지 않는 곳인지 체크
								if(stack.peek().i+dx[k]>=0 && stack.peek().i+dx[k]<n && stack.peek().j+dy[k]>=0 && 
									stack.peek().j+dy[k]<n && !arr2[stack.peek().i+dx[k]][stack.peek().j+dy[k]].visited &&
									arr2[stack.peek().i+dx[k]][stack.peek().j+dy[k]].check) {
									stack.push(arr2[stack.peek().i+dx[k]][stack.peek().j+dy[k]]);
									arr2[stack.peek().i][stack.peek().j].visited = true; // 방문 노드 체크
									check = true;
									break;
								}
							}
							if(!check) { // 사방이 물에 잠겼다면 pop
								Arr s = stack.pop();
								s.check = false;
							}
							
						}
						area++;
	
					}
				}
			}
			max_area = max_area > area ? max_area : area;
		}
		System.out.println(max_area);
	}
}
