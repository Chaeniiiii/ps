import java.util.*;
import java.io.*;

public class Main{

    public static void main(String [] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(isPrime(i)) arr.add(i);
        }

        int lt = 0, rt = lt , cnt = 0, result = 0;

        while(lt <= rt){

            if(rt >= arr.size()) break;
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

    private static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}