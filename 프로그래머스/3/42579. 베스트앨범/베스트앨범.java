import java.util.*;

class Solution {
    
    private static class Genre {
     
        String name;
        int t;
        
        private Genre(String name, int t){
            this.name = name;
            this.t = t;
        }
        
    }
    
    private static class Album {
        
        int idx;
        int play;
        
        private Album(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
            
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,Integer> total = new HashMap<>();
        Map<String,PriorityQueue<Album>> map = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++){
            String gnr = genres[i];
            total.put(gnr,total.getOrDefault(gnr,0)+plays[i]);
            map.computeIfAbsent(gnr, k -> new PriorityQueue<>((o1, o2) -> o2.play - o1.play)).add(new Album(i,plays[i]));
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>((o1,o2) -> o2.t - o1.t);
        for(String key : total.keySet()){
            pq.add(new Genre(key,total.get(key)));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty()){
            
            String name = pq.poll().name;
            
            for(int i = 0; i<2; i++){
                if(map.get(name).isEmpty()) break;
                result.add(map.get(name).poll().idx);
            }
            
        }
        
        int [] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++) answer[i] = result.get(i);
        
        return answer;
    }
}