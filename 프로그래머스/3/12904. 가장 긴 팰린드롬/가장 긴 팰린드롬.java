import java.util.*;

class Solution
{
    public int solution(String s){
        
        int answer = 1;
        
        for(int i = s.length()-1; i>=1; i--){
            
            int lt = 0, rt = i, cnt=0;
            boolean check = true;
            
            while(lt <= rt){
                
                if(rt >= s.length()){
                    check = false;
                    break;
                }
                
                if(s.charAt(lt) == s.charAt(rt)){
                    lt ++;
                    rt --;   
                }
                else{
                    lt = cnt;
                    rt = lt+i;
                    lt ++;
                    rt ++;
                    cnt++;
                }
                
            }
            
            if(check){
                answer = Math.max(answer,i+1);
                break;
            }

        }
        
        return answer;
        
    }
}