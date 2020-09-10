package boj.Problem2750;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		InsertionSortList head = new InsertionSortList(0, null);
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			head.insert(new InsertionSortList(value, null));
		}
		
		while (head.next != null) {
			head = head.next;
			bw.write(String.valueOf(head.getValue()));
			bw.newLine();
		}
		bw.flush();
	}
}
class InsertionSortList {
	private int v;
	InsertionSortList next;
	public InsertionSortList(int value, InsertionSortList next) {
		this.v = value;
		this.next = next;
	}
	public int getValue() {
		return v;
	}
	public void insert(InsertionSortList target) {
		if (next != null && target.getValue() > next.v)
			next.insert(target);
		else {
			target.next = this.next;
			this.next = target;
		}
	}
}
