import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, cnt;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[v].add(u);
            graph[u].add(v);
        }

        cnt = 0;
        visited = new boolean[n+1];
        System.out.println(bfs(1,graph));

    }   
    
    private static int bfs(int start, List<Integer>[] graph){

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{start,0});
        visited[start] = true;
                
        int cnt = 0;
        while(!deque.isEmpty()){

            int[] now = deque.poll();
            if(now[1] == 2) continue; 

            for(int child : graph[now[0]]){
                if(visited[child]) continue;
                deque.add(new int[]{child,now[1]+1});
                visited[child] = true;
                cnt++;
            }

        }

        return cnt;

    }
    
}
