import java.util.*;

class Solution {
    
    private static final int SIZE = 10;
    private static Map<Character,Integer> map;
    
    private static class Pos{
        
        int x;
        int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }
    
    public int solution(String dirs) {
        
        init();
        
        boolean [][][] visited = new boolean [SIZE+1][SIZE+1][4];
        Pos pos = new Pos(5,5);
        int cnt = 0;
        
        for(char c : dirs.toCharArray()){
            
            int mvX = pos.x;
            int mvY = pos.y;
            
            int dir = map.get(c);
            int rid = dir % 2 == 0 ? dir + 1 : dir -1;
            
            if(dir == 0) mvX --;
            else if(dir == 1) mvX ++;
            else if(dir == 2) mvY ++;
            else mvY --;
            
            if(mvX < 0 || mvY < 0 || mvX > SIZE || mvY > SIZE) continue;
            if(visited[pos.x][pos.y][dir]){
                pos = new Pos(mvX,mvY);
                continue;
            }
            else{
                visited[pos.x][pos.y][dir] = true;
                visited[mvX][mvY][rid] = true;
                pos = new Pos(mvX,mvY);
            }
            
            cnt ++;
            
        }
        
        return cnt;
        
    }
    
    private static void init(){
        
        map = new HashMap<>();
        map.put('U',0);
        map.put('D',1);
        map.put('R',2);
        map.put('L',3);
        
    }
}