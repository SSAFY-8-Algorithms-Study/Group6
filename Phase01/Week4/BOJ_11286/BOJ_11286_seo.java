package Study08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_seo {
	
	// 우선순위 큐는 낮은 숫자 순으로 우선순위를 결정한다
	// 우선순위를 재정의해서 풀기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		// 우선순위큐 절댓값 기준으로 정렬
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1)>Math.abs(o2)) return 1; // 절댓값을 비교해 정렬
				else if (Math.abs(o1)==Math.abs(o2)) return o1-o2; // 절댓값 같으면 작은값(음수)를 먼저
				else return -1;
			}
		});
		
		// 명령어 실행
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num==0) {
				if(que.isEmpty()) sb.append(0+"\n");
				else sb.append(que.poll()+"\n");
			}
			else que.add(num);
		}
		
		System.out.println(sb);
	}
	
}
