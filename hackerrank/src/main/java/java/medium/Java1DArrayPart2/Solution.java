package java.medium.Java1DArrayPart2;

import java.util.*;

// https://www.hackerrank.com/challenges/java-1d-array/problem
public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // my code
        return canWin(leap, game, 0);
        // end
    }

    // my code
    private static boolean canWin(int leap, int[] game, int cur) {
        if (cur < 0) return false;  //  This cell is not exists.
        if (game[cur] == 1) return false;   // This cell contains 1.
        if (cur == game.length - 1) return true;    // I am standing in cell n-1.
        if (cur + leap >= game.length) return true; // I escaped the game.
        game[cur] = 1;  // The cell is visited.
        return canWin(leap, game, cur+leap) ||  // I will jump to cell i+leap.
            canWin(leap, game, cur+1) ||        // I will walk to cell i+1.
            canWin(leap, game, cur-1);          // I will walk back to cell i-1.
    }
    // end

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
