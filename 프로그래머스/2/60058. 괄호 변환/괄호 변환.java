class Solution {

    private static class Parentheses {
        String u, v;
        boolean correct;

        Parentheses(String u, String v, boolean correct) {
            this.u = u;
            this.v = v;
            this.correct = correct;
        }
    }

    public String solution(String p) {
        
        if (p.isEmpty()) return "";

        Parentheses pt = divP(p);

        if (pt.correct) {
            return pt.u + solution(pt.v);
        } else {
            return makeCorrect(pt);
        }
        
    }

    private String makeCorrect(Parentheses pt) {
        
        StringBuilder sb = new StringBuilder();

        sb.append("(");
        sb.append(solution(pt.v));
        sb.append(")");

        String u = pt.u.substring(1, pt.u.length() - 1);
        for (char c : u.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }

        return sb.toString();
        
    }

    private Parentheses divP(String p) {
        
        int balance = 0;
        boolean correct = true;

        for (int i = 0; i < p.length(); i++) {
            
            char c = p.charAt(i);
            
            balance += (c == '(') ? 1 : -1;

            if (balance < 0) correct = false;

            if (balance == 0) {
                String u = p.substring(0, i + 1);
                String v = p.substring(i + 1);
                return new Parentheses(u, v, correct);
            }
            
        }
        
        return null;
        
    }
}
