package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372_seo {
	
	// ���ؾ� �ϴ� ������ ����⸦ Ÿ�� �ּ� Ƚ���� �ִ� �Ÿ����ٸ�? bfs. MST��..
	// ������� ������? (������ ��)-1
	// ��� N���� ������ ��峢�� ��� ����Ǳ� ���� �ּ� N-1���� ������ �ʿ��ϴ�!
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for (int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine()); 
			}
			sb.append((N-1)+"\n");
		}
		System.out.println(sb);
	}

}
