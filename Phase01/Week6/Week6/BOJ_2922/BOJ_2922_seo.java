package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2922_seo {
	
//	[C. ��ſ� �ܾ�]
//	��ſ� �ܾ�, ����� ���� �ܾ�
	
//	[ ��ſ� �ܾ� ]
//	- ������ �����ؼ� 3��, ������ �����ؼ� 3�� ������ ����
//	- �ݵ�� L�� ����
	
//	[ ����� ���� �ܾ� ������ ] 
//	1. ���� ���� ���ĺ��� ���찳�� �����
//	2. �� �ڸ��� ���� (_)�� ���´�
//	3. ���� (_) �� ��ſ� �ܾ ����� ���ĺ��� ���´�
	
//	=> ���� ���� ���ĺ��� �־�����, ��ſ� �ܾ ���� �� �ִ� ����� ��?
	
	static int size;
	static long result;
	static String str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		size = str.length();
		result = 0;
		
		dfs(0,0,0,false,1); // �ܾ��� ����
		
		System.out.println(result);

	}

	private static void dfs(int idx, int a, int b, boolean L, long cnt) { // �ڸ�, ����, ����
		
		if (idx==size) { // �ܾ �ϼ���
			if (!L) return; // L�� ������ �ʾ����� ����
			result+=cnt; // ������Ų ������ �ܾ� �� ����
			return;
		}
		
		char now = str.charAt(idx);
		if (now=='_') { // �� ���̸�
	        boolean A=true;
	        boolean B=true;
	        if(a==2) A=false; // ������ �̹� �ΰ��̸� ���� ����
	        if(b==2) B=false; // ������ �̹� �ΰ��̸� ���� ����
			// ���� ���
			if (A) {
				dfs(idx+1, a+1, 0, L, cnt*5); // ���� ��� 
			}
			// ���� ���
			if (B) {
				dfs(idx+1, 0, b+1, true, cnt); // L��� 
				dfs(idx+1, 0, b+1, L, cnt*20); // L ���� ��� ���
				// 26 - 5(����) - 1(L) = 20
			}
		}
		// �����̸�
		else if (now=='A'||now=='E'||now=='I'||now=='O'||now=='U') { 
			if (a==2) return; // ������ �̹� �ΰ��̸� �Ұ����ϴ�
			dfs(idx+1, a+1, 0, L, cnt); 
		}
		else { // �����̸�
			if (b==2) return; // ������ �̹� �ΰ��̸� �Ұ����ϴ�
			if (now=='L') dfs(idx+1, 0, b+1, true, cnt); // L ���
			else dfs(idx+1, 0, b+1, L, cnt); 
		}

	}
}