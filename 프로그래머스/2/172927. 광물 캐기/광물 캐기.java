import java.util.*;

class Solution {
    
    private static class NeedPick{
        
        int dia;
        int iron;
        int stone;
        
        private NeedPick(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
            
    }
    
    public int solution(int[] picks, String[] minerals) {
        
        int pickAll = Arrays.stream(picks).sum();
        int mineralCnt = (minerals.length / 5) + (minerals.length % 5 > 0 ? 1 : 0); 
        
        ArrayList<NeedPick> arr = new ArrayList<>();
        
        for(int i = 0; i < Math.min(pickAll,mineralCnt); i++){
            
            int st = i * 5;
            int dia = 0, stone = 0, iron = 0;
            for(int j = st; j < Math.min(minerals.length,st + 5); j++){
                String str = minerals[j];
                switch(str){
                    case "diamond":
                        dia+=1;
                        iron+=5;
                        stone+=25;
                        break;
                    case "iron":
                        dia+=1;
                        iron+=1;
                        stone+=5;
                        break;
                    case "stone":
                        dia+=1;
                        iron+=1;
                        stone+=1;
                        break;
                        
                }
            }
            arr.add(new NeedPick(dia,iron,stone));
        }
        
        arr.sort((a,b) -> {
            if(b.stone == a.stone){
                if(b.iron == a.iron){
                    return b.dia - a.dia;
                }
                return b.iron - a.iron;
            }
            return b.stone - a.stone;
        });
        
        int result = 0;
        for(int i = 0; i < arr.size();){
            while(picks[0] > 0){
                if(i == arr.size()) return result;
                result += arr.get(i).dia;
                i++;
                picks[0]--;
            }
            while(picks[1] > 0){
                if(i == arr.size()) return result;
                result += arr.get(i).iron;
                i++;
                picks[1]--;
            }
            while(picks[2] > 0){
                if(i == arr.size()) return result;
                result += arr.get(i).stone;
                i++;
                picks[2]--;
            }
            return result;
        }
        return result;
    }
    
}