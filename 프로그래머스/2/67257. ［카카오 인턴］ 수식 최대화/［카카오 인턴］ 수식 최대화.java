import java.util.*;

class Solution {
    
    private ArrayList<Character> optType;
    
    private ArrayList<Character> opt;
    private ArrayList<Long> num;
    
    private boolean[] visited;
    
    private long result;
    
    public long solution(String expression) {
        
        result = 0;
        Set<Character> optSet = new HashSet<>();
        
        opt = new ArrayList<>();
        num = new ArrayList<>();
        
        //1. 연산자랑 숫자 각각 뽑기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                sb.append(c);
                if(i == expression.length() - 1) num.add(Long.parseLong(sb.toString()));
            }
            else{
                optSet.add(c);
                opt.add(c);
                num.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }
        }

        optType = new ArrayList<>(optSet);
        visited = new boolean[optType.size()];
        //2.연산자 조합 생성
        dfs(0,new ArrayList<>());
        
        return result;
        
    }
    
    private void dfs(int dep, ArrayList<Character> arr){
        
        if(dep == optType.size()){
            //3. 조합에 따라 수식 계산
            result = Math.max(result,Math.abs(calc(arr)));
            return;
        }
        
        for(int i = 0; i < optType.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr.add(optType.get(i));
            dfs(dep+1,arr);
            arr.remove(arr.size() - 1);
            visited[i] = false;
        }
        
    }
    
    private long calc(ArrayList<Character> arr){
        
        ArrayList<Character> newOpt = new ArrayList<>(opt);
        ArrayList<Long> newNum = new ArrayList<>(num);

        int size = newOpt.size();
        int idx = 0;
        
        while(idx < arr.size()){
        
            char c = arr.get(idx);
            for(int i = 0; i < size; i++){
                if(newOpt.get(i) == c){
                    newOpt.remove(i);
                    long a = newNum.get(i);
                    long b = newNum.get(i+1);
                    long number = 0;
                    switch(c){
                        case '+':
                            number = a + b;
                            break;
                        case '-':
                            number = a - b;
                            break;
                        case '*':
                            number = a * b;
                            break;
                        default:
                            break;
                    }
                    newNum.remove(i+1);
                    newNum.set(i,number);
                    
                    i--;
                    
                }
                size = newOpt.size();
            }
            idx++;
        }
        
        return newNum.get(0);
        
    }
    
}