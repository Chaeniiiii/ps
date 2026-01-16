import java.util.*;

class Solution {
    
    private static class Music{
        
        String name;
        int time;
        
        private Music(String name, int time){
            this.name = name;
            this.time = time;
        }
        
    }
    
    public String solution(String m, String[] musicinfos) {
        
        Music music = new Music("",0);
        m = getCode(m);
        
        for(int i = 0; i < musicinfos.length; i++){
            
            String[] infos = musicinfos[i].split(",");
            
            int t = getTime(infos[0],infos[1]);
            String name = infos[2];
            StringBuilder code = new StringBuilder(getCode(infos[3]));
            StringBuilder sb = new StringBuilder(code.toString());
            
            while(t > code.length()){
                code.append(sb);
            }
            code.setLength(t);
            
            if(!code.toString().contains(m)) continue;
            if(music.name.equals("") || music.time < t){
                music = new Music(name,t);
            }
            
        }
        
        return music.name.equals("") ? "(None)" : music.name;
        
    }
    
    private static String getCode(String code){
        
        return code.replace("C#","c").replace("D#","d")
            .replace("F#","f").replace("G#","g").replace("A#","a")
            .replace("B#","C").replace("E#","F");
        
    }
    
    private static int getTime(String sStr, String eStr){
        
        String[] stT = sStr.split(":");
        String[] enT = eStr.split(":");
        
        int st = Integer.parseInt(stT[0]) * 60 + Integer.parseInt(stT[1]);
        int en = Integer.parseInt(enT[0]) * 60 + Integer.parseInt(enT[1]);
        
        return en - st;
        
    }
    
}