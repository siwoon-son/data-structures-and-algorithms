package Problem7568;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static class Person {
		int w, h;
		int ranking = 1;
		Person (int w, int h) {
			this.w = w; this.h = h;
		}
	}
	public static void main(String[] args) throws IOException {
		// 키와 몸무게가 모두 크면 덩치가 크다고 할 때, 주어진 사람들의 순위를 출력한다.
		// 키 또는 몸무게가 하나만 크면 같은 순위이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Person[] people = new Person[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			people[i] = new Person(x, y);
		}

		// 두 사람씩 묶어 모든 가능한 조합을 비교하며, 키와 몸무게가 작으면 순위를 증가시킨다.
		for (int i=0; i<N-1; i++) {
			for (int j=i+1; j<N; j++) {
				if (people[i].w > people[j].w && people[i].h > people[j].h)
					people[j].ranking++;
				else if (people[i].w < people[j].w && people[i].h < people[j].h)
					people[i].ranking++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Person p: people) {
			sb.append(p.ranking).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
