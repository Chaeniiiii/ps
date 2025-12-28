import java.util.*;

class Solution {
    
    private static class File{
        
        String head;
        String number;
        String tail;
        
        private File(){}
        
        private File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    
    public String[] solution(String[] files) {

        ArrayList<File> arr = new ArrayList<>();
        
        for(String f : files){
            int i = 0, j = 0;
            File file = new File();
            
            while(true){
                while(!Character.isDigit(f.charAt(i))){
                    i++;
                }
                file.head = f.substring(0,i);
                j = i;
                while(j < f.length() && Character.isDigit(f.charAt(j))){
                    j++;
                }
                file.number = f.substring(i,j);
                if(j == f.length()){
                    file.tail = "";
                    break;
                }
                file.tail = f.substring(j);
                break;
            }
            arr.add(file);
        }
        
        arr.sort((a,b) -> {
            if(a.head.toUpperCase().compareTo(b.head.toUpperCase()) == 0){
                return Integer.parseInt(a.number) - Integer.parseInt(b.number);
            }
            return a.head.toUpperCase().compareTo(b.head.toUpperCase());
        });
        
        String[] result = new String[arr.size()];
        for(int i = 0; i < result.length; i++){
            File file = arr.get(i);
            String str = file.head + file.number + file.tail;
            result[i] = str;
        }
        
        return result;
        
    }
}