import java.util.*;

class Solution {
    
    //사용자 수
    private static int n;
    //이모티콘 개수
    private static int m;
    //할인률 개수
    private static int l;
    //이모티콘 플러스 구독자 수
    private static int[] result;
    //사용자
    private static int[][] users;
    //이모티콘
    private static int[] emoticons;
    //할인률
    private static int[] discount;
    //이모티콘 할인 적용 방문 처리 배열
    private static boolean[][] visited;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        discount = new int[]{10,20,30,40};
        
        n = users.length;
        m = emoticons.length;
        l = discount.length;
        
        this.users = users;
        this.emoticons = emoticons;
        
        result = new int[2];
        visited = new boolean[m][l];
        
        dfs(0,new ArrayList<>());
        
        return result;
        
    }
    
    private static void dfs(int st, ArrayList<Integer> arr){
        
        if(arr.size() > m) return;
        
        // 이모티콘 금액 별 조합을 완성했으면 목표 달성했는지 확인
        if(arr.size() == m){ 
            
            int[] midAnswer = isGoal(arr);
            if(midAnswer[0] > result[0]){
                result = midAnswer;
            }
            else if(midAnswer[0] == result[0]){
                if(result[1] < midAnswer[1]){
                    result = midAnswer;
                }
            }
            
            return;
        }
        
        for(int i = 0; i < l; i++){
            if(visited[st][i]) continue;
            visited[st][i] = true;
            arr.add(discount[i]);
            dfs(st+1,arr);
            arr.remove(arr.size()-1);
            visited[st][i] = false;
        }
        
    }
    
    private static int[] isGoal(ArrayList<Integer> arr){
        
        int[] cnt = new int[2];
        int money, idx;
        
        for(int[] user : users){
            
            int disc = user[0]; //유저가 원하는 할인률
            int total = user[1]; //유저가 원하는 이모티콘 총 금액
            
            money = 0; //해당 유저가 구매한 이모티콘 금액
            
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i) < disc) continue;
                money += (emoticons[i] - emoticons[i] * arr.get(i) * 0.01);
            }
            
            if(money >= total) cnt[0]++;
            else cnt[1] += money;
        }        
        
        return cnt;
        
    }
}