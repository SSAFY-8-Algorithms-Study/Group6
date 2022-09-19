
import java.util.Scanner;

public class Main {

		static int ans=0;
	public static void main(String[] args) {
	
		
		Scanner sc= new Scanner(System.in);
		
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		int choice= Math.max(x,y);
		
		ans+=choice;
		
		int sec= Math.min(x, y);
		
		ans+=sec;
		
		
		
		int temp1=0;
		
		
		

			
			sec=sec/10;
			ans+=sec;
			
			
			
		
		
		
		System.out.println(ans);
		
		
		

	}

}
