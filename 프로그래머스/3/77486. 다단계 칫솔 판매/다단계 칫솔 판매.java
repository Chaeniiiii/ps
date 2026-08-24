import java.util.*;

class Solution {
    
    private int[] result;
    private String[] enroll;
    private String[] referral;
    private Map<String,Integer> map;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        this.enroll = enroll;
        this.referral = referral;
        result = new int[enroll.length];
        
        //각 판매원의 인덱스 저장
        map = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i],i);
        }
        
        //총 수익금 저장
        for(int i = 0; i < amount.length; i++){
            amount[i] *= 100;
        }
        
        //판매 이익 저장
        for(int i = 0; i < seller.length; i++){
            dfs(seller[i],amount[i]);
        }
        
        return result;
        
    }
    
    private void dfs(String sel, int profit){

        if(sel.equals("-")) return;
        
        int idx = map.get(sel);
        int pay = (int)(profit * 0.1);
        
        if(pay >= 1) dfs(referral[idx],pay);
        result[idx] += (profit - pay);
        
    }
}