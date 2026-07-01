import java.util.*;

class Solution {

    private String s;

    public String longestPalindrome(String s) {
        
        this.s = s;

        String result = s.substring(0,1);

        for(int i = 2; i <= s.length(); i++){

            int lt = 0, rt = lt + i - 1;
            while(lt < rt && rt < s.length()){

                if(isPossible(lt,rt)){
                    result = s.substring(lt,Math.min(rt+1,s.length()));
                    break;
                }
                else{
                    lt++;
                    rt++;
                }

            }

        }

        return result;

    }

    private boolean isPossible(int lt , int rt){

        while(lt <= rt){
            
            if(s.charAt(lt) != s.charAt(rt)) return false;
            lt++;
            rt--;

        }

        return true;
        
    }
}