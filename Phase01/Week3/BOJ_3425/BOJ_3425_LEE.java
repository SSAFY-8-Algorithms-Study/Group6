package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3425 {
	static final int max_value = 1000000000;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		// 문제 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		loop:
		while(true) {
			String s;
			ArrayList<String> program = new ArrayList<>(); // program 명령어를 저장하는 리스트
			ArrayList<Integer> program_num = new ArrayList<>(); // NUM X를 실행 할때 X를 저장하는 리스트 
			while(!(s=br.readLine().trim()).equals("END")) {
				if(s.equals("QUIT")) {
					break loop;
				}
				StringTokenizer st = new StringTokenizer(s);
				String s2;
				if((s2 = st.nextToken()).equals("NUM")) {
					program.add(s2);
					program_num.add(Integer.parseInt(st.nextToken()));
				}
				program.add(s);
			}
			int n = Integer.parseInt(br.readLine());
			int[] num_arr = new int[n];
			for(int i=0; i<n; i++) {
				num_arr[i] = Integer.parseInt(br.readLine());
			}
			br.readLine();
			//문제 입력 끝
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				stack = new Stack<>(); // 프로그램 실행할 스택 생성
				stack.add(num_arr[i]);
				int cnt = 0;
				boolean error = false;
				for(int j=0; j<program.size(); j++) {
					// X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 10^9)
					if(program.get(j).equals("NUM")) { 
						stack.add(program_num.get(cnt++));
					}
					// 스택 가장 위의 숫자를 제거한다.
					else if(program.get(j).equals("POP")) {
						if(stack.isEmpty()) {
							error = true;
							break;
						}
						stack.pop();
					}
					// 첫 번째 수의 부호를 바꾼다. (42 -> -42)
					else if(program.get(j).equals("INV")) {
						if(stack.isEmpty()) {
							error = true;
							break;
						}
						int x = stack.pop();
						x = -x;
						stack.add(x);
					}
					// 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
					else if(program.get(j).equals("DUP")) {
						if(stack.isEmpty()) {
							error = true;
							break;
						}
						stack.add(stack.peek());
					}
					// 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
					else if(program.get(j).equals("SWP")) {
						if(stack.size()<2) {
							error = true;
							break;
						}
						int x = stack.pop();
						int y = stack.pop();
						stack.add(x);
						stack.add(y);
					}
					// 첫 번째 숫자와 두 번째 숫자를 더한다.
					else if(program.get(j).equals("ADD")) {
						if(stack.size()<2) {
							error = true;
							break;
						}
						int x = stack.pop();
						int y = stack.pop();
						if(Math.abs((long)x + (long)y) > max_value) {
							error = true;
							break;
						}
						stack.add(x+y);						
					}
					// 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
					else if(program.get(j).equals("SUB")) {
						if(stack.size()<2) {
							error = true;
							break;
						}
						int x = stack.pop();
						int y = stack.pop();
						if(Math.abs((long)y - (long)x) > max_value) {
							error = true;
							break;
						}
						stack.add(y-x);
					}
					// 첫 번째 숫자와 두 번째 숫자를 곱한다.
					else if(program.get(j).equals("MUL")) {
						if(stack.size()<2) {
							error = true;
							break;
						}
						int x = stack.pop();
						int y = stack.pop();
						// long * long도 통과가 되긴 했다... test case에 없었나..?
						if(new BigDecimal(x).multiply(new BigDecimal(y).abs()).compareTo(new BigDecimal(max_value)) == 1) {
							error = true;
							break;
						}
						stack.add(x*y);
					}
					// 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
					else if(program.get(j).equals("DIV")) {
						if(stack.size()<2) {
							error = true;
							break;
						}
						int x = stack.pop();
						int y = stack.pop();
						if(x==0) {
							error = true;
							break;
						}
						stack.add(y/x);
					}
					// 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
					else if(program.get(j).equals("MOD")) {
						if(stack.size()<2) {
							error = true;
							break;
						}
						int x = stack.pop();
						int y = stack.pop();
						if(x==0) {
							error = true;
							break;
						}
						stack.add(y%x);
					}
				}
				if(error)
					sb.append("ERROR\n");
				else if(stack.size() != 1) 
					sb.append("ERROR\n");
				else
					sb.append(stack.peek()+"\n");
				
			}
			System.out.println(sb);
		}
		
	}
}
