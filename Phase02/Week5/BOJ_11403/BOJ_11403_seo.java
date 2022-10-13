package Week5.BOJ_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_seo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �÷��̵� �ͼ�
		// ��� �������� �ٸ� ��� ������ ��ȸ�ϸ鼭 ����Ǿ� �ִ� �� ������ 1�� ǥ��
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				for (int c=0; c<N; c++) {
					if (arr[b][a] == 1 && arr[a][c]==1) { // �� �� �ִ� ��ΰ� �����ϴ°�
						arr[b][c] = 1;
					}
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
