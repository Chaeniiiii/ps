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

            color = new int[n+1];
            String result = "YES";
            for(int i = 1; i <= n; i++){
                if(color[i] != 0) continue;
                if(!bfs(n, i, graph)){
                    result = "NO";
                    break;
                }
            }

            System.out.println(result);
            
        }

    }

    private static boolean bfs(int n, int st, ArrayList<Integer>[] graph){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(st);

        color[st] = 1;

        while(!deque.isEmpty()){

            int now = deque.poll();

            for(int child : graph[now]){
                if(color[child] == color[now]) return false;
                if(color[child] != 0) continue;
                color[child] = color[now] * -1;
                deque.add(child);
            }

        }

        return true;

    }

}
