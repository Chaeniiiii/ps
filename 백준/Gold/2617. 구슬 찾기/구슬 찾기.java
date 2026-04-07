import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[v][u] = 1;
            graph[u][v] = -1;

        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
                    else if(graph[i][k] == -1 && graph[k][j] == -1) graph[i][j] = -1;
                }
            }
        }

        int cnt = 0;
        int mid = n / 2;
        for(int i = 1; i <= n; i++){
            int hv = 0;
            int lg = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] == 1) lg++;
                else if(graph[i][j] == -1) hv++;
            }
            if(hv > mid || lg > mid) cnt++;
        }

        System.out.println(cnt);
        

    }
}
