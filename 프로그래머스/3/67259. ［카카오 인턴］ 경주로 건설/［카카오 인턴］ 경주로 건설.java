import java.util.*;

class Solution {

    private static final int MAX = Integer.MAX_VALUE;
    private static Deque<Car> deque;

    private static class Car {
        int x, y, d, total;
        Car(int x, int y, int d, int total){
            this.x = x;
            this.y = y;
            this.d = d;
            this.total = total;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        deque = new ArrayDeque<>();

        // 방향: 상하좌우 → dx, dy, 방향 인덱스 0~3
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 방문 배열을 [x][y][direction] 으로 만든다
        int[][][] visited = new int[n][n][4];
        for(int[][] layer : visited)
            for(int[] row : layer)
                Arrays.fill(row, Integer.MAX_VALUE);

        // 시작점 초기화
        if(board[0][1] == 0) {
            deque.add(new Car(0, 1, 3, 100)); // 우
            visited[0][1][3] = 100;
        }
        if(board[1][0] == 0) {
            deque.add(new Car(1, 0, 1, 100)); // 하
            visited[1][0][1] = 100;
        }

        int result = MAX;

        while(!deque.isEmpty()) {
            Car now = deque.poll();

            if(now.x == n-1 && now.y == n-1) {
                result = Math.min(result, now.total);
                continue;
            }

            for(int k = 0; k < 4; k++) {
                int mvX = now.x + dx[k];
                int mvY = now.y + dy[k];

                if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= n || board[mvX][mvY] == 1) continue;

                int cost = (now.d == k) ? now.total + 100 : now.total + 600;

                if(visited[mvX][mvY][k] > cost) {
                    visited[mvX][mvY][k] = cost;
                    deque.add(new Car(mvX, mvY, k, cost));
                }
            }
        }

        return result;
    }
}
