import java.util.*;

class Solution {
    
    private static class Node {
        String word;
        int cnt;
        
        private Node (String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(begin,0));
        
        int len = words.length;
        boolean [] visited = new boolean[len];
        
        while(!deque.isEmpty()){
            
            Node now = deque.poll();
            if(now.word.equals(target)) return now.cnt;
            
            for(int i = 0; i<len; i++){
                if(!isCorrect(words[i],now.word) || visited[i]) continue;
                visited[i] = true;
                deque.add(new Node(words[i],now.cnt+1));
            }
            
        }
        
        return 0;
        
    }
    
    private static boolean isCorrect(String nextStr, String begin){
        
        int idx = 0;
        
        for(int i = 0; i<nextStr.length(); i++){
            if(nextStr.charAt(i) != begin.charAt(i)) idx++;
            if(idx > 1) return false;
        }
        
        return true;
    }
    
}