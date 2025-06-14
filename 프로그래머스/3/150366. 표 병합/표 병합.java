import java.util.*;

class Solution {
    
    private static final int MAX = 2500;
    
    private static int[] parent;
    private static String[] values;
    
    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return;
        parent[y] = x;
    }
    
    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public String[] solution(String[] commands) {
    
        parent = new int[MAX];
        values = new String[MAX];

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < MAX; i++){
            parent[i] = i;
        }
        
        for(String str : commands){
            
            String[] cmd = str.split(" ");
            
            switch(cmd[0]){
                
                case "UPDATE" : 
                    if(cmd.length == 4){
                        int r = Integer.parseInt(cmd[1])-1;
                        int c = Integer.parseInt(cmd[2])-1; 
                        values[find(r * 50 + c)] = cmd[3];
                    } else {
                        for(int j = 0; j < MAX; j++){
                            int root = find(j);
                            if(values[root] != null && values[root].equals(cmd[1])){
                                values[root] = cmd[2];
                            }
                        }
                    }
                    break;
                    
                case "MERGE" : 
                    int r1 = Integer.parseInt(cmd[1]) - 1;
                    int c1 = Integer.parseInt(cmd[2]) - 1;
                    int r2 = Integer.parseInt(cmd[3]) - 1;
                    int c2 = Integer.parseInt(cmd[4]) - 1;
                    
                    int num1 = r1 * 50 + c1;
                    int num2 = r2 * 50 + c2;
                    
                    int root1 = find(num1);
                    int root2 = find(num2);
                    
                    if(root1 == root2) break;
                    
                    // 값이 있는 쪽을 대표로
                    if(values[root1] == null && values[root2] != null){
                        int temp = root1;
                        root1 = root2;
                        root2 = temp;
                    }
                    
                    union(root1, root2);
                    break;
                    
                case "UNMERGE" : 
                    int r = Integer.parseInt(cmd[1]) - 1;
                    int c = Integer.parseInt(cmd[2]) - 1;
                    
                    int num = r * 50 + c;
                    int root = find(num);
                    String value = values[root];
                    
                    // 모든 셀 경로 압축 수행
                    for(int j = 0; j < MAX; j++){
                        find(j);
                    }
                    
                    for(int j = 0; j < MAX; j++){
                        if(find(j) == root){
                            parent[j] = j;
                            values[j] = null;
                        }
                    }
                    values[num] = value;
                    break;
                    
                case "PRINT":
                    int pr = Integer.parseInt(cmd[1]) - 1;
                    int pc = Integer.parseInt(cmd[2]) - 1;
                    
                    int idx = find(pr * 50 + pc);
                    String cellValue = values[idx];
                    sb.append(cellValue == null ? "EMPTY" : cellValue).append(" ");
                    break;
            }
        }
        
        return sb.toString().trim().split(" ");
    }
}
