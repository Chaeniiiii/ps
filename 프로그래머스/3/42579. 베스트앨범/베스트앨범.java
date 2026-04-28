import java.util.*;

class Solution {
    
    private class Album{
        int idx;
        int cnt;
        
        private Album(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    
    private class Genre{
        String gr;
        int cnt;
        
        private Genre(String gr, int cnt){
            this.gr = gr;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,Integer> grArr = new HashMap<>();
        Map<String,ArrayList<Album>> abArr = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            grArr.put(genres[i],grArr.getOrDefault(genres[i],0)+plays[i]);
            abArr.computeIfAbsent(genres[i],v -> new ArrayList<>()).add(new Album(i,plays[i]));
        }
        
        ArrayList<Genre> arr = new ArrayList<>();
        for(String key : grArr.keySet()){
            arr.add(new Genre(key,grArr.get(key)));
        }
        
        arr.sort((a,b) -> b.cnt - a.cnt);
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(Genre genre : arr){
            String key = genre.gr;
            if(abArr.get(key).size() == 1){
                answer.add(abArr.get(key).get(0).idx);
            } 
            else{
                abArr.get(key).sort((a,b) -> b.cnt - a.cnt);
                answer.add(abArr.get(key).get(0).idx);
                answer.add(abArr.get(key).get(1).idx);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
}