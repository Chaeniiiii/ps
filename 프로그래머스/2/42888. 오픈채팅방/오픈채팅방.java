import java.util.*;

class Solution {
    
    private static class Member{
        
        String nickname;
        ArrayList<Integer> action;  //0 : enter, 1 : leave
        
        private Member(){
            action = new ArrayList<>();
        }
        
        private void updateNickname(String nickname){
            this.nickname = nickname;
        }
        
        private void addAction(int act){
            this.action.add(act);
        }
    }
    
    public String[] solution(String[] record) {
        
        ArrayList<String> seq = new ArrayList<>();
        Map<String,Member> map = new HashMap<>();
        
        for(String rc : record){
            
            String[] str = rc.split(" ");
            String action = str[0];
            String id = str[1];
            
            Member member = new Member();
            if(!map.containsKey(id)){
                map.put(id,member);
            }
            else{
                member = map.get(id);
            }
            
            switch(action){
                case "Enter" :
                    member.updateNickname(str[2]);
                    member.addAction(0);
                    seq.add(id);
                    break;
                case "Change" :
                    member.updateNickname(str[2]);
                    break;
                case "Leave" :
                    member.addAction(1);
                    seq.add(id);
                    break;
            }
        }
        
        String[] result = new String[seq.size()];
        for(int i = 0; i < result.length; i++){
            Member member = map.get(seq.get(i));
            int action = member.action.get(0);
            result[i] = member.nickname + "님이" + (action == 0 ? " 들어왔습니다." : " 나갔습니다.");
            member.action.remove(0);
        }
        
        return result;
        
    }
}