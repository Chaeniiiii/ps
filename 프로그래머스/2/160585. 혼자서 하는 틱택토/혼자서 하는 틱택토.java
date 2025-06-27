import java.util.*;

class Solution {
    public int solution(String[] board) {
        
        int o = 0;
        int x = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == 'O'){
                    o++;
                }
                else if(board[i].charAt(j) == 'X'){
                    x++;
                }
            }
        }
        
        if(x > o) return 0;
        if(o > x + 1) return 0;
        
        if(bingo(board,'O') && x == o) return 0;
        if(bingo(board,'X') && x + 1 == o) return 0;
        
        return 1;
        
    }
    
    private static boolean bingo(String[] board, char c){
        
        //가로 확인
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
        }
        
        //세로 확인
        for(int i = 0; i < 3; i++){
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        
        //대각선 확인
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        
        return false;
        
    }
}