import java.util.*;

class Solution {
    public String solution(String p) {
        
        return game(p);        
        
    }
    
    private String game(String p){
        
        if(p.length() == 0) return "";
        
        //u,v 분리
        int lt = 0, rt = 0;
        
        StringBuilder u = new StringBuilder(); 
        StringBuilder v = new StringBuilder(); 
        Deque<Character> deque = new ArrayDeque<>();        
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            if(c == '('){
                lt++;
                deque.add(c);
            }
            else{
                rt++;
                deque.poll();
            }
            
            if(lt == rt){
                u = new StringBuilder(p.substring(0,i+1));
                v = new StringBuilder(p.substring(i+1));
                break;
                
            }
            
        }
        
        
        //올바른 문자열인지 확인
        if(deque.isEmpty()){
           return u.toString() + game(v.toString()); 
        }
        else{
            if(u.length() <= 2){
                return '(' + game(v.toString()) + ')';
            }
            else{
                StringBuilder temp = new StringBuilder();
                for(int i = 1; i < u.length() - 1; i++){
                    if(u.charAt(i) == '(') temp.append(')');
                    else temp.append('(');
                }
                return '(' + game(v.toString()) + ')' + temp.toString();
            }
            
        }
        
    }
}