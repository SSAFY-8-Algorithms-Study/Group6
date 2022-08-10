package Study;

import java.util.Scanner;

public class BOJ_1193_seo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		boolean up = false, wait=false;
		int x=1, y=1, cnt=1;
		while (true) {
			//System.out.println(x+"/"+y+" "+cnt+" "+up+" "+wait);
			if(cnt==X) break;
			cnt++;
			
			if (x==1 && !wait) {
				y++;
				up=false;
				wait=true;
			}
			else if (y==1 && !wait) {
				x++;
				up=true;
				wait=true;
			}

			else if (up) {
				x--;
				y++;
				wait=false;
			}
			else if (!up) {
				x++;
				y--;
				wait=false;
			}
		}
		
		System.out.println(x+"/"+y);
	}
}
