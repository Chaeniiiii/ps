import java.util.*;

class Solution {
    
    private static class File {
        
        String head;
        String number;
        String tail;
        
        private File(String head, String number,String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
    }
    
    public String[] solution(String[] files) {
        
        File [] fileArr = new File[files.length];
        String [] result = new String[files.length];
        
        for(int i = 0; i<files.length; i++){
            
            String[] s = setString(files[i]);
            
            String head = s[0];
            String number = s[1];
            String tail = s.length > 2 ? s[2]:"";
            
            fileArr[i] = new File(head,number,tail);
            
        }
        
        Arrays.sort(fileArr,(a, b) -> {
            if(a.head.toUpperCase().equals(b.head.toUpperCase())){
                if(Integer.parseInt(a.number) != Integer.parseInt(b.number)){
                    return Integer.parseInt(a.number) - Integer.parseInt(b.number);    
                }
            }
            
            return a.head.toUpperCase().compareTo(b.head.toUpperCase());
        });
        
         for(int i = 0; i<files.length; i++){
             File file = fileArr[i];
             result[i] = String.join("",file.head,file.number,file.tail);
         }
        
        return result;
    }
    
    private static String [] setString(String str){
        
        String [] newStr = new String[3];
        Arrays.fill(newStr,"");
        
        int idx = 0;
        for(char c : str.toCharArray()){
            
            if(!Character.isDigit(c) && newStr[1].equals("")){
                newStr[0]+=c;
            }
            else if(Character.isDigit(c) && idx < 5 && newStr[2].equals("")){
                newStr[1]+=c;
                idx++;
            }
            else newStr[2]+=c;
            
        }
        

        return newStr;
        
        
    }
    
}