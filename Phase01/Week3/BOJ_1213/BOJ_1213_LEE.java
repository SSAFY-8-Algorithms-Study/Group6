package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// 받은 문자열 character로 분리해서 int로 바꿔서 배열 26개 생성해서 풀면 map 안써도 됨!
public class BOJ_1213 {
	public static void main(String[] args) throws IOException {
		// 문제 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		char[] arr = new char[s.length()];
		int len = s.length();
		boolean[] used = new boolean[len];
		for(int i=0; i<len; i++) {
			arr[i] = s.charAt(i);
		}
		// 문제 입력 끝
		
		// map으로 문자열 받아서 갯수 세서 저장(ex) A=1, B=2, C=1) 사전 순 정렬을 위해 treemap 사용
		Map<Character, Integer> map = new TreeMap<>();
		for(int i=0; i<len; i++) {
			if(used[i]) continue;
			used[i] = true;
			int cnt = 1;
			map.put(arr[i], cnt);
			for(int j=i+1; j<len; j++) {
				if(arr[i]==arr[j]) {
					used[j] = true;
					cnt++;
					map.put(arr[i], cnt);
				}
			}
		}
		
		int cnt = 0;
		char c = 0;
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(cnt>1) break; // 글자 갯수가 홀수인것이 1개보다 많으면 정지하고 I'm sorry Hansoo 출력
			if(entry.getValue()%2==1) { // 글자 갯수 홀수이면 한 글자는 맨 가운데에 출력해줄 것임
				cnt++;
				c = entry.getKey();
				for(int i=0; i<(entry.getValue()-1)/2; i++) { // 나머지 글자는 순서대로 갯수의 반개씩 출력
					sb.append(entry.getKey());
				}
			}
			else {
				for(int i=0; i<entry.getValue()/2; i++) {
					sb.append(entry.getKey());
				}
			}
		}
		
		String sb2 = sb.reverse().toString();
		sb.reverse();
		if(cnt > 1) System.out.println("I'm Sorry Hansoo");
		else if(cnt == 1) {
			sb.append(c);
			sb.append(sb2);
			System.out.println(sb);
		}
		else {
			sb.append(sb2);
			System.out.println(sb);
		}
		
		
	}
}
