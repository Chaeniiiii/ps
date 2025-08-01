import java.util.*;
import java.io.*;

public class Main{

    private static ArrayList<Integer> arr;

    public static void main(String [] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        getPrime(n);

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

    private static void getPrime(int n){

        for(int num = 2; num <= n ; num++){
            if(isPrime(num)) arr.add(num);
        }

    }

    private static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}