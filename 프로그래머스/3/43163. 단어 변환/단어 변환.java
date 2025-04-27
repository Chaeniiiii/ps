import java.util.*;

class Solution {
    
    private static Map<Integer,Set<Character>> map;
    
    private static ArrayList<String> arr;
    private static boolean [] visited;
    
    private static int result;
    
    public int solution(String begin, String target, String[] words) {
        
        map = new HashMap<>();
        arr = new ArrayList<>();
        
        //문자열을 이루고 있는 문자와 인덱스를 value, key값으로 저장
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                map.computeIfAbsent(i,v -> new HashSet<>()).add(word.charAt(i));
            }
            arr.add(word);
        }
        
        if(!arr.contains(target)) return 0;
        
        result = Integer.MAX_VALUE;
        visited = new boolean [arr.size()];
        
        dfs(begin, target, 0);
        
        return result;
        
    }
    
    private static void dfs(String begin, String target, int cnt){
        
        if(begin.length() > target.length()) return;
        
        if(begin.equals(target)){
            result = Math.min(result,cnt);
            return;
        }
        
        for(int i = 0; i < begin.length(); i++){
            for(char c : map.get(i)){
                char [] str = begin.toCharArray();
                str[i] = c;
                
                String nextStr = new String(str);
                int idx = arr.indexOf(nextStr);
            
                if(idx == -1 || visited[idx]) continue;
                
                visited[idx] = true;
                dfs(new String(str),target,cnt+1);    
                visited[idx] = false;
                
            }
        }
        
    }
}