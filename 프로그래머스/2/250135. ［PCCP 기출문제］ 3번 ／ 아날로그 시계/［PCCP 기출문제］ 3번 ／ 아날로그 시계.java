import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int st = convertToS(h1,m1,s1);
        int en = convertToS(h2,m2,s2);
        
        int result = calcCnt(en) - calcCnt(st);
        //시작 시간에 알람이 울렸는지 
        if(st * 59 % 3600 == 0 || st * 719 % 43200 == 0) result++;
        return result;
        
    }
    
    private static int calcCnt(int t){
        
        //t초 동안 분침과 만나는 횟수
        int m = (int)(t / ((double) 3600 / 59));
        //t초 동안 시침과 만나는 횟수
        int h = (int)(t / ((double) 43200 / 719));
        
        int add = t < 43200 ? 1 : 2;
        
        return m+h-add;
        
    }
    
    private static int convertToS(int h, int m, int s){
        
        return h * 3600 + m * 60 + s;
        
    }
    
}