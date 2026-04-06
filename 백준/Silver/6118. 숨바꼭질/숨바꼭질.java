import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n+1];
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

        int[] dist = dijkstra(n, 1, graph);

        int num = 0; //헛간 번호
        int d = 0; //헛간까지의 거리
        int cnt = 0; //같은 거리를 갖는 헛간의 개수

        for(int i = 1; i <= n; i++){
            if(d < dist[i]){
                cnt = 1;
                d = dist[i];
                num = i;
            }
            else if(d == dist[i]){
                cnt++;
            }
        }

        System.out.printf("%d %d %d\n",num,d,cnt);

    }

    private static int[] dijkstra(int n, int start, List<Integer>[] graph){

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{start,0});
        dist[start] = 0;

        while(!pq.isEmpty()){

            int[] now = pq.poll();

            for(int next : graph[now[0]]){
                if(dist[next] > now[1] + 1){
                    dist[next] = now[1] + 1;
                    pq.add(new int[]{next,dist[next]});
                }
            }

        }

        return dist;

    }

}
