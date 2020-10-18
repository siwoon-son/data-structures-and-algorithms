package Problem2740;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 행령 곱셈
		// N*M 크기 행렬 A와
		// M*K 크기 행령 B를 행렬 곱셈한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] A = makeMatrix(br);
        int[][] B = makeMatrix(br);
        print_mat_mul(A, B);
	}
	private static int[][] makeMatrix(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] mat = new int[row][col];
		for (int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<col; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		return mat;
	}
	private static void print_mat_mul(int[][] A, int[][] B) {
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<B[0].length; j++) {
				System.out.print(sum_mul_row_by_col(A, B, i, j) + " ");
			}
			System.out.println();
		}
	}
	private static int sum_mul_row_by_col(int[][] A, int[][] B, int row, int col) {
		int sum = 0;
		for (int i=0; i<B.length; i++) {
			sum += A[row][i] * B[i][col];
		}
		return sum;
	}
}
