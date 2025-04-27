import java.util.*;

class Solution {
    
    private static Map<Integer,Set<Character>> map;
    private static ArrayList<String> arr;
    
    private static class Node {
        String word;
        int cnt;
        
        private Node (String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        arr = new ArrayList<>();
        map = new HashMap<>();
        
        //문자열을 이루고 있는 문자와 인덱스를 value, key값으로 저장
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                map.computeIfAbsent(i,v -> new HashSet<>()).add(word.charAt(i));
            }
            arr.add(word);
        }
        
        if(!arr.contains(target)) return 0;
        return bfs(begin, target);
        
    }
    
    private static int bfs(String begin, String target) {
       
        ArrayList<String> visited = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(begin,0));
        
        while(!deque.isEmpty()){

            Node now = deque.poll();
            
            if(now.word.equals(target)) return now.cnt;
            
            for(int i = 0; i<now.word.length(); i++){
                for(char c : map.get(i)){
                    char [] str = now.word.toCharArray();    
                    str[i] = c;
                    
                    String newStr = new String(str);
                    if(arr.indexOf(newStr) == -1 || visited.contains(newStr)) continue;
                    visited.add(newStr);
                    deque.add(new Node(newStr,now.cnt+1));
                    
                }
                       
            }
            
        }
        
        return 0;
        
    }
}