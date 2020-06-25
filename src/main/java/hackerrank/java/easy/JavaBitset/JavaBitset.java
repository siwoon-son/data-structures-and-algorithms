package hackerrank.java.easy.JavaBitset;

import java.util.*;

// https://www.hackerrank.com/challenges/java-bitset/problem
public class JavaBitset {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        BitSet[] b = new BitSet[]{null, new BitSet(N), new BitSet(N)};

        for (int i=0; i<M; i++) {
            String op = sc.next();
            int l = sc.nextInt();
            int r = sc.nextInt();
            switch (op) {
            case "AND":
                bitSetAnd(b[l], b[r]);
                break;
            case "OR":
                bitSetOr(b[l], b[r]);
                break;
            case "XOR":
                bitSetXor(b[l], b[r]);
                break;
            case "FLIP":
                bitSetFlip(b[l], r);
                break;
            case "SET":
                bitSetSet(b[l], r);
                break;
            }
            System.out.println(b[1].cardinality() + " " + b[2].cardinality());
        }
    }
    private static void bitSetAnd(BitSet b1, BitSet b2) {
        b1.and(b2);
    }
    private static void bitSetOr(BitSet b1, BitSet b2) {
        b1.or(b2);
    }
    private static void bitSetXor(BitSet b1, BitSet b2) {
        b1.xor(b2);
    }
    private static void bitSetFlip(BitSet b, int idx) {
        b.flip(idx);
    }
    private static void bitSetSet(BitSet b, int idx) {
        b.set(idx);
    }
}
