import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        int maxT = 0;
        String result = "(None)";
        
        for(int i = 0; i < musicinfos.length; i++){
            String musicinfo = musicinfos[i];
            String[] info = musicinfo.split(",");
            
            String st = info[0];
            String en = info[1];
            String title = info[2];
            String musicS = info[3];
            
            //1. 시간 계산
            int t = calcT(st,en);
            
            //2. 악보 변환 및 재생된 악보 계산
            String newMusicS = calcMusicS(t, musicS);
            
            //3. 네오가 찾는 음악이 맞는지 확인
            if(isCorrect(newMusicS, calcS(m)) && t > maxT){
                maxT = t;
                result = title;
            }
            
        }
        
        return result;
        
    }
    
    private boolean isCorrect(String newS, String find){
    
        return newS.contains(find);
        
    }
    
    private String calcMusicS(int t, String musicS){
        //샵 변환
        musicS = calcS(musicS);
        
        int len = musicS.length();
        
        //재생된 길이가 악보의 길이보다 짧다면
        if(len >= t){
            return musicS.substring(0,t);
        }
        else{
            int p = t / len;
            int d = t % len;
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < p; i++){
                sb.append(musicS);
            }
            sb.append(musicS.substring(0,d));
            return sb.toString();
        }
        
    }
    
    private String calcS(String musicS){
        return musicS.replaceAll("C#","c")
            .replaceAll("D#","d")
            .replaceAll("E#","e")
            .replaceAll("F#","f")
            .replaceAll("G#","g")
            .replaceAll("A#","a")
            .replaceAll("B#","b");
    }
    
    private int calcT(String st, String en){
        
        String[] stStr = st.split(":");
        String[] enStr = en.split(":");
        
        int sth = Integer.parseInt(stStr[0]) * 60;
        int stm = Integer.parseInt(stStr[1]);
        
        int enh = Integer.parseInt(enStr[0]) * 60;
        int enm = Integer.parseInt(enStr[1]);
        
        return (enh + enm) - (sth + stm);
        
    }
}