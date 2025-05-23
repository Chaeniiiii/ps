import java.util.*;

class Solution {
    
    private static class Node {
        
        int val;
        ArrayList<Node> children = new ArrayList<>();
        
        private Node(int val){
            this.val = val;
        }
        
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        Node [] nodes = new Node [n+1];
        for(int i = 1; i<=n; i++) nodes[i] = new Node(i);
            
        for(int [] road : roads){
            nodes[road[0]].children.add(nodes[road[1]]);
            nodes[road[1]].children.add(nodes[road[0]]);
        }                
        
        int [] result = new int[sources.length];
        for(int i = 0; i<sources.length; i++){
            result[i] = bfs(n, nodes[sources[i]],nodes[destination]);
        }        
        
        return result;
        
    }
    
    private static int bfs(int n, Node st,Node en){
        
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(st);
        
        boolean [] visited = new boolean[n+1];
        visited[st.val] = true;
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                Node now = deque.poll();
                if(now.val == en.val) return cnt;
                
                for(Node nxt : now.children){
                    
                    if(visited[nxt.val]) continue;
                    deque.add(nxt);
                    visited[nxt.val] = true;
                    
                }
            }
            
            cnt ++;
            
        }
        
        return -1;
        
    }
}