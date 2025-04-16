import java.util.*;

class Solution {
    
    private static Map<String,Integer> map;
    private static boolean [] len;
    private static int maxLen;
    
    public String[] solution(String[] orders, int[] course) {
        
        map = new HashMap<>();
        len = new boolean[11];
        maxLen = course[course.length-1];
        
        for(int cour : course) len[cour] = true;
        
        for(String order : orders){
            char [] newOrder = order.toCharArray();
            Arrays.sort(newOrder);
            
            order = new String(newOrder);
            dfs(0,order,"",0);
        }
        
        ArrayList<String> arr = new ArrayList<>();
        
        int [] max = new int[maxLen+1];
        Map<Integer,ArrayList<String>> result = new HashMap<>();
        
        for(String key : map.keySet()){
            if(map.get(key) >= 2){
                if(max[key.length()] < map.get(key)){
                    result.remove(key.length());
                    result.computeIfAbsent(key.length(),v -> new ArrayList<>()).add(key);
                    max[key.length()] = map.get(key);
                }
                else if (max[key.length()] == map.get(key)){
                    result.get(key.length()).add(key);
                }
            }
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        for(int key : result.keySet()){
            for(String value : result.get(key)) answer.add(value);
        }
        
        String [] total = new String[answer.size()];
    
        for(int i = 0; i<answer.size(); i++) total[i] = answer.get(i);
        Arrays.sort(total);
        
        
        return total;
        
    }
    
    private static void dfs(int start , String origin, String str, int dep){
        
        if(dep > maxLen) return;
        
        if(len[dep]){
            StringBuilder sb = new StringBuilder(str);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        for(int i = start; i<origin.length(); i++){
            dfs(i+1,origin,str+origin.charAt(i),dep+1);
        }
        
    }
}