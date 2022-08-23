package day0817;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2960_hwang {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new LinkedList<>();
		
		
		for(int i=2; i<=N; i++) {
			list.add(i);
		} //2부터 N까지 추가
		
		int cnt = 0; //횟수 세는 변수
		int num = 0; //소수 저장 변수
		int Knum = 0; //K번째로 지워진 수
		
		while(cnt < K) {
			for(int i=0; i<list.size(); i++) { //list 전체 돌아봄
				boolean check = true; //소수인지 확인
				for(int j=list.get(i)-1; j>1; j--) { //소수 판별 부분
					if(list.get(i) % j == 0) {
						check = false;
						break;
					}
				}
				if(check) { //소수인 경우에만
					num = list.get(i);
					break;
				}
			}
			
			for(int i=0; i<list.size(); i++) { 
				if(list.get(i) % num == 0) { //3번 단계 수행
					Knum = list.get(i);
					list.remove(i);
					cnt++;
				}
				if(cnt == K) break;
			}
		}
		System.out.println(Knum);
		

	}

}
