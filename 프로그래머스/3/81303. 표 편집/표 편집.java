import java.util.*;

class Solution {
    
    private class Node{
        private Node head = null;
        private Node tail = null;
        private boolean isDelete;
    }
    public String solution(int n, int k, String[] cmd) {
        
        Node[] nodeArr = new Node[n];
        nodeArr[0] = new Node();
        for(int i = 1; i < n; i++){
            nodeArr[i] = new Node();
            nodeArr[i].head = nodeArr[i-1];
            nodeArr[i-1].tail = nodeArr[i];
        }
        
        Deque<Node> deque = new ArrayDeque<>();
        Node now = nodeArr[k];
        
        for(int i = 0; i < cmd.length; i++){
            char c = cmd[i].charAt(0);
            if(c =='U'){
                int x = Integer.parseInt(cmd[i].split(" ")[1]);
                for(int j = 0; j < x; j++){
                    if(now.head == null) break;
                    else now = now.head;
                }
            }
            else if(c == 'D'){
                int x = Integer.parseInt(cmd[i].split(" ")[1]);
                for(int j = 0; j < x; j++){
                    if(now.tail == null) break;
                    else now = now.tail;
                }
            }
            else if(c == 'C'){
                now.isDelete = true;
                deque.add(now);

                Node head = now.head;
                Node tail = now.tail;

                if(head != null){
                    head.tail = tail;
                }
                if(tail != null){
                    tail.head = head;
                    now = tail;
                }
                else{
                    now = head;
                }
            }
            else{
                Node node = deque.pollLast();
                node.isDelete = false;

                Node head = node.head;
                Node tail = node.tail;

                if(head != null) head.tail = node;
                if(tail != null) tail.head = node;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(nodeArr[i].isDelete) sb.append("X");
            else sb.append("O");
        }
        
        return sb.toString();
        
    }
}