import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        
        int round = 0;
        int n = cards.length;
        
        int idx = n/3;
        Set<Integer> set = new HashSet<>();
        Set<Integer> newSet = new HashSet<>();
        
        for(int i = 0 ; i < idx; i++){
            set.add(cards[i]);
        }

        while(true){
            
            round++;
            if(idx >= n) return round;
            
            newSet.add(cards[idx]);
            newSet.add(cards[idx+1]);
            idx +=2;
            
            boolean check = false;
            //가지고 있는 카드로 다음 라운드를 갈 수 있는 경우
            for(int num : set){
                if(set.contains(n+1-num)){
                    set.remove(num);
                    set.remove(n+1-num);
                    check = true;
                    break;
                }
            }
            
            //새로운 카드 한 장으로 다음 라운드를 갈 수 있는 경우
            if(!check && coin >= 1){
                for(int num : set){
                    if(newSet.contains(n+1-num)){
                        coin--;
                        set.remove(num);
                        newSet.remove(n+1-num);
                        check = true;
                        break;
                    }
                }
            }
            
            //새로운 카드 두 장으로 다음 라운드를 갈 수 있는 경우
            if(!check && coin >= 2){
                for(int num : newSet){
                    if(newSet.contains(n+1-num)){
                        coin-=2;
                        newSet.remove(num);
                        newSet.remove(n+1-num);
                        check = true;
                        break;
                    }
                }
            }
            
            if(!check){
                break;
            }
        }
        
        return round;
        
    }
}