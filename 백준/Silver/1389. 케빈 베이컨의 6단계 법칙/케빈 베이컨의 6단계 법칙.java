import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 100 * 100;
            }
        }

        while(m-- > 0){

            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[v][u] = graph[u][v] = 1;

        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int[] minScore = new int[n+1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                minScore[i] += graph[i][j];
            }
            min = Math.min(min,minScore[i]);
        }

        for(int i = 1; i <= n; i++){
            if(min == minScore[i]){
                System.out.println(i);
                return;
            }
        }

    }
}
