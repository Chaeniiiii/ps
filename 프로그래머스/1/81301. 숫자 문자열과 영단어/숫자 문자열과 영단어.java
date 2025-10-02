import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = init();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { 
                result.append(c);
            } else { 
                sb.append(c);
                if (map.containsKey(sb.toString())) {
                    result.append(map.get(sb.toString()));
                    sb = new StringBuilder(); 
                }
            }
        }

        return Integer.parseInt(result.toString());
    }

    private static Map<String, Integer> init() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        return map;
    }
}
