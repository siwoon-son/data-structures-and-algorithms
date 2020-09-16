package Problem4948;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 자연수 n보다 크고 2n보다 작거나 같은 소수의 개수를 계산한다.
		// 에라토스테네스의 체(1929번 문제)를 활용하여,
		// 입력 중 가장 큰 수의 두 배까지 소수를 전부 판별하고,
		// 각 입력부터 입력의 두 배 사이의 소수 개수를 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력을 받고, 가장 큰 값을 찾는다.
        List<Integer> input = new ArrayList<>();
        int max = 0;
        String line;
        while (!(line=br.readLine()).equals("0")) {
			int n = Integer.parseInt(line);
        	input.add(n);
        	max = Math.max(max, n);
		}

        // 에라토스테네스의 체를 이용하여 max*2까지의 소수를 모두 찾는다.
		boolean[] notPrimes = new boolean[max*2+1];
		notPrimes[0] = notPrimes[1] = true;

		for (int i=2; i*i<=max*2; i++) {
			if (notPrimes[i]) continue;
			for (int j=i*i; j<=max*2; j+=i) {
				notPrimes[j] = true;
			}
		}

		// 입력들의 두 배까지 소수 개수를 출력한다.
		StringBuilder sb = new StringBuilder();
		for (int number: input) {
			int count = 0;
			for (int i = number+1; i <= number*2; i++) {
				if (notPrimes[i]) continue;
				count ++;
			}
			sb.append(count).append("\n");
		}

        bw.write(sb.toString());
		bw.flush();
	}
}
