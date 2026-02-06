class Solution {

    private static final int SIZE = 3;

    public int solution(String[] board) {
        char[][] bd = new char[SIZE][SIZE];

        int o = 0, x = 0;
        boolean makeO = false, makeX = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bd[i][j] = board[i].charAt(j);
                if (bd[i][j] == 'O') o++;
                else if (bd[i][j] == 'X') x++;
            }
        }

        makeO = isWin(bd, 'O');
        makeX = isWin(bd, 'X');

        return impossible(o, x, makeO, makeX) ? 0 : 1;
    }

    private static boolean isWin(char[][] bd, char c) {

        // 가로
        for (int i = 0; i < SIZE; i++) {
            if (bd[i][0] == c && bd[i][1] == c && bd[i][2] == c)
                return true;
        }

        // 세로
        for (int i = 0; i < SIZE; i++) {
            if (bd[0][i] == c && bd[1][i] == c && bd[2][i] == c)
                return true;
        }

        // 대각선
        if (bd[0][0] == c && bd[1][1] == c && bd[2][2] == c)
            return true;

        if (bd[0][2] == c && bd[1][1] == c && bd[2][0] == c)
            return true;

        return false;
    }

    private static boolean impossible(int o, int x, boolean makeO, boolean makeX) {

        if (x > o) return true;
        if (o - x > 1) return true;

        if (makeO && makeX) return true;
        if (makeO && o != x + 1) return true;
        if (makeX && o != x) return true;

        return false;
    }
}
