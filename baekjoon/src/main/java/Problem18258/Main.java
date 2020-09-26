package Problem18258;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// 큐를 구현한다.
		// 이 풀이에서는 element의 개수에 따라 확장하는 배열을 사용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		MyQueue queue = new MyQueue(128);

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch (op) {
				case "push":
					int v = Integer.parseInt(st.nextToken());
					queue.push(v);
					break;
				case "pop":
					sb.append(queue.pop()).append("\n");
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					sb.append(queue.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					sb.append(queue.front()).append("\n");
					break;
				case "back":
					sb.append(queue.back()).append("\n");
					break;
			}
		}

        bw.write(sb.toString());
		bw.flush();
	}

	static class MyQueue {
		private int front = -1, back = -1;
		private int[] q;

		public MyQueue (int initialSize) {
			q = new int[initialSize];
		}

		public void push (int v) {
			// 값 v 큐에 추가
			if (isFull())
				expand();

			q[++back] = v;
		}

		private void expand() {
			// 큐의 크기를 2배로 확장
			int[] expanded = new int[q.length * 2];
			for (int i=0, j=front; j < back; i++, j++) {
				expanded[i] = q[j+1];
			}

			q = expanded;
			back = back - (front + 1);
			front = -1;
		}

		public int pop () {
			// 큐에서 가장 앞에 있는 정수를 빼서 출력
			if (isEmpty()) return -1;
			int v = q[++front];
			if (isEmpty()) {
				front = back = -1;
			}
			return v;
		}

		public int size () {
			// 큐에 있는 값의 개수를 출력
			return back - front;
		}

		public boolean isEmpty () {
			// 큐가 비어있는지 확인
			return front == back;
		}

		public boolean isFull () {
			// 큐가 꽉차있는지 확인
			return back + 1 == q.length;
		}

		public int front () {
			// 큐의 가장 앞에 있는 정수를 출력
			if (isEmpty()) return -1;
			return q[front+1];
		}

		public int back () {
			// 큐의 가장 뒤에 있는 정수를 출력
			if (isEmpty()) return -1;
			return q[back];
		}
 	}
}
