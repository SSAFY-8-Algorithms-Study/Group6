
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	
	public static int num_ans=0;
	public static HashSet<String> set= new HashSet<>();
	public static LinkedList<String> list_ans= new LinkedList<String>();
	
	static int N,M;

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String a= br.readLine();
		
		StringTokenizer st = new StringTokenizer(a);
		
		N= Integer.parseInt( st.nextToken());
		M= Integer.parseInt( st.nextToken());
		
		
		for(int s=0;s<N;s++) {
			
			a=br.readLine();
			set.add(a);
			
			
		}
		boolean temp=false;
		
		for(int s=0;s<M;s++) {
			a=br.readLine();
			temp=set.add(a);
			
			if(temp==false) {
				
				list_ans.add(a);
				num_ans++;
				
				
			}
			
			
		}
		
		System.out.println(num_ans);
		
		
		Collections.sort(list_ans);
		
		
		for(String s : list_ans) {
			
			System.out.println(s);
		}

	}

}
