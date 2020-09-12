package algorithms.medium.BearAndSteadyGene;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NotSolution {

    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
        // 시간 초과
        char[] chars = gene.toCharArray();
        Map<Character, Integer> geneToIdx = new HashMap<>();
        geneToIdx.put('A', 0); geneToIdx.put('C', 1);
        geneToIdx.put('T', 2); geneToIdx.put('G', 3);

        int[] count = new int[]{-chars.length/4, -chars.length/4, -chars.length/4, -chars.length/4};
        for (char c: chars) count[geneToIdx.get(c)]++;

        int exceeded = 0;
        for (int i=0; i<4; i++) {
            if (count[i] <= 0) count[i] = 0;
            else exceeded += count[i];
        }

        if (exceeded == 0) return 0;

        for (int i=exceeded; i<chars.length; i++) {
            int[] candidates = new int[4];
            for (int j=0; j<i-1; j++) candidates[geneToIdx.get(chars[j])]++;
            for (int j=i-1; j<chars.length; j++) {
                candidates[geneToIdx.get(chars[j])]++;
                if (containsGene(candidates, count)) return i;
                candidates[geneToIdx.get(chars[j-i+1])]--;
            }
        }

        return chars.length;
    }

    private static boolean containsGene(int[] a, int[] b) {
        for (int i=0; i<4; i++) {
            if (a[i] - b[i] < 0) return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
