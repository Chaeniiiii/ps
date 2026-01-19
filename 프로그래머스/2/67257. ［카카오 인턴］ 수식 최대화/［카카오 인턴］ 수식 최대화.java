import java.util.*;

class Solution {
    
    private static long result;
    
    private static boolean[] visited;
    private static ArrayList<Long> num;
    private static ArrayList<Character> ope;
    private static ArrayList<Character> opeKinds;
    
    public long solution(String expression) {
        
        result = 0;
        num = new ArrayList<>();
        ope = new ArrayList<>();
        opeKinds = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(!Character.isDigit(c)){
                ope.add(c);
                if(!opeKinds.contains(c)) opeKinds.add(c);
                num.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                continue;
            }
            sb.append(c);
        }
        
        num.add(Long.parseLong(sb.toString()));

        visited = new boolean[opeKinds.size()];
        dfs(0,new ArrayList<>());
        
        return result;
        
    }
    
    private static void dfs(int dep, ArrayList<Character> seq){
        
        if(dep == opeKinds.size()){
            calc(seq);
            return;
        }
        
        for(int i = 0; i < opeKinds.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            seq.add(opeKinds.get(i));
            dfs(dep+1,seq);
            seq.remove(seq.size() - 1);
            visited[i] = false;
        }
        
    }
    
    private static void calc(ArrayList<Character> seq){
        
        ArrayList<Long> newNum = new ArrayList<>(num);
        ArrayList<Character> newOpe = new ArrayList<>(ope);
        
        for(char c : seq){
            
            for(int i = 0; i < newOpe.size();){
                
                if(newOpe.get(i) == c){
                    
                    long a = newNum.get(i);
                    long b = newNum.get(i+1);
                    long res = 0;
                    
                    switch(c){
                        case '+':
                            res = a+b;
                            break;
                        case '*':
                            res = a*b;
                            break;
                        case '-':
                            res = a-b;
                            break;
                    }
                    
                    newOpe.remove(i);
                    
                    newNum.remove(i+1);
                    newNum.set(i,res);
                    
                }
                else{
                    i++;
                }
                 
            }
            
        }
        
        result = Math.max(result,Math.abs(newNum.get(0)));
        
    }
        
    
}