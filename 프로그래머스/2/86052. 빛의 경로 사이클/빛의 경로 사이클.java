import java.util.*;

class Solution {

    private static int n, m;
    private static char[][] board;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public int[] solution(String[] grid) {

        n = grid.length;
        m = grid[0].length();

        board = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = grid[i].charAt(j);
            }
        }

        boolean[][][] visited = new boolean[n][m][4];
        ArrayList<Integer> ans = new ArrayList<>();

        // 모든 위치, 모든 방향에서 출발
        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                for(int d = 0; d < 4; d++){
                    if (!visited[x][y][d]) {
                        int cycleLen = simulate(x, y, d, visited);
                        if (cycleLen > 0)
                            ans.add(cycleLen);
                    }

                }
            }
        }

        ans.sort((a,b) -> a-b);

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }

    private static int simulate(int x, int y, int d, boolean[][][] visited) {

        int cnt = 0;

        while(true) {

            if (visited[x][y][d]) break;

            visited[x][y][d] = true;
            cnt++;

            char c = board[x][y];

            if (c == 'L') {
                d = (d + 3) % 4; // 좌회전
            } else if (c == 'R') {
                d = (d + 1) % 4; // 우회전
            }

            x = (x + dx[d] + n) % n;
            y = (y + dy[d] + m) % m;
        }

        return cnt;
    }

}
