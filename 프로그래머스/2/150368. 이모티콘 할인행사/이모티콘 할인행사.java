import java.util.*;

class Solution {
    
    private static int n;
    private static int[] result;
    
    private static int[][] users;
    private static int[] emoticons;
    
    private static int[] disc = new int[]{10,20,30,40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        n = users.length;
        
        this.users = users;
        this.emoticons = emoticons;
        
        result = new int[2];
        dfs(new ArrayList<>());
        
        return result;
        
    }
    
    private static void dfs(ArrayList<Integer> discount){
        
        if(discount.size() == emoticons.length){
            
            int[] newR = calc(discount);
            if(newR[0] > result[0]){
                result = newR;
            }
            else if(newR[0] == result[0] && newR[1] > result[1]){
                result = newR;
            }
            
            return;
            
        }
        
        for(int i = 0; i < 4; i++){
            
            discount.add(disc[i]);
            dfs(discount);
            discount.remove(discount.size() - 1);
            
        }
        
    }
    
    private static int[] calc(ArrayList<Integer> discount){
        
        int[] purchase = new int[n];
        int cnt = 0, sum = 0;
        
        for(int i = 0; i < n; i++){
                        
            for(int j = 0; j < emoticons.length; j++){
                if(users[i][0] > discount.get(j)) continue;
                purchase[i] += emoticons[j] * (100 - discount.get(j))/100;
            }
            
            if(purchase[i] >= users[i][1]) cnt++;
            else sum += purchase[i];
            
        }
        
        return new int[]{cnt,sum};
        
    }
    
}