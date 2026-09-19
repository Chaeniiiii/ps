import java.util.*;

class Solution {
    
    private int n, m, size;
    private int[][] lock;
    private int[][] key;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        this.n = key.length;
        this.m = lock.length;
        this.lock = lock;
        this.key = key;
        
        for (int r = 0; r < 4; r++) {
            if (isPossible()) return true;
            rotate(); 
        }
        
        return false;
    }
    
    private boolean isPossible() {
        
        int maxOffset = m + (n - 1) * 2;
        
        for (int y = 0; y < maxOffset; y++) {
            for (int x = 0; x < maxOffset; x++) {
                if (check(y, x)) return true;
            }
        }
        return false;
        
    }

    private boolean check(int y, int x) {
        int[][] board = new int[m][m];
        for (int i = 0; i < m; i++) {
            board[i] = lock[i].clone();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int lockY = y + i - (n - 1);
                int lockX = x + j - (n - 1);
                
                if (lockY >= 0 && lockY < m && lockX >= 0 && lockX < m) {
                    if (board[lockY][lockX] == 1 && key[i][j] == 1) {
                        return false;
                    }
                    if (board[lockY][lockX] == 0 && key[i][j] == 1) {
                        board[lockY][lockX] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        
        return true;
    }
    
    private void rotate() {
        int[][] rotateKey = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotateKey[j][n - 1 - i] = key[i][j];
            }
        }
        key = rotateKey;
    }
}