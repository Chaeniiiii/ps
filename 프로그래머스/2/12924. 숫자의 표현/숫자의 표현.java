class Solution {
    public int solution(int n) {
        
        int cnt = 1,lt = 1,rt = lt+1, addNum = lt;
        
        while(lt < rt && rt < n){

            addNum += rt;
            
            if(addNum < n){
                rt ++;
            }
            else {
                lt ++;
                rt = lt+1;
                if(addNum == n) cnt ++;
                addNum = lt;
            }
            
        }
        
        return cnt;
        
    }
}