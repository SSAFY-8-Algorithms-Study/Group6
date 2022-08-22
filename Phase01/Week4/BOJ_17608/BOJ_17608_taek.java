package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17608 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<n; i++) {
			int j = Integer.parseInt(br.readLine());
			if(s.isEmpty()) 
				s.push(j);
			else {
				while(!s.isEmpty() && s.peek()<=j) {
					s.pop();
				}
				s.push(j);
			}

	
		}
		System.out.println(s.size());
	}
}
