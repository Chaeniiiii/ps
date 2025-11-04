import java.util.*;

class Solution {
    
    private static final int SIZE = 10;
    
    private static class Move{
        
        Pos st;
        Pos en;
        
        private Move(Pos st, Pos en){
            if(st.x < en.x || (st.x == en.x && st.y < en.y)){
                this.st = st;
                this.en = en;
            }
            else{
                this.st = en;
                this.en = st;
            }
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(st,en);
        }
        
        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            Move mv = (Move)obj;
            return st.equals(mv.st) && en.equals(mv.en);       
        }
        
    }
    
    private static class Pos{
        
        private int x;
        private int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pos p = (Pos) obj;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
    }
    
    public int solution(String dirs) {
        
        Set<Move> set = new HashSet<>();
        Pos pos = new Pos(5,5);
        
        int cnt = 0;
        for(char c : dirs.toCharArray()){
            Pos nxt = new Pos(pos.x,pos.y);
            switch(c){
                case 'U':
                    nxt = new Pos(pos.x-1,pos.y);
                    break;
                case 'D':
                    nxt = new Pos(pos.x+1,pos.y);
                    break;
                case 'R':
                    nxt = new Pos(pos.x,pos.y+1);
                    break;
                case 'L':
                    nxt = new Pos(pos.x,pos.y-1);
                    break;
            }
            
            if(nxt.x < 0 || nxt.y < 0 || nxt.x > SIZE || nxt.y > SIZE) continue;
            
            Move mv = new Move(pos,nxt);
            if(!set.contains(mv)){ 
                cnt++;
                set.add(mv);
            }
            
            pos = nxt;
            
        }
        
        return cnt;
        
    }
}