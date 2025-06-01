import java.util.*;
class Solution {
    
    private static Map<String, String> parent;
    private static Map<String, Integer> money;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        parent = new HashMap<>();
        money = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            share(seller[i], amount[i] * 100);
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = money.getOrDefault(enroll[i], 0);
        }

        return result;        
      
    }
    
    private static void share(String node, int sales) {
        int nextSales = sales / 10;
        money.put(node, money.getOrDefault(node, 0) + sales - nextSales);

        if (nextSales > 0 && parent.containsKey(node)) {
            share(parent.get(node), nextSales);
        }
    }
    
}