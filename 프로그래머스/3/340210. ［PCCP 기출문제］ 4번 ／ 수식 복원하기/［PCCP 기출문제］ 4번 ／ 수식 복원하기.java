import java.util.*;

class Solution {
    
    private static Set<Integer> candidate; // 가능한 진법 후보

    private static class Num {
        
        int a;
        int b;
        String sign;
        
        private Num(int a, int b, String sign){
            this.a = a;
            this.b = b;
            this.sign = sign;
        }
        
    }
    
    public String[] solution(String[] expressions) {
        
        candidate = new HashSet<>();
        ArrayList<Num> missing = new ArrayList<>();
        
        int maxDigit = 0;
        for(String ep : expressions){
            for(char ch : ep.toCharArray()){
                //모든 숫자는 선택된 진법으로 표현 가능해야 함 => 가장 큰 수 찾기
                if(Character.isDigit(ch)){
                    maxDigit = Math.max(maxDigit, ch - '0');
                }
            }
        }

        //진법 후보군 찾기
        for(int c = maxDigit+1; c <= 9; c++){
            candidate.add(c);
        }

        for(String ep : expressions){
            
            String[] str = ep.split(" ");
            
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[2]);
            String sign = str[1];
            
            if(str[4].equals("X")){
                missing.add(new Num(a,b,sign));
            } else {
                int c = Integer.parseInt(str[4]);
                filterCandidate(a,b,c,sign);
            }
        }

        //수식 복원
        String[] result = new String[missing.size()];
        
        for(int i = 0; i < missing.size(); i++){
            
            Num num = missing.get(i);
            Set<String> resSet = new HashSet<>();
            
            for(int cdd : candidate){
                
                int x = convert(num.a, cdd);
                int y = convert(num.b, cdd);
                if(x == -1 || y == -1) continue;
                
                int val = num.sign.equals("+") ? x + y : x - y;
                resSet.add(toBase(val, cdd));
                
            }
            
            String valStr;
            if(resSet.size() == 1) valStr = resSet.iterator().next();
            else valStr = "?";
            
            result[i] = num.a + " " + num.sign + " " + num.b + " = " + valStr;
            
        }
        
        return result;
    }
    
    //진법 후보 중 가능한 진법 선별 
    private static void filterCandidate(int a, int b, int c, String sign){
        
        Set<Integer> set = new HashSet<>();
        
        for(int cdd : candidate){
            
            int x = convert(a, cdd);
            int y = convert(b, cdd);
            int z = convert(c, cdd);
            
            if(x == -1 || y == -1 || z == -1) continue;
            
            int res = sign.equals("+") ? x + y : x - y;
            if(res == z) set.add(cdd);
            
        }
        
        candidate.retainAll(set);
        
    }
    
    private static int convert(int num, int cdd){
        
        int res = 0;
        String s = String.valueOf(num);
        
        for(char c : s.toCharArray()){
            int n = c - '0';
            if(n >= cdd) return -1; 
            res = res * cdd + n;
        }
        
        return res;
        
    }
    
    private static String toBase(int num, int base){
        
        if(num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            sb.append(num % base);
            num /= base;
        }
        
        return sb.reverse().toString();
        
    }
}
