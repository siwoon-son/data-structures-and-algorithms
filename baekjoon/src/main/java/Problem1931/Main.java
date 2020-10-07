package Problem1931;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 회의실 배정
		// N개의 회의 시작 및 끝 시간이 주어진다.
		// 회의가 겹치지 않으면서 회의실을 사용할 수 있는 회의의 최대 개수를 계산한다.
		// 겹치지 않으면서 가장 빨리 끝나는 회의의 개수가 정답이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 회의 시작 및 끝 시간을 배열에 저장한다.
		Meeting[] meetings = new Meeting[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Meeting m = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			meetings[i] = m;
		}

		// 끝 시간을 기준으로 정렬한다.
		Arrays.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.end == o2.end)
					return o1.start - o2.start;
				return o1.end - o2.end;
			}
		});

		int count = 0;
		int lastEndTime = 0;
		for (Meeting m: meetings) {
			// 회의 시간이 겹치면 무시한다.
			if (m.start < lastEndTime) continue;
			// 회의 수를 증가시킨다.
			count++;
			// 마지막 회의 시간을 저장한다.
			lastEndTime = m.end;
		}

		bw.write(String.valueOf(count));
		bw.flush();
	}

	private static class Meeting {
		int start, end;
		public Meeting (int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
