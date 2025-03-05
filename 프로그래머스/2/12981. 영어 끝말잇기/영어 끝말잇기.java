import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        ArrayList<String> arr = new ArrayList<>();
        
        int cnt = 0;
        char now = words[0].charAt(words[0].length()-1);
        
        while(cnt < words.length){
            
            for(int i = 0; i<n; i++){
                String str = words[i+cnt];
                
                if(cnt != 0 || i != 0) {
                    if(now != str.charAt(0)) return new int[]{i+1,cnt/n + 1};
                }
                
                if(arr.contains(str)) return new int[]{i+1,cnt/n + 1};
                arr.add(str);
                now = str.charAt(str.length()-1);
                
            }
                
            cnt +=n;
            
        }
            
            
        return new int[]{0,0};
    }

}
