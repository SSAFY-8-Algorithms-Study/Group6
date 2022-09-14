
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


class door{
	
	int num;
	String type;
	int gold=0;
	ArrayList doorlist= new ArrayList<>();
	
	
	public door(String a) {
		
		this.type=a;
	}
	
	// add?
	
	
	
	
	
}








public class Main {
	
	public static int user_gold=0;
	static int flag=0;
	public static int input_first=-1;
	public static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		
		
		
		while(true) {
			flag=0;
			String a=br.readLine();
			StringTokenizer st = new StringTokenizer(a);
			input_first= Integer.parseInt(st.nextToken());
			//System.out.println("first_input= "+input_first);
			
			if(input_first==0) {
				break;
			}
			int N= input_first;// door count
			
			ArrayList<door> d_list= new ArrayList<>();
			
			
			for(int s=0;s<N;s++) {
				
				
				a=br.readLine();
				st= new StringTokenizer(a);
				
				door temp_door= new door(st.nextToken());
				
				
				temp_door.gold=Integer.parseInt(st.nextToken());
				temp_door.num=s+1;
				
				int temp=-1;
				while(temp!=0) {
					temp=Integer.parseInt(st.nextToken());
					if(temp==0) {
						break;
					}
					temp_door.doorlist.add(temp);
					
				}
				d_list.add(temp_door);
				
				
			}
			
			
			
			bfs(d_list, N);
			// 문제의 골드조건 구현필요 
			//
			
			if(flag==1) {
				
				sb.append("Yes\n");
			}
			else {
				
				sb.append("No\n");
			}
			
			
			
		}// while end
		
		System.out.println(sb);

	}//main end

	private static void bfs(ArrayList<door> d_list,int N) {
		
		LinkedList<door> queue= new LinkedList<>();
		
		queue.offer(d_list.get(0));
		int depth=1;
		
		
		
		
		
		int visit[] = new int[N+1];
		
		
		
		while(!queue.isEmpty()) {
			
			
			
			int sz=queue.size();
			
			for(int s=0;s<sz;s++) {
				
			door cur_door= queue.poll();
			
			if(cur_door.type.matches("L")) {
				//System.out.println("EE");
				if(user_gold<cur_door.gold) {
					user_gold=cur_door.gold;
					
				}
			}
			else if(cur_door.type.matches("T")) {
				
				if(user_gold-cur_door.gold>=0) {
					user_gold-=cur_door.gold;
				}
				else {
					visit[cur_door.num]=-1;
					continue;
				}
				
			}
			
			//System.out.println(cur_door.num+"@@ G= "+user_gold);
			
			if(cur_door.num==N) {
				flag=1;
			}
			
			if(visit[cur_door.num]!=0) {
				continue;
			}
			
			
			
			visit[cur_door.num]=1;
			
			
			
			// 현재거에서 doorlist에서 멤버 꺼내서 큐에 집어넣는다.
				
			
			for(int z=0;z<cur_door.doorlist.size();z++) {
				
				queue.add((door)d_list.get((int)cur_door.doorlist.get(z)-1));
				
				
			}
				
				
			
				
			
			
			
			
			
			
			
			
			}
			depth++;
			
			
			
			
			
		}
		
		
	}

}
