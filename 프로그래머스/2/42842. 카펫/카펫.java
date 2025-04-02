class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        int bCol = 1, bRow = total;
        int yCol = bCol-2, yRow = bRow-2;
        
        while(bCol < bRow ){
            
            if(bCol * bRow == total) {
                if(yCol>0 && bRow>0){
                    if(yCol*yRow == yellow) return new int[]{bRow,bCol};
                }
            }
            
            bRow --;
            bCol = total/bRow;
            
            yCol = bCol-2;
            yRow = bRow-2;
            
        }
        
        return new int[]{bRow,bCol};
    }
}