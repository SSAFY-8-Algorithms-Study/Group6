package study_group_06.week03;

import java.io.*;
import java.util.*;

public class Problem_3425 {
	static boolean errorFlag = false;
	static String[] COMMAND_SET = { "NUM", "POP", "INV", "DUP", "SWP", "ADD", "SUB", "MUL", "DIV", "MOD" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 명령어 저장할 command queue
		Queue<String> cmdInput = new LinkedList<>();
		// 숫자를 저장할 number stack
		Stack<Long> nums = new Stack<>();

		String input = null;

		while (true) {

			// 명령어 영역

			cmdInput.clear(); // 클리어해서 명령 큐 안의 이전 명령을 모두 제거
			while (true) {
				input = br.readLine();

				if (input.equals("QUIT")) { // QUIT가 들어오면 프로그램 종료
					br.close();
					return;
				}

				cmdInput.add(input);

				if (input.equals("END")) // END가 들어오면 명령을 받아들이는 것을 중단
					break;
			}

			// 입력 영역
			// 프로그램 수행횟수
			int N = Integer.parseInt(br.readLine());

			for (int n = 0; n < N; n++) {
				nums.clear(); // 클리어해서 스택 안의 이전 숫자를 모두 제거

				input = br.readLine();

				nums.add(Long.parseLong(input));

				calc(cmdInput, nums);
			}

			br.readLine(); // 공백 제거

			System.out.println(); // 각 기계에 대한 출력값은 빈 줄 하나 간격을 띄워서 출력
		}
	}

	static void calc(Queue<String> Q, Stack<Long> S) {
		String cmd;
		long tmp, n1, n2; // 곱 연산의 경우 int의 최대 범위를 넘어 갈 수 있음

		errorFlag = false; // 에러 플래그를 초기화

		while (true) {
			cmd = Q.poll();
			tmp = n1 = n2 = 0;
			Q.add(cmd);

			try {
				if (cmd.contains("NUM")) {
					tmp = Long.parseLong(cmd.split(" ")[1]);
					S.add(tmp); // split("NUM X") <- [0]:NUM, [1]:X(number);
				} else if (cmd.contains("POP")) {
					S.pop();
				} else if (cmd.contains("INV")) {
					n1 = S.pop() * -1;
					S.add(n1);
				} else if (cmd.contains("DUP")) {
					n1 = S.pop();
					S.add(n1);
					S.add(n1);
				} else if (cmd.contains("SWP")) {
					n2 = S.pop();
					n1 = S.pop();
					S.add(n2);
					S.add(n1);
				} else if (cmd.contains("ADD")) {
					n1 = S.pop();
					n2 = S.pop();
					S.add(n1 + n2);
				} else if (cmd.contains("SUB")) {
					n1 = S.pop();
					n2 = S.pop();
					S.add(n2 - n1);
				} else if (cmd.contains("MUL")) {
					n1 = S.pop();
					n2 = S.pop();
					S.add(n1 * n2);
				} else if (cmd.contains("DIV")) {
					n1 = S.pop();
					n2 = S.pop();
					tmp = Math.abs(n2) / Math.abs(n1);
					if (n1 < 0 ^ n2 < 0)
						tmp *= -1;
					S.add(tmp);
				} else if (cmd.contains("MOD")) {
					n1 = S.pop();
					n2 = S.pop();
					tmp = Math.abs(n2) % Math.abs(n1);
					if (n2 < 0)
						tmp *= -1;
					S.add(tmp);
				}
				
				// if (Math.abs(S.peek()) > 1_000_000_000)
				// 스택이 비었을 경우에 오류 체크를 시도해서 틀리는 문제가 있었음
				if (!S.isEmpty() && Math.abs(S.peek()) > 1_000_000_000)
					throw new ArithmeticException("bigger than 1000000000");

			} catch (ArithmeticException | EmptyStackException e) {
//				e.printStackTrace();
				errorFlag = true;
			}

			if (cmd.equals("END"))
				break;
		}

		if (S.size() != 1 || errorFlag) {
			System.out.println("ERROR");
		} else {
			System.out.println(S.pop());
		}
	}
}
