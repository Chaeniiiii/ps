import java.util.*;
import java.io.*;

public class Main {

    private static int computerCnt, n;

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerCnt = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[computerCnt+1];
        for(int i = 1; i <= computerCnt; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[v].add(u);
            graph[u].add(v);
        }

        System.out.println(bfs(1,graph));

    }

    private static int bfs(int start, List<Integer>[] graph){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        boolean[] visited = new boolean[computerCnt+1];
        visited[start] = true;

        int cnt = 0;
        while(!deque.isEmpty()){

            int now = deque.poll();

            for(int child : graph[now]){
                if(visited[child]) continue;
                cnt++;
                visited[child] = true;
                deque.add(child);
            }

        }

        return cnt;

    }

}
