import java.io.*;
import java.util.*;

public class Main {

    private static int n,k,m;
    private static List<Integer>[] graph;
    private static List<Integer>[] tube;

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        tube = new ArrayList[n+m+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++){
            tube[n+i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int tb = n + i;
            
            for(int j = 0; j < k; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[num].add(tb);
                tube[tb].add(num);
            }

        }

        System.out.println(bfs());

    }

    private static int bfs(){

        int cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);

        boolean[] visitedNode = new boolean[n+1];
        visitedNode[1] = true;

        boolean[] visitedTube = new boolean[n+m+1];

        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i < size; i++){
                
                int now = deque.poll();
                if(now == n) return cnt + 1;

                for(int tb : graph[now]){
                    if(visitedTube[tb]) continue;
                    for(int child : tube[tb]){
                        if(visitedNode[child]) continue;
                        deque.add(child);
                        visitedNode[child] = true;
                    }
                    visitedTube[tb] = true;
                }

            }

            cnt++;

        }

        return -1;

    }

}