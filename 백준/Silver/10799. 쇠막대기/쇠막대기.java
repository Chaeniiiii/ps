import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String laser = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();

        char prev = ' ';
        int cnt = 0;
        for(int i = 0; i<laser.length(); i++){

            char now = laser.charAt(i);

            if(now == '('){
                deque.add(now);
            }
            else {
                deque.pollLast();
                if(prev == '(') cnt += deque.size();
                else cnt++;
            }
            prev = now;

        }
        
        System.out.println(cnt);

    }

}