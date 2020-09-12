package Problem4673;

public class Main {
	public static void main(String[] args) {
		boolean[] isNotSelfNumber = new boolean[10000];
		for (int i=0; i<10000; i++) {
			int d = d(i);
			if (d < 10000)
				isNotSelfNumber[d] = true;
		}
		for (int i=0; i<10000; i++) {
			if (!isNotSelfNumber[i])
				System.out.println(i);
		}
	}
	private static int d(int n) {
		int ret = n;
		do {
			ret += n % 10;
			n /= 10;
		} while (n > 0);
		return ret;
	}
}
