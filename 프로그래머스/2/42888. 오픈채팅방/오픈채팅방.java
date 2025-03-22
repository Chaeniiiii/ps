import java.util.*;

class Solution {
    
    private static final String ENT = "Enter";
    private static final String LVE = "Leave";
    private static final String CHG = "Change";
    
    private static class User{
        String id;
        int cmd;
        
        private User(String id){
            this.id = id;
        }
        
        private void setCmd(int cmd){
            this.cmd = cmd;
        }
        
    }
    public String[] solution(String[] record) {
        
        Map<String,String> map = new HashMap<>();
        ArrayList<User> arr = new ArrayList<>();
        
        for(String s : record){
            
            String [] str = s.split(" ");
            
            User user = new User(str[1]);
            
            switch(str[0]){
                case ENT:
                    map.put(str[1],str[2]);
                    user.setCmd(0);
                    arr.add(user);
                    break;
                case LVE:
                    user.setCmd(1);
                    arr.add(user);
                    break;
                case CHG:
                    map.put(str[1],str[2]); 
                    break;
                default:
                    break;
            }
            
        }
        
        String [] result = new String[arr.size()];
        StringBuilder sb;
        
        for(int i = 0; i<arr.size(); i++){
            
            sb = new StringBuilder();
            sb.append(map.get(arr.get(i).id));
            
            if(arr.get(i).cmd == 0) sb.append("님이 들어왔습니다.");
            else sb.append("님이 나갔습니다.");
            
            result[i] = sb.toString();
            
        }
        
        return result;
        
    }
}