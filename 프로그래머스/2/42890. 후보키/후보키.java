import java.util.*;

class Solution {
    
    private static int n,m;
    private static String[][] relation;
    private static ArrayList<String> uniq;
    
    public int solution(String[][] relation) {
        
        n = relation.length;
        m = relation[0].length;
        this.relation = relation;
        uniq = new ArrayList<>();

        dfs(0, new StringBuilder());
        uniq.sort((a,b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        
        Set<String> out = new HashSet<>();
        for(int i = 0; i < uniq.size(); i++){
            String now = uniq.get(i);
            for(int j = i+1; j < uniq.size(); j++){
                int cnt = 0;
                String nxt = uniq.get(j);
                for(char c : now.toCharArray()){
                    for(char cc : nxt.toCharArray()){
                        if(cc == c) cnt++;
                    }
                }
                if(cnt == now.length()) out.add(nxt);
            }
        }
            
        return uniq.size() - out.size();
    }
    
    private static void dfs(int st, StringBuilder sb){

        if(sb.length() != 0 && isPossible(sb.toString())){
            uniq.add(sb.toString());
            return;
        }
    
        for(int i = st; i < m; i++){
            sb.append(i);
            dfs(i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    private static boolean isPossible(String key){
        
        char[] c = key.toCharArray();
        
        StringBuilder sb;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            sb = new StringBuilder();
            for(int j = 0; j < c.length; j++){
                sb.append(relation[i][c[j]-'0']);
            }
            set.add(sb.toString());
        }
        
        if(set.size() == n) return true;
        return false;
        
    }
    
}