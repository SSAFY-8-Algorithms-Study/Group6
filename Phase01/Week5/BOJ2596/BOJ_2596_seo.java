package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2596_seo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] code = {"000000", "001111", "010011", "011100", 
						"100110", "101001", "110101", "111010"};
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		boolean impossible = false;
		int index = 0;
		
		String[] arr = new String[n];
		
		// 문자열 배열 입력하기
		for (int i=0; i<n; i++) {
			String s = "";
			for(int j=0; j<6; j++) {
				s+=str.charAt(6*i+j);
			}
			arr[i] = s;
		}
		//System.out.println(Arrays.toString(arr));
		
		// 해독하기
		for (int i=0; i<n; i++) {
			int max=0;
			int maxNum=-1;
			boolean find = false;
			for (int c=0; c<8; c++) {
				int cnt = 0;
				for (int j=0; j<6; j++) {
					if (code[c].charAt(j)==arr[i].charAt(j)) cnt++;
				}
				if (cnt==6) {
					find = true;
					sb.append((char)(c+65));
					break;
				}
				else if (cnt>max) {
					max=cnt;
					maxNum=c;
				}
			}
			if(find) continue;
			if (max<5) {
				impossible = true;
				index = i+1;
				break;
			}
			else sb.append((char)(maxNum+65));
		}
		
		if (impossible) System.out.println(index);
		else System.out.println(sb);
	}
}
