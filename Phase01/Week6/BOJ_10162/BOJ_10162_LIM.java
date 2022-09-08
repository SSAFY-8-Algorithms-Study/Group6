
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		Scanner sc =new Scanner(System.in);
		
		int input=sc.nextInt();
		
		
		
		
		int a=0;
		int b=0;
		int c=0;
		
		
		if(input%10!=0) {
			
			System.out.println("-1");
			return;
		}
		
		int temp=0;
		int temp_idx=0;
		

		while(true) {
			
			if(input>=300) {
				
				input=input-300;
				c++;
				continue;
				
			}
			else if(input>=60) {
				
				input=input-60;
				b++;
				continue;
				
			}
			else if(input>=10) {
				
				input-=10;
				a++;
				continue;
			}
			
			
			
			if(input<10) {
				
				break;
			}
			
			
		}
		
		System.out.println(c+" "+b+" "+a);
		
		

	}

}
