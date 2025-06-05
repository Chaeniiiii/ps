import java.util.*;

class Solution {
    
    private static class Node{
        Node prev = null;
        Node next = null;
        boolean isDelete = false;
    }
    
    public String solution(int n, int k, String[] cmds) {
        
        Node[] nodes = new Node[n];
        nodes[0] = new Node();
        
        for(int i = 1; i < n; i++){
            nodes[i] = new Node();
            nodes[i].prev = nodes[i-1];
            nodes[i-1].next = nodes[i];
        }
        
        Deque<Node> deque = new ArrayDeque<>(); //삭제된 node
        Node now = nodes[k];
        
        for(String cmd : cmds){
            
            char c = cmd.charAt(0);
            int d = 0;
            
            if(c == 'U'){
                d = Integer.parseInt(cmd.substring(2));
                while(d-- > 0){
                    now = now.prev;
                }
            }
            else if(c == 'D'){
                d = Integer.parseInt(cmd.substring(2));
                while(d-- > 0){
                    now = now.next;
                }
            }
            else if(c == 'C'){
                
                deque.add(now);
                now.isDelete = true;
                
                Node prev = now.prev;
                Node next = now.next;
                
                if(prev != null){
                    prev.next = next;
                }
                if(next != null){
                    next.prev = prev;
                    now = next;
                }
                else{
                    now = prev;
                }
            }
            else{
                Node node = deque.pollLast();
                Node prev = node.prev;
                Node next = node.next;
                
                node.isDelete = false;
                if(prev != null){
                    prev.next = node;
                }
                if(next != null){
                    next.prev = node;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(nodes[i].isDelete){
                sb.append('X');
            }
            else{
                sb.append('O');
            }
        }
        
        return sb.toString();
    }
}