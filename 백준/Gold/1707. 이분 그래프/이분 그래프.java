import java.util.*;
import java.io.*;

public class Main {

    private static int[] color;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(t-- > 0){

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for(int i = 1; i <= n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());

                graph[v].add(u);
                graph[u].add(v);
            }

            String result = "YES";
            color = new int[n+1];

            for(int i = 1; i <= n; i++){
                if(color[i] != 0) continue;
                if(!bfs(i, graph)){
                    result = "NO";
                    break;
                }
            }
          
            System.out.println(result);
            
        }

    }

    private static boolean bfs(int start, ArrayList<Integer>[] graph){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        color[start] = 1;

        while (!deque.isEmpty()) {
            
            int now = deque.poll();

            for(int nxt : graph[now]){
                if(color[nxt] == color[now]) return false;
                if(color[nxt] != 0) continue;
                color[nxt] = color[now] * -1;
                deque.add(nxt);
            }

        }

        return true;

    }


}
