import java.util.*;

class Solution {
    
    private Map<String,Integer> newMenu;
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> arr = new ArrayList<>();
        
        for(int i = 0; i < orders.length; i++){
            String order = orders[i];
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }
        
        for(int i = 0; i < course.length; i++){
            newMenu = new HashMap<>();
            List<String> newArr = new ArrayList<>();
            
            for(int j = 0; j < orders.length; j++){
                if(orders[j].length() < course[i]) continue;
                dfs(orders[j],new StringBuilder(),course[i],0);
            }
            
            int maxCnt = 0;
            for(String key : newMenu.keySet()){
                if(maxCnt > newMenu.get(key) || newMenu.get(key) < 2) continue;
                if(maxCnt < newMenu.get(key)) newArr = new ArrayList<>();
                maxCnt = newMenu.get(key);
                newArr.add(key);
            }
            
            for(String key : newArr){
                arr.add(key);
            }
            
        }
        
        arr.sort((a,b) -> a.compareTo(b));
        String[] result = new String[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
    
    private void dfs(String order,StringBuilder sb, int cnt, int dep){
        
        if(cnt == sb.length()){
            String menu = sb.toString();
            newMenu.put(menu,newMenu.getOrDefault(menu,0)+1);
            return;
        }
        
        for(int i = dep; i < order.length(); i++){
            sb.append(order.charAt(i));
            dfs(order,sb,cnt,i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    
}