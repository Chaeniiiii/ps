import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));
        
        for(int c : course){
            Map<String,Integer> map = new HashMap<>();
            for(String order : orders){
                char[] od = order.toCharArray();
                Arrays.sort(od);
                dfs(od,0,0,c,map, new StringBuilder());
            }
            int maxCnt = 0;
            Deque<String> deque = new ArrayDeque<>();
            for(String key : map.keySet()){
                //System.out.printf("%s %d\n",key,map.get(key));
                if(map.get(key) < 2) continue;
                if(deque.isEmpty() || map.get(key) == maxCnt){
                    deque.add(key);
                    maxCnt = map.get(key);
                }
                else if(map.get(key) > maxCnt){
                    deque.clear();
                    deque.add(key);
                    maxCnt = map.get(key);
                }
            }
            while(!deque.isEmpty()){
                pq.add(deque.poll());
            }
        }
        
        int size = pq.size();
        String[] result = new String[size];
        for(int i = 0; i < size; i++){
            result[i] = pq.poll();
        }
        
        return result;
        
        
    }
    
    private static void dfs(char[] str,int idx, int dep, int c, Map<String,Integer> map, StringBuilder sb){
        
        if(dep == c){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        
        for(int i = idx; i < str.length; i++){
            sb.append(str[i]);
            dfs(str,i+1,dep+1,c,map,sb);
            sb.delete(sb.length()-1,sb.length());
        }
        
    }
    
}