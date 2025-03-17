class Solution {
    
    private static final int SIZE = 5;
    private static char [] aeiou;
    
    private static int total;
    private static boolean check;
    
    public int solution(String word) {
        
        aeiou = new char[]{'A','E','I','O','U'};
        
        total = 0;
        check = false;
        dfs("",word);
        
        return total;
        
    }
    
    private static void dfs(String str,String word){

        if(str.equals(word)) {
            check = true;
            return;
        }
        if(str.length() >= SIZE) return;
        
        for(int i = 0; i<SIZE; i++){
            if(check) return;
            total++;
            dfs(str+aeiou[i],word);
        }
        
    }
    
}