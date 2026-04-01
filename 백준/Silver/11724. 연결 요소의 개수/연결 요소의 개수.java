import java.util.*;
import java.io.*;


public class Main {
    
    private static ArrayList<Integer>[] graph;
    private static int[] parent;

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        parent = new int[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){

            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[v].add(u);
            graph[u].add(v);

            union(v,u);

        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            set.add(find(i));
        }

        System.out.println(set.size());

    }

    private static void union(int x, int y){

        x = find(x);
        y = find(y);

        if(x < y) parent[y] = x;
        else parent[x] = y;

    }

    private static int find(int x){

        if(parent[x] != x) return find(parent[x]);
        return x;
    }

}

