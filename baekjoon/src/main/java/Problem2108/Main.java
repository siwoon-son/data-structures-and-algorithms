package Problem2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N];
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	numbers[i] = n;
        	sum += n;
        	if (max < n) max = n;
        	if (min > n) min = n;
        	if (!count.containsKey(n)) count.put(n, 1);
        	else count.put(n, count.get(n)+1);
        }
        
        Arrays.sort(numbers);
        
        List<Integer> modes = new ArrayList<Integer>();
        int maxFreq = 0;
        for (int k: count.keySet()) {
        	int v = count.get(k);
        	if (maxFreq < v) {
        		maxFreq = v;
        		modes = new ArrayList<Integer>();
        		modes.add(k);
        	} else if (maxFreq == v) {
        		modes.add(k);
        	}
        }
        int mode;
        if (modes.size() == 1)
        	mode = modes.get(0);
        else {
        	Collections.sort(modes);
        	mode = modes.get(1);
        }
        
        int average = Math.round((float)sum/N);
        int median = N%2==0 ? (numbers[N/2-1]+numbers[N/2])/2 : numbers[N/2];
        int range = max - min;
        
        bw.write(String.valueOf(average));
        bw.newLine();
        bw.write(String.valueOf(median));
        bw.newLine();
        bw.write(String.valueOf(mode));
        bw.newLine();
        bw.write(String.valueOf(range));
        bw.newLine();
		bw.flush();
	}
}