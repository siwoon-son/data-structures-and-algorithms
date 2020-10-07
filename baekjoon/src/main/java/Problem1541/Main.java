package Problem1541;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 잃어버린 괄호
		// 양수, +, -로 이뤄진 식에 적절히 괄호를 쳐서 가질 수 있는 최소의 결과를 계산한다.
		// 식에 -가 있을때, 이후의 모든 수를 음수로 바꾸면 최소값이 된다.
		// 예를 들어, 11 + 22 - 33 + 44 + 55 - 66 + 77의 최소값은
		// 11 + 22 - (33 + 44 + 55 ) - (66 + 77)이며, 이는
		// 11 + 22 - 33 - 44 - 55 - 66 - 77이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        // 문자열에서 연속적인 숫자를 모아 하나의 수로 만든다.
        String number = "";
        // 식의 연산 결과를 저장한다.
        int sum = 0;
        // - 문자를 만나면 true로 변환한다.
        boolean afterMinus = false;
        for (char c: input.toCharArray()) {
        	// - 또는 + 문자를 만나면,
			if (c == '-' || c == '+') {
				// 기존의 숫자를 하나의 수로 파싱하며, 기존에 -가 있었다면 음수로 치환한다.
        		sum += Integer.parseInt(number) * (afterMinus ? -1 : 1);
        		// 기존의 연속적인 숫자를 지운다.
				number = "";
				// - 문자인 경우 afterMinus를 true로 변환한다.
				if (c == '-') afterMinus = true;
			}
			// - 또는 + 문자가 아니면,
			else {
				// 입력된 숫자를 문자열에 연결한다.
				number += c;
			}
		}
        // 마지막 수를 더한다.
		sum += Integer.parseInt(number) * (afterMinus ? -1 : 1);

        bw.write(String.valueOf(sum));
		bw.flush();
	}
}
