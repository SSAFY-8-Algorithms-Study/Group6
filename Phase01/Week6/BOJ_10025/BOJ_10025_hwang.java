package day0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025_hwang {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[1000000 + 1]; // 좌표가 1부터 시작해서 +1 해줌
		int maxSum = 0; // 얼음들의 합의 최댓값

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int ice = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());

			arr[idx] = ice;
			if (K >= 500000) { // 2K를 보기때문에 "arr의 마지막 인덱스 /2"가 넘어가면 얼음들 전체 합해줌.
				maxSum += ice;
			}
		} // end input


		if (maxSum == 0) {
			int sum = 0;
			//맨 처음에 배열의 index 1부터  2*K+1까지 더해줌
			for (int i = 1; i <= 2 * K+1; i++) { //if (K == 3)  1~7더해주는 걸로 첫 시작
				sum += arr[i];
			}
			
			//maxSum갱신
			maxSum = Math.max(maxSum, sum);
			
			//첫 sum이후 배열의 처음부터 끝까지 차근차근 보는데 항상 2*K만큼의 값이 저장되어있는 형태로 이동한다.
			for (int i = 1; i < 1000000 - 2 * K; i++) { 
				//여기서 2*K를 빼주는 이유는 ice는 음수가 없어서 2*K가 무조건 최대값이기 때문에 2*K를 뺀 이후의 인덱스는 볼 필요가 없음.
				sum -= arr[i]; //제일 앞에 있는 부분은 빼주고
				sum += arr[i + (2 * K + 1)]; //제일 뒤에 있는 인덱스 +1에 저장된 값을 저장해줌.
				//maxSum갱신
				maxSum = Math.max(maxSum, sum);

			}
		}

		System.out.println(maxSum);
	}

}
