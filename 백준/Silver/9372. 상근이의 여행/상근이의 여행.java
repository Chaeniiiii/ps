import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] parent;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            for(int i = 1; i<= n; i++){
                parent[i] = i;
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
            }

            System.out.println(n - 1);

        }
    }
}
