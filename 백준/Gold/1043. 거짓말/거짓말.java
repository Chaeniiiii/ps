import java.util.*;
import java.io.*;

public class Main {

    private static boolean[] visited;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //진실을 알고 있는 사람 
        boolean[] truth = new boolean[n+1];
        st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        if(people == 0){
            System.out.println(m);
            return;
        }

        while(people-- > 0){
            int person = Integer.parseInt(st.nextToken());
            truth[person] = true;
        }

        //그래프 초기화
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        //파티 정보 저장
        List<Integer>[] party = new ArrayList[m];
        for(int i = 0; i < m; i++){
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for(int j = 0; j < cnt; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < party[i].size(); j++){
                for(int k = 0; k < party[i].size(); k++){
                    if(i == k) continue;
                    int jNode = party[i].get(j);
                    int kNode = party[i].get(k);
                    graph[jNode].add(kNode);
                    graph[kNode].add(jNode);
                }
            }
        }

        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            if(!truth[i]) continue;
            bfs(i);
        }

        int result = 0;
        for(int i = 0; i < party.length; i++){
            boolean possible = true;
            for(int cnt = 0; cnt < party[i].size(); cnt++){
                if(visited[party[i].get(cnt)]){
                    possible = false;
                    break;
                }
            }
            if(possible) result++;
        }

        System.out.println(result);
        
    }

    private static void bfs(int start){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        visited[start] = true;

        while(!deque.isEmpty()){

            int now = deque.poll();

            for(int child : graph[now]){
                if(visited[child]) continue;
                visited[child] = true;
                deque.add(child);
            }

        }

    }
}
