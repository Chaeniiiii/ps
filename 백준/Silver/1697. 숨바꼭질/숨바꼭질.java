import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int MAX = 100_000;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(n);

        boolean[] visited = new boolean[MAX+1];
        visited[n] = true;

        int cnt = 0;
        while(!deque.isEmpty()){

            int size = deque.size();

            for(int i = 0; i < size; i++){

                int now = deque.poll();
                if(now == k){
                    System.out.println(cnt);
                    return;
                }

                for(int nxt : new int[] {now+1, now-1,now*2}){
                    if(nxt < 0 || nxt > MAX || visited[nxt]) continue;
                    visited[nxt] = true;
                    deque.add(nxt);
                }

            }

            cnt++;

        }

    }

}
