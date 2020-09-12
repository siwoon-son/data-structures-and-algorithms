package Problem10814;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        // input data
		Person[] people = new Person[T];
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people[i] = new Person(age, name);
		}

		// sort
		Arrays.sort(people);

		// print
		for (Person p: people)
			bw.write(String.valueOf(p.age + " " + p.name + "\n"));
		bw.flush();
	}
}

class Person implements Comparable<Person> {
	private static int nOfPerson = 0;
	int idx;
	int age;
	String name;
	public Person (int age, String name) {
		this.age = age; this.name = name;
		this.idx = ++nOfPerson;
	}

	@Override
	public int compareTo(Person o) {
		if (age > o.age) return 1;
		if (age < o.age) return -1;
		return Integer.compare(idx, o.idx);
	}
}