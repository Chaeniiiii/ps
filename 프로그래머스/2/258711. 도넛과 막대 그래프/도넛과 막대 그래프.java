import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        //각 노드 별 in, out 간선 개수 확인
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int out = edges[i][0]; 
            int in = edges[i][1]; 
            
            map.putIfAbsent(out, new int[2]);
            map.putIfAbsent(in, new int[2]);
            
            map.get(out)[1]++;
            map.get(in)[0]++;
            
        }
        
        //임의의 정점 찾아주기
        int cnt = 0;
        int[] result = new int[4];
        
        for(int key : map.keySet()){
            int[] edge = map.get(key);
            if(edge[0] == 0 && edge[1] > cnt){
                result[0] = key;
                cnt = map.get(key)[1];
            }
        }
        
        for(int key : map.keySet()){
            int[] edge = map.get(key);
            if(edge[0] == 0) continue;
            //8자 그래프 
            if(edge[1] == 2){
                result[3]++;
                cnt--;
            }
            //막대 그래프
            else if(edge[1] == 0){
                result[2]++;
                cnt--;
            }
        }
        
        result[1] = cnt;
        return result;
    }
}