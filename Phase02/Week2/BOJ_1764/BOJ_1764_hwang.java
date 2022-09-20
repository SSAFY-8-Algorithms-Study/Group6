package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1764_hwang {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		//TreeSet이 중복제거와 정렬을 해주고 O(logN)이라길래  TreeSet사용 
		TreeSet<String> set = new TreeSet<>(); //데이터 입력
		TreeSet<String> whoset = new TreeSet<>(); //듣보잡 명단
		String value="";
		
		//start input
		for(int i=0; i<N+M; i++) { //듣도 못한 애와, 보도 못한 애 각각은 중복이 없다고 해서 아예 N+M까지 데이터 입력받음
			value = br.readLine();
			if(!set.add(value)) { //입력 데이터 중 중복되는 값이 나오면 false가 나옴. 그래서 false인 경우에만
				whoset.add(value); //듣보잡 명단에 추가해줌.
			}
			
		}//end input
		
		System.out.println(whoset.size());//듣보잡 수
		
		//듣보잡 명단 출력
		for(String str : whoset) {
			System.out.println(str);
		}
		
	}
}
