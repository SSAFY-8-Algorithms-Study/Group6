package Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1213_seo {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] arr = new char[str.length()];
		ArrayList<Character> couple = new ArrayList<>();
		ArrayList<Character> solo = new ArrayList<>();
		
		// 원본 배열
		for (int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		Arrays.sort(arr); // 정렬
		//System.out.println(Arrays.toString(arr));
		
		// 짝수개 있는 리스트, 홀수개 있는 리스트
		for (int i=0; i<arr.length; i++) {
			//System.out.println(i);
			if (i==arr.length-1) {
				solo.add(arr[i]);
				break;
			}
			if (arr[i]==arr[i+1]) {
				couple.add(arr[i]);
				couple.add(arr[i+1]);
				i++;
			} else {
				solo.add(arr[i]);
			}
			//System.out.println(couple.toString());
			//System.out.println(solo.toString());
		}
		//System.out.println(couple.toString());
		//System.out.println(solo.toString());
		
		// 홀수 리스트 크기가 1보다 작으면 팰린드롬 제작
		if (solo.size()<=1) {
			int idx=0;
			// 짝수개 넣기
			while(true) {
				if (couple.isEmpty()) break;
				arr[idx] = couple.get(0);
				couple.remove(0);
				arr[arr.length-1-idx] = couple.get(0);
				couple.remove(0);
				idx++;
			}
			// 홀수개 넣기
			if (solo.size()==1) arr[arr.length/2] = solo.get(0);
			// 결과
			for (int i=0; i<arr.length; i++) {
				sb.append(arr[i]);
			}
		} else sb.append("I'm Sorry Hansoo");
		
		System.out.println(sb);
	}
}
