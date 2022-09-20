package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764_seo {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> list1 = new HashSet<String>();
		for ( int i=0 ; i<n ; i++ ) {
			list1.add(br.readLine());
		}
		
		ArrayList<String> list2 = new ArrayList<String>();
		for ( int j=0; j<m ; j++ ) {
			String str = br.readLine();
			if( list1.contains(str) ) {
				list2.add(str);
			}
		}
		
		Collections.sort(list2);
		
		
		for ( int i=0 ; i<list2.size() ; i++ ) {
			sb.append(list2.get(i)+'\n');
		}
		
		System.out.println(list2.size()+""+'\n'+""+sb);
	}
}