import java.util.*;

class Solution {

    private static int n, m;
    private static int[][] board;

    private static class Robot {
        Pos pos1, pos2;
        int dir; // 0: 가로, 1: 세로

        Robot(Pos pos1, Pos pos2, int dir) {
            // 항상 pos1이 왼쪽 또는 위쪽
            if (pos1.x < pos2.x || (pos1.x == pos2.x && pos1.y < pos2.y)) {
                this.pos1 = pos1;
                this.pos2 = pos2;
            } else {
                this.pos1 = pos2;
                this.pos2 = pos1;
            }
            this.dir = dir;
        }
    }

    private static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] inputBoard) {
        this.board = inputBoard;
        n = board.length;
        m = board[0].length;

        boolean[][][] visited = new boolean[n][m][2]; // pos1 기준, dir
        Deque<Robot> deque = new ArrayDeque<>();
        deque.add(new Robot(new Pos(0, 0), new Pos(0, 1), 0));
        visited[0][0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int cnt = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                Robot rb = deque.poll();
                Pos p1 = rb.pos1;
                Pos p2 = rb.pos2;
                int dir = rb.dir;

                if ((p1.x == n - 1 && p1.y == m - 1) || (p2.x == n - 1 && p2.y == m - 1)) {
                    return cnt;
                }

                // 1. 상하좌우 이동
                for (int d = 0; d < 4; d++) {
                    int nx1 = p1.x + dx[d], ny1 = p1.y + dy[d];
                    int nx2 = p2.x + dx[d], ny2 = p2.y + dy[d];

                    if (isIn(nx1, ny1) && isIn(nx2, ny2)
                            && board[nx1][ny1] == 0 && board[nx2][ny2] == 0) {

                        Robot next = new Robot(new Pos(nx1, ny1), new Pos(nx2, ny2), dir);
                        int vx = next.pos1.x, vy = next.pos1.y;

                        if (!visited[vx][vy][dir]) {
                            visited[vx][vy][dir] = true;
                            deque.add(next);
                        }
                    }
                }

                // 2. 회전
                ArrayList<Robot> rotates = (dir == 0) ? rotationRow(rb) : rotationCol(rb);
                for (Robot next : rotates) {
                    int vx = next.pos1.x, vy = next.pos1.y, vdir = next.dir;
                    if (!visited[vx][vy][vdir]) {
                        visited[vx][vy][vdir] = true;
                        deque.add(next);
                    }
                }
            }

            cnt++;
        }

        return -1;
    }

    private static boolean isIn(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    private static ArrayList<Robot> rotationRow(Robot rb) {
        ArrayList<Robot> list = new ArrayList<>();
        Pos p1 = rb.pos1;
        Pos p2 = rb.pos2;

        // 위 회전
        if (p1.x - 1 >= 0 && board[p1.x - 1][p1.y] == 0 && board[p1.x - 1][p2.y] == 0) {
            list.add(new Robot(p1, new Pos(p1.x - 1, p1.y), 1));
            list.add(new Robot(p2, new Pos(p2.x - 1, p2.y), 1));
        }

        // 아래 회전
        if (p1.x + 1 < n && board[p1.x + 1][p1.y] == 0 && board[p1.x + 1][p2.y] == 0) {
            list.add(new Robot(p1, new Pos(p1.x + 1, p1.y), 1));
            list.add(new Robot(p2, new Pos(p2.x + 1, p2.y), 1));
        }

        return list;
    }

    private static ArrayList<Robot> rotationCol(Robot rb) {
        ArrayList<Robot> list = new ArrayList<>();
        Pos p1 = rb.pos1;
        Pos p2 = rb.pos2;

        // 왼쪽 회전
        if (p1.y - 1 >= 0 && board[p1.x][p1.y - 1] == 0 && board[p2.x][p2.y - 1] == 0) {
            list.add(new Robot(p1, new Pos(p1.x, p1.y - 1), 0));
            list.add(new Robot(p2, new Pos(p2.x, p2.y - 1), 0));
        }

        // 오른쪽 회전
        if (p1.y + 1 < m && board[p1.x][p1.y + 1] == 0 && board[p2.x][p2.y + 1] == 0) {
            list.add(new Robot(p1, new Pos(p1.x, p1.y + 1), 0));
            list.add(new Robot(p2, new Pos(p2.x, p2.y + 1), 0));
        }

        return list;
    }
}
