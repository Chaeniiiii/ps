import java.util.*;

class Solution {
    
    private static int k,n,max;
    private static ArrayList<int[]> mento;
    private static Map<Integer,ArrayList<Time>> map;
    
    private static class Time{
        
        int st;
        int en;
        
        private Time(int st, int en){
            this.st = st;
            this.en = en;
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        
        map = new HashMap<>();
        mento = new ArrayList<>();
        this.k = k;
        this.n = n;
        
        for(int[] req : reqs){
            Time t = new Time(req[0],req[1]);
            map.computeIfAbsent(req[2],v -> new ArrayList<>()).add(t);
        }
        
        
        div(n,1,new int[k+1]);
        
        int result = Integer.MAX_VALUE;

        for(int[] m : mento){
            int t = 0;
            for(int i = 1; i <= k; i++){
                if(map.containsKey(i)){
                    t+=calcT(i,m[i]);
                }
            }
            result = Math.min(t,result);
        }
        
        return result;
        
    }
    
    //각 유형 당 할당할 수 있는 멘토 수의 조합
    private static void div(int cnt,int idx,int[] m){
        
        if(cnt <= 0) return;
        if(idx == k){
            m[idx] = cnt;
            mento.add(m.clone());
            return;
        }
        
        for(int i = 1; i <= 1+n-map.size(); i++){
            if(map.containsKey(idx)){
                m[idx] = i;
                div(cnt-i,idx+1,m);
            }
            else{
                m[idx] = 1;
                div(cnt-1,idx+1,m);
            }
            
        }
        
    }
    
    //시간 계산
    private static int calcT(int idx, int mentoCnt){
        
        if(mentoCnt >= map.get(idx).size()) return 0;
        
        ArrayList<Time> arr = map.get(idx);
        arr.sort((a,b) -> a.st - b.st);
        
        int[] t = new int[mentoCnt];
        int i = 0;
        for(; i < mentoCnt; i++){
            t[i] = arr.get(i).st+arr.get(i).en;
        }
        
        int time = 0;
        
        //System.out.println(Arrays.toString(t));
        
        while(i < arr.size()){
            Arrays.sort(t);
            int wait = t[0] - arr.get(i).st;
            if(wait >= 0){
                time+=wait;
                t[0] += arr.get(i).en;
            }
            else{
                t[0] = arr.get(i).st+arr.get(i).en; 
            }
            i++;
        }
        
        return time;
        
    }
    
    
}