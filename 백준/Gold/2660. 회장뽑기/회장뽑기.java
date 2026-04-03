import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) graph[i][j] = 1;
                else graph[i][j] = 50 * 50;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){

            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            if(v == -1) break;

            graph[v][u] = 1;
            graph[u][v] = 1;

            st = new StringTokenizer(br.readLine());

        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int[] maxScore = new int[n+1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                maxScore[i] = Math.max(maxScore[i],graph[i][j]);
            }
            min = Math.min(min,maxScore[i]);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(min == maxScore[i]) arr.add(i);
        }

        System.out.printf("%d %d\n",min,arr.size());
        for(int ele : arr){
            System.out.printf("%d ",ele);
        }
    }
}
