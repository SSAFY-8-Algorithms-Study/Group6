
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n= sc.nextInt();
		
		int DP[][]= new int[1001][2];// [돌 개수][현재 턴] 0 상근 1 창영
		
		DP[1][0]=3;//상근 승
		DP[1][1]=4;
		
		DP[3][0]=3;
		DP[3][1]=4;
		int win=0;
		
		int num=n;
		int turn=0;
		
		while(num>0) {
			
			if(DP[num][turn]!=0) {
				
				win=DP[num][turn];
				break;
			}
			else if(DP[num][turn]!=0) {
				
				win=DP[num][turn];
				break;
			}
			
			
			num--;
			if(turn==0) {
				turn=1;
			}
			else {
				turn=0;
			}
			
		}
		
		
		if(win==3) {
			System.out.println("SK");
			
		}
		else {
			System.out.println("CY");
		}
				
				
				
				

	}
	
	
	
	
	
	

}
