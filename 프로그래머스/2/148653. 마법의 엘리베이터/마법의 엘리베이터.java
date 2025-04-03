import java.util.*;

class Solution {
    public int solution(int storey) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        //Deque에 숫자 하나씩 삽입
        for(char c : Integer.toString(storey).toCharArray()){
            deque.add((int)(c-'0'));
        }
        
        int cnt = 0; //버튼 누르는 횟수
        int add = 0; //받아올림 
        
        while(!deque.isEmpty()){
            
            int x = deque.pollLast();
            x += add;
            
            add = 0;
            
            if(x > 5){ //현재 수가 5보다 크면
                cnt+=(10-x);
                add++;
            }
            else if(x < 5){
                cnt+=x;
            }
            else {
                if(deque.isEmpty()){
                    cnt +=5;
                    continue;
                }
                int next = deque.peekLast();
                if(next >= 5){
                    add ++;
                    cnt += (10-x);
                }
                else cnt+=x;
            }
            
            if(deque.isEmpty() && add != 0) cnt+=add;
            
        }
        
        
        return cnt;
        
        
    }
}