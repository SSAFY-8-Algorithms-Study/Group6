import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class points {
	public int x;
	public int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public points(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class line {

	public points before;
	public points after;
	public int state;// 0= 가로 1= 세로

	public points getBefore() {
		return before;
	}

	public void setBefore(points before) {
		this.before = before;
	}

	public points getAfter() {
		return after;
	}

	public void setAfter(points after) {
		this.after = after;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public line(points before, points after, int state) {
		this.before = before;
		this.after = after;
		this.state = state;
	}

	public int get_length() {
		int res = 0;

		if (state == 0) {// x차이
			res = Math.abs(this.before.x - this.after.x);

		} else if (state == 1) {

			res = Math.abs(this.before.y - this.after.y);

		}

		return res;

	}

}

public class Main {

	static int N;
	static int ans;

	static line heights[];// 세로
	static line widths[];// 가로
	static points pp[];
	static line holedlines[];
	static int[] surface = new int[40001];

	static points visit[];
	static Queue<line> pq = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		StringTokenizer st;

		N = Integer.parseInt(a);

		pp = new points[N];

		for (int s = 0; s < N; s++) {
			a = br.readLine();
			st = new StringTokenizer(a);
			pp[s] = new points(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		}
		int temp = 0;

		widths = new line[N / 2 - 1];
		heights = new line[N / 2];

		int temp_w = 0;
		int temp_h = 0;

		while (temp != N - 1) {

			if (temp % 2 == 0) {
				heights[temp_h] = new line(pp[temp], pp[temp + 1], 1);
				temp_h++;
			} // 짝- 세로
			else {
				widths[temp_w] = new line(pp[temp], pp[temp + 1], 0);
				temp_w++;
			} // 홀 -가로
			temp++;

		}

		int holedNum = Integer.parseInt(br.readLine());

		holedlines = new line[holedNum];

		for (int s = 0; s < holedNum; s++) {
			a = br.readLine();
			st = new StringTokenizer(a);

			holedlines[s] = new line(new points(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
					new points(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), -1);

			if (holedlines[s].before.x == holedlines[s].after.x) {

				holedlines[s].state = 0;

			} else {

				holedlines[s].state = 1;

			}

		}

		for (int s = 0; s < holedlines.length; s++) {

			pq.add(holedlines[s]);

		}

		// pq에 깊이가 깊은 순으로 저장되어있으므로 visit배열에 방문처리를 하며 체크하면서 깊이를 구하면 될 것같다.

		for (int s = 0; s < N / 2 - 1; s++) {

			surface[s] = 40000002;

		}

		while (!pq.isEmpty()) {

			line cur = pq.poll();

			int temp_idx = 0;// search idx of widths &input

			// System.out.println("polled line is= " +cur.before.x+" "+cur.before.y);

			for (line mbss : widths) {

				if (mbss.before.x == cur.before.x && mbss.before.y == cur.before.y && mbss.after.x == cur.after.x
						&& mbss.after.y == cur.after.y) {

					break;
				}

				temp_idx++;// 입력값의 가로 집합에서 순서위치

			}

			operate(temp_idx);
			for (int s = 0; s < (N / 2) - 1; s++) {
				// sum += surface[s];
				// System.out.println(surface[s]);

			}
			// System.out.println("end");

		}

		int sum = 0;

		for (int s = 0; s < (N / 2) - 1; s++) {
			sum += surface[s];
			// System.out.println(surface[s]);

		}

		System.out.println(sum);

		// 필요사항.
		// 1 지정받은 가로구멍의 인덱스 V
		// 인덱스를 찾아서 왼쪽 오른쪽으로 갱신하면서 물의 높이를 surface(열마다의 표면높이를 뜻한다? )에 갱신한다.
		// 왼쪽 또는 오른쪽으로 진행시 현재 구멍에서 받은 y좌표를 높이로 지정 후 다음 가로축의 길이가 현재 높이(y좌표)보다 낮으면 유지하며
		// (현재 높이-낮은 높이의)값을 기록한다.
		// 현재 높이 보다 높으면 그 높이로 현재높이값을 갱신하고 surface값에는 0또는 -1의 고유값을 기록한다.

		// 과목평가 서술형 DP 월말평가 컴띵이 서술형 섞여서ㅓ?

	}

	private static void operate(int temp_idx) {

		int save = temp_idx;// 입력값의 순서위치 인덱스

		surface[save] = 0;

		save--;

		int saved_heights = widths[temp_idx].before.y;

		while (save != -1) {

			if (surface[save] == 0) {

				if (saved_heights > widths[save].before.y) {
					saved_heights = widths[save].before.y;
				}

			} else if (widths[save].before.y < saved_heights) {

				surface[save] = 0;
				saved_heights = widths[save].before.y;

			}

			else if (surface[save] != 0
					&& surface[save] <= Math.abs(saved_heights - widths[save].before.y) * widths[save].get_length()) {
				save--;
				continue;
			}

			else if (widths[save].before.y >= saved_heights) {

				surface[save] = Math.abs(saved_heights - widths[save].before.y) * widths[save].get_length();

			}

			save--;
		} // left direction

		save = temp_idx;

		saved_heights = widths[save].before.y;
		save++;

		while (!(save >= N / 2 - 1)) {

			if (surface[save] == 0) {

				if (saved_heights > widths[save].before.y) {
					saved_heights = widths[save].before.y;
				}

			} else if (widths[save].before.y < saved_heights) {

				surface[save] = 0;
				saved_heights = widths[save].before.y;

			}

			else if (surface[save] != 0
					&& surface[save] <= Math.abs(saved_heights - widths[save].before.y) * widths[save].get_length()) {

				save++;
				continue;
			}

			else if (widths[save].before.y >= saved_heights) {

				surface[save] = Math.abs(saved_heights - widths[save].before.y) * widths[save].get_length();

			}

			save++;

		}

	}// oper end

}
