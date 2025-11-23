import java.util.*;

class Solution {
    
    private static final int MAX = 8;
    
    private static ArrayList<String> arr;
    private static boolean[] visited;
    private static char[] kakao;
    
    public int solution(int n, String[] data) {
        
        init();
        
        arr = new ArrayList<>();
        visited = new boolean[MAX];
        dfs(0,0, new StringBuilder());
        
        int cnt = 0;
        for(String seq : arr){
            boolean check = true;
            for(int i = 0 ; i < data.length; i++){
                String cmdStr = data[i];
                char me = cmdStr.charAt(0);
                char frd = cmdStr.charAt(2);
                int num = cmdStr.charAt(4) - '0';

                char cmd = cmdStr.charAt(3);
                
                int meIdx = seq.indexOf(me);
                int frdIdx = seq.indexOf(frd);
                int d = Math.abs(meIdx-frdIdx) - 1;
                
                switch(cmd){
                    case '=':
                        if(d != num) check &= false;
                        break;
                    case '>':
                        if(d <= num) check &= false;
                        break;
                    case '<':
                        if(d >= num) check &= false;
                        break;
                }
                if(!check){
                    break;
                }
            }
            if(check) cnt++;
        }
        return cnt;
    }
    
    private static void init(){
        
        kakao = new char[8];
        
        kakao[0] = 'A';
        kakao[1] = 'C';
        kakao[2] = 'F';
        kakao[3] = 'J';
        kakao[4] = 'M';
        kakao[5] = 'N';
        kakao[6] = 'R';
        kakao[7] = 'T';
        
    }
    
    private static void dfs(int st,int dep, StringBuilder sb){
        
        if(dep == MAX){
            arr.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < MAX; i++){
            if(visited[i]) continue;
            sb.append(kakao[i]);
            visited[i] = true;
            dfs(i+1,dep+1,sb);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    
}