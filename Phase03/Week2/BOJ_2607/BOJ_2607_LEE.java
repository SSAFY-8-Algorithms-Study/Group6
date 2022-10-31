package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String first_word = br.readLine();

		int ans = 0;
		for(int i=0; i<N-1; i++) {
			boolean[] equal = new boolean[first_word.length()];
			String s = br.readLine();
			if(Math.abs(s.length()-first_word.length())>1)
				continue;
			for(int j=0; j<s.length(); j++) {
				for(int k=0; k<first_word.length(); k++) {
					if(s.charAt(j)==first_word.charAt(k) && !equal[k]) {
						equal[k] = true;
						break;
					}
				}
			}
			
			int not_equal = 0;
			for(int j=0; j<first_word.length(); j++) {
				if(!equal[j])
					not_equal++;
			}
			
			if(first_word.length() >= s.length() && not_equal<=1 || first_word.length() < s.length() && not_equal==0)
				ans++;
			
			
		}
		
		System.out.println(ans);
	}
}
