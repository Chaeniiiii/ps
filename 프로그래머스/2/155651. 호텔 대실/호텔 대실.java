import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(String[] book : book_time){
            
            int st = convert(book[0]);
            int en = convert(book[1]) + 10;
            
            arr.add(new int[]{st,0});
            arr.add(new int[]{en,1});
            
        }
        
        arr.sort((a,b) -> {
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        
        int cnt = 0;
        int result = 0;
        
        for(int[] info : arr){
            if(info[1] == 0) cnt++;
            else{
                result = Math.max(result,cnt);
                cnt--;
            }
        }
        
        return result;
        
    }
    
    private static int convert(String str){
        
        String[] time = str.split(":");
        
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        
        return h*60+m;
        
    }
    
}