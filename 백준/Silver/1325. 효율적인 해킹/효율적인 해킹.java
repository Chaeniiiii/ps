import java.util.*;
import java.io.*;

public class Main {
    
    private static int n;
    private static List<Integer>[] graph;

    private static class Node{
        int num;
        int cnt;

        private Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }

        boolean[] visited;
        int[] cnt = new int[n+1];
        for(int i = 1; i <= n; i++){
            visited = new boolean[n+1];
            cnt[i] = bfs(i, visited);
        }
        
        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr.add(new Node(i,cnt[i]));
        }

        arr.sort((a,b) -> {
            if(a.cnt == b.cnt) return a.num - b.num;
            return b.cnt - a.cnt;
        });

        StringBuilder sb = new StringBuilder();
        int maxCnt = arr.get(0).cnt;
        for(Node node : arr){
            if(node.cnt != maxCnt) break;
            sb.append(node.num).append(" ");
        }

        System.out.println(sb.toString());

    }

    private static int bfs(int start, boolean[] visited){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        visited[start] = true;
        int cnt = 1;

        while(!deque.isEmpty()){

            int now = deque.poll();

            for(int child : graph[now]){
                if(visited[child]) continue;
                visited[child] = true;

                deque.add(child);
                cnt++;
            }

        }

        return cnt;

    }

    
}