package Problem2775;

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
        int T = Integer.parseInt(st.nextToken());

        int maxK=0, maxN=0;
        int[][] cases = new int[T][2];
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
        	cases[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
        	cases[i][1] = Integer.parseInt(st.nextToken());
        	if (maxK < cases[i][0]) maxK=cases[i][0];
        	if (maxN < cases[i][1]) maxN=cases[i][0];
        }
        
        int[][] tenants =  new int[maxK+1][maxN+2];
        for (int i=0; i<T; i++) {
        	bw.write(String.valueOf(getNoTenants(cases[i][0], cases[i][1], tenants)));
        	bw.newLine();
        }
        
		bw.flush();
	}
	private static int getNoTenants (int k, int n, int[][] tenants) {
		if (k==0)	return n;
		else if (n==1) return 1;
		
		if (tenants[k][n]==0)
			tenants[k][n] = getNoTenants(k, n-1, tenants) + getNoTenants(k-1, n, tenants);
		return tenants[k][n];
	}
}