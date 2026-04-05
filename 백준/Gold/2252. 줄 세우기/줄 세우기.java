import java.util.*;
import java.io.*;

public class Main {

    private static Map<Integer,ArrayList<Integer>> map;
    private static int[] cnt;
    private static boolean[] visited;

    private static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            map.put(i,new ArrayList<>());
        }

        cnt = new int[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            cnt[b]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            if(cnt[i] == 0) deque.add(i);
        }

        visited = new boolean[n+1];
        bfs(deque);
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]) sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
        
    }

    private static void bfs(Deque<Integer> deque){

        sb = new StringBuilder();

        while (!deque.isEmpty()) {
            
            int now = deque.poll();
            visited[now] = true;
            sb.append(now).append(" ");

            for(int child : map.get(now)){
                cnt[child]--;
                if(cnt[child] == 0){
                    deque.add(child);
                }
            }

        }

    }

}
