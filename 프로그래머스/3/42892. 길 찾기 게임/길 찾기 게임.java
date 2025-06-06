import java.util.*;

class Solution {
    
    private static int n,i;
    private static int[][] result;
    
    private static class Node{
        
        int x;
        int y;
        int idx;
        Node left;
        Node right;
            
        private Node(int x,int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.left = null;
            this.right = null;
        }
        
    }
    
    public int[][] solution(int[][] nodeinfo) {
        
        n = nodeinfo.length;
        
        Node[] nodes = new Node[n];
        
        for(int i = 0; i < n; i++){
            int[] info = nodeinfo[i];
            nodes[i] = new Node(info[0],info[1],i+1);
        }
        
        Arrays.sort(nodes,(a,b) -> {
            if(a.y == b.y){
                return a.x - b.x;
            }
            return b.y - a.y;
        });
        
        Node root = nodes[0];
        
        for(int i = 1; i < n; i++){
            Node child = nodes[i];
            makeTree(root,child);
        }
        
        result = new int[2][n];
        
        i = 0;
        preorder(root);
        
        i = 0;
        postorder(root);
        
        return result;
        
    }
    
    private static void makeTree(Node parent, Node child){
        
        if(parent.x < child.x){
            if(parent.right == null){
                parent.right = child;    
            }
            else{
                makeTree(parent.right,child);
            }
        }
        else {
            if(parent.left == null){
                parent.left = child;
            }
            else{
                makeTree(parent.left,child);
            }
        }
    }
    
    private static void preorder(Node root){
        
        if(root == null) return;
        
        result[0][i++] = root.idx;
        preorder(root.left);
        preorder(root.right);
        
    }
    
    private static void postorder(Node root){
        
        if(root == null) return;
        
        postorder(root.left);
        postorder(root.right);
        result[1][i++] = root.idx;
        
    }
    
}