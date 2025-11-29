import java.util.*;

class Solution {
    
    private static final int SIZE = 100;
    
    private static ArrayList<ArrayList<int[]>> road;

    private static int[][] points;
    private static int[][] routes;
    
    public int solution(int[][] points, int[][] routes) {
        
        this.points = points;
        this.routes = routes;
        road = new ArrayList<>();
        //각 로봇의 최소 이동 경로 구하기
        findRoad();
        
        //각 로봇이 충돌하는 구간  구하기
        return findCrash();
        
    }
    
    private static void findRoad(){
        
        for(int k = 0; k < routes.length; k++){
            
            ArrayList<int[]> arr = new ArrayList<>();
            
            int[] now = routes[k];
            int[] st = points[now[0]-1];
            int stX = st[0];
            int stY = st[1];
            arr.add(new int[]{stX,stY});
            for(int i = 1; i < now.length; i++){
                
                int[] en = points[now[i]-1];
                int enX = en[0];
                int enY = en[1];
                
                while(enX != stX){
                    if(enX > stX){
                        stX++;
                    }
                    else{
                        stX--;
                    }
                    arr.add(new int[]{stX,stY});
                }
                
                while(enY != stY){
                    if(enY > stY){
                        stY++;
                    }   
                    else{
                        stY--;
                    }
                    arr.add(new int[]{stX,stY});
                }

                stX = enX;
                stY = enY;
                
            }
            
            road.add(arr);
            
        }
        
    }
    
    private static int findCrash(){
        
        int size = 0;
        for(ArrayList<int[]> arr : road){
            size = Math.max(size,arr.size());
        }
        
        int result = 0;
        
        for(int i = 0; i < size; i++){
            boolean[] visited = new boolean[road.size()];
            for(int j = 0; j < road.size(); j++){
                if(road.get(j).size() <= i || visited[j]) continue;
                boolean check = false;
                visited[j] = true;
                
                int[] now = road.get(j).get(i);
                
                for(int k = j+1; k < road.size(); k++){
                    if(road.get(k).size() <= i || visited[k]) continue;
                    int[] nxt = road.get(k).get(i);
                    if(now[0] == nxt[0] && now[1] == nxt[1]){
                        check = true;
                        visited[k] = true;
                    }
                }
                if(check){
                    result++;
                }
            }
        }
        
        return result;
        
    }
    
}