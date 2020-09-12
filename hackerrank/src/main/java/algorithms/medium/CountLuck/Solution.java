// cite https://github.com/alexprut/HackerRank/blob/master/Algorithms/Search/Count%20Luck/Solution.java

package algorithms.medium.CountLuck;

import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class State {
    Pair p;
    int counter;

    State(Pair position) {
        this.p = position;
        this.counter = 0;
    }

    State(Pair position, int counter) {
        this.p = position;
        this.counter = counter;
    }
}

public class Solution {

    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {
        // Solve problem here

        int N = matrix.length;
        int M = matrix[0].length();
        int[][] board = new int[N][M];
        Pair start = new Pair(0, 0);
        Pair end = new Pair(0, 0);

        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i].charAt(j) == 'X') {
                    board[i][j] = -1;
                } else if (matrix[i].charAt(j) == 'M') {
                    board[i][j] = 0;
                    start = new Pair(i, j);
                } else if (matrix[i].charAt(j) == '*') {
                    board[i][j] = 0;
                    end = new Pair(i, j);
                }
            }
        }


        LinkedList<State> queue = new LinkedList<State>();
        queue.addFirst(new State(start));

        while (queue.size() > 0) {
            State current = queue.pollLast();
            Pair p = current.p;
            ArrayList<Pair> nextMove = new ArrayList<Pair>();

            if (p.x == end.x && p.y == end.y) {
                board[p.x][p.y] = current.counter;
                break;
            } else {
                board[p.x][p.y] = -1;
            }

            // Right
            if (p.y + 1 < M && board[p.x][p.y + 1] == 0) {
                nextMove.add(new Pair(p.x, p.y + 1));
            }

            // Left
            if (p.y - 1 >= 0 && board[p.x][p.y - 1] == 0) {
                nextMove.add(new Pair(p.x, p.y - 1));
            }

            // Up
            if (p.x - 1 >= 0 && board[p.x - 1][p.y] == 0) {
                nextMove.add(new Pair(p.x - 1, p.y));
            }

            // Down
            if (p.x + 1 < N && board[p.x + 1][p.y] == 0) {
                nextMove.add(new Pair(p.x + 1, p.y));
            }

            if (nextMove.size() > 1) {
                current.counter++;
            }

            for (int g = 0; g < nextMove.size(); g++) {
                current.p = nextMove.get(g);
                queue.addFirst(new State(new Pair(current.p.x, current.p.y), current.counter));
            }
        }

        System.out.println(board[end.x][end.y]);
        return board[end.x][end.y] == k ? "Impressed" : "Oops!";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            System.out.println(result);
        }

        scanner.close();
    }
}
