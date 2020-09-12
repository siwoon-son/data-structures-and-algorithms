import java.util.Stack;

public class Problems64061 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int result = new Problems64061().solution(board, moves);
        System.out.println(result); // expect 4.
    }
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<Integer>();
        for (int move: moves) {
            int doll = getDoll(board, move-1);
            if (!basket.empty() && doll != 0 && 
                basket.peek().intValue() == doll) {
                answer += 2;
                basket.pop();
            } else {
                basket.push(doll);
            }
        }

        return answer;
    }
    private int getDoll(int[][] board, int col) {
        final int N = board.length;
        for (int i=0; i<N; i++) {
            int curDoll = board[i][col];
            if (curDoll != 0) {
                board[i][col] = 0;
                return curDoll;
            }
        }
        return 0;
    }
}