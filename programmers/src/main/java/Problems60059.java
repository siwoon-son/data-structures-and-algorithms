public class Problems60059{
    public static void main(String[] args) {
        Problems60059 app = new Problems60059();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(app.solution(key, lock)); // expect true
    }

    public boolean solution(int[][] key, int[][] lock) {
        final int M = key.length;
        final int N = lock.length;
        final int LEN_PADDED = N+2*(M-1);
        int[][] paddedLock = new int[LEN_PADDED][LEN_PADDED];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                paddedLock[i+M-1][j+M-1] = lock[i][j];
            }
        }

        for (int i=0; i<3; i++) {
            if (unlock(key, paddedLock)) return true;
            key = rotate(key);
        }
        return unlock(key, paddedLock);
    }

    private boolean unlock(int[][] key, int[][] lock) {
        for (int i=0; i<lock.length-key.length+1; i++) {
            for (int j=0; j<lock.length-key.length+1; j++) {
                if (unlock(key, lock, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean unlock(int[][] key, int[][] lock, int row, int col) {
        int[][] copied = new int[lock.length][lock.length];
        for (int i=key.length-1; i<lock.length-key.length+1; i++) {
            for (int j=key.length-1; j<lock.length-key.length+1; j++) {
                copied[i][j] = lock[i][j];
            }
        }

        for (int i=0; i<key.length; i++) {
            for (int j=0; j<key.length; j++) {
                copied[i+row][j+col] += key[i][j];
            }
        }

        for (int i=key.length-1; i<lock.length-key.length+1; i++) {
            for (int j=key.length-1; j<lock.length-key.length+1; j++) {
                if (copied[i][j] != 1) return false;
            }
        }
        return true;
    }

    private int[][] rotate(int[][] key) {
        final int M = key.length;
        int[][] rotated = new int[M][M];
        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                rotated[i][j] = key[M-j-1][i];
            }
        }

        return rotated;
    }
}