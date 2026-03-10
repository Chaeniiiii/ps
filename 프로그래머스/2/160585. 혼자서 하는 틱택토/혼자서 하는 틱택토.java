import java.util.*;

class Solution {
    
    private static final int size = 3;
    
    public int solution(String[] board) {
        
        
        int o = 0; int x = 0;
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                char c = board[i].charAt(j);
                if(c == 'O') o++;
                else if(c == 'X') x++;
            }
        }
        if(o > x + 1 || o < x) return 0;
        
        boolean[] bg = new boolean[2];
        
        bingo(board, bg);
        
        if(bg[0] && bg[1]) return 0;
        if(bg[0] && x != o - 1) return 0;
        if(bg[1] && o != x) return 0;
        
        return 1;
        
    }
    
    private static void bingo(String[] board, boolean[] bg){
        
        //가로
        for(int i = 0; i < size; i++){
            char st = board[i].charAt(0);
            if(st == '.') continue;
            if(board[i].charAt(1) == st && board[i].charAt(2) == st){
                if(st == 'O') bg[0] |= true;
                else if(st == 'X') bg[1] |= true;
            }
        }
        
        //세로
        for(int i = 0; i < size; i++){
            char st = board[0].charAt(i);
            if(st == '.') continue;
            if(board[1].charAt(i) == st && board[2].charAt(i) == st){
                if(st == 'O') bg[0] |= true;
                else if(st == 'X') bg[1] |= true;
            }
        }
        
        //대각선 
        char cl = board[0].charAt(0); char cr = board[0].charAt(2);
        if(cl == board[1].charAt(1) && cl == board[2].charAt(2)){
            if(cl == 'O') bg[0] |= true;
            else if(cl == 'X') bg[1] |= true;
        }  
        if(cr == board[1].charAt(1) && cr == board[2].charAt(0)){
            if(cr == 'O') bg[0] |= true;
            else if(cr == 'X') bg[1] |= true;
        }   
        
    }
}