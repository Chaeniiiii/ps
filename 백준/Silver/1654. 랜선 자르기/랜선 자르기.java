import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] line = new int[n];
        for(int i = 0; i < n; i++){
            line[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(line);

        long cnt = 0; // 최대 길이 저장 변수
        long left = 1; // 랜선 길이의 최소값은 1
        long right = line[n-1]; // 랜선 길이의 최대값은 가장 긴 랜선

        while(left <= right){

            long mid = (left + right) / 2;
            
            long total = isTrue(n, k, mid, line);
            if(total >= k){
                cnt = mid; // 가능한 경우 중 최대 길이 저장
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(cnt);  
    }

    private static long isTrue(int n, int k, long mid, int[] line){

        long total = 0;
        for(int i = 0; i < n; i++){
            total += line[i] / mid;
        }

        return total;
    }
}
