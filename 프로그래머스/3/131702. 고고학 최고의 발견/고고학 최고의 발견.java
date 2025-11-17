import java.util.*;

class Solution {

    private static int n,result;
    private static int[][] clockHands;

    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};

    public int solution(int[][] clockHands) {

        this.clockHands = clockHands;
        n = clockHands.length;

        result = Integer.MAX_VALUE;

        dfs(0, new int[n]);

        return result;
    }

    private static void dfs(int dep, int[] firstRow){

        if(dep == n){

            int[][] newBoard = copy(clockHands);

            int cnt = 0;

            for(int j = 0; j < n; j++){
                int rotateCnt = firstRow[j] % 4;
                if(rotateCnt == 0) continue;

                cnt += rotateCnt;
                rotateCell(newBoard, 0, j, rotateCnt);
            }

            cnt += rotateOther(newBoard);

            if(isCorrect(newBoard)){
                result = Math.min(result, cnt);
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            firstRow[dep] = i;
            dfs(dep+1, firstRow);
        }
    }

    private static void rotateCell(int[][] board, int x, int y, int cnt){
        // 자기 자신
        board[x][y] = (board[x][y] + cnt) % 4;

        // 상하좌우
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            board[nx][ny] = (board[nx][ny] + cnt) % 4;
        }
    }

    private static int rotateOther(int[][] newBoard){

        int cnt = 0;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int rotateCnt = (4 - newBoard[i-1][j]) % 4;
                if(rotateCnt == 0) continue;

                cnt += rotateCnt;
                rotateCell(newBoard, i, j, rotateCnt);
            }
        }

        return cnt;
    }

    private static boolean isCorrect(int[][] newBoard){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(newBoard[i][j] != 0) return false;
            }
        }

        return true;
    }

    private static int[][] copy(int[][] origin){
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            arr[i] = origin[i].clone();
        }
        return arr;
    }
}
