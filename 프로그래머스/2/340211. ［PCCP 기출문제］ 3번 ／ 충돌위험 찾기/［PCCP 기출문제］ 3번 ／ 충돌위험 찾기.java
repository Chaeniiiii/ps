import java.util.*;

class Solution {
    
    private static final int SIZE = 100;
    
    private static int cnt;
    private static Map<Integer,int[]> map;
    
    private static int[][][] visited;
    
    public int solution(int[][] points, int[][] routes) {
        
        cnt = 0;
        visited = new int[SIZE+1][SIZE+1][SIZE*SIZE+(SIZE*SIZE)];
        
        //각 포인트 좌표 저장
        map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            map.put(i+1,points[i]);
        }
        
        //p-to-p 최단 경로 저장 
        for(int i = 0; i < routes.length; i++){
            int t = 0;
            findRt(routes[i]);
        }
        
        return cnt;
        
    }
    
    private static void findRt(int[] r){
        
        int[] st = map.get(r[0]);
        int x = st[0];
        int y = st[1];
        int[] nxt;
        int t = 0;
        if(visited[x][y][t] == 1) cnt++;
        visited[x][y][t]++;
        
        for(int i = 1; i < r.length; i++){
            
            nxt = map.get(r[i]);
            int dx = x < nxt[0] ? 1 : -1; 
            int dy = y < nxt[1] ? 1 : -1;   
            
            while(x != nxt[0] || y != nxt[1]){
               
                t++;
                if(x != nxt[0]) x += dx;
                else if(y != nxt[1]) y+= dy;

                if(visited[x][y][t] == 1){
                    cnt++;
                }
                
                visited[x][y][t]++;

            }
            
        }
        
    }
}