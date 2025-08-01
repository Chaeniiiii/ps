import java.util.*;
import java.io.*;

public class Main{

    private static ArrayList<Integer> arr;
    public static void main(String [] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        isPrime(n);

        int lt = 0, rt = lt , cnt = 0, result = 0;

        while(rt < arr.size()){

            cnt += arr.get(rt);

            if(cnt >= n){
                if(cnt == n) result++;
                lt ++;
                rt = lt;
                cnt = 0;
            }
            else rt ++;

        }

        System.out.println(result);
        
    }

    private static void isPrime(int n){
        
        boolean[] visited = new boolean[n+1];
        
        for(int i = 2; i <= n; i++){
            if(visited[i]) continue;
            arr.add(i);
            for(int j = i * 2; j <= n; j+=i){
                visited[j] = true;
            }
        }
    }
}