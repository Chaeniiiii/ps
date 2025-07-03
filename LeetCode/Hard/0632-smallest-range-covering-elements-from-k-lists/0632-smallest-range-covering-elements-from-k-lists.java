import java.util.*;

class Solution {

    private static class Node{
        int idx;
        int listIdx;
        int num;

        private Node(int idx, int listIdx, int num){
            this.idx = idx;
            this.listIdx = listIdx;
            this.num = num;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.num - b.num);
        int[] size = new int[nums.size()];

        int st = 0;
        int end = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //각 리스트의 첫 요소 삽입
        for(int i = 0; i < nums.size(); i++){
            Node node = new Node(0,i,nums.get(i).get(0));
            pq.add(node);

            size[i] = nums.get(i).size();
            max = Math.max(max, node.num);
        }

        while(pq.size() == nums.size()){

            Node now = pq.poll();

            if(max - now.num < end - st){
                st = now.num;
                end = max;
            }

            if(now.idx + 1 < size[now.listIdx]){
                Node nxt = new Node(now.idx+1, now.listIdx, nums.get(now.listIdx).get(now.idx + 1));
                pq.add(nxt);
                max = Math.max(max, nxt.num);
            }

        }

        return new int[]{st,end};

    }
}