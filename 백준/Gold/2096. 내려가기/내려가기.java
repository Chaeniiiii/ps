import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] minR = new int[3];
        int[] maxR = new int[3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int c3 = Integer.parseInt(st.nextToken());

            int min1 = minR[0] , min2 = minR[1], min3 = minR[2];
            int max1 = maxR[0] , max2 = maxR[1], max3 = maxR[2];

            for(int j = 0; j < 3; j++){
                
                if(i == 0){
                    minR[0] = maxR[0] = c1;
                    minR[1] = maxR[1] = c2;
                    minR[2] = maxR[2] = c3;
                }
                else{
                        minR[0] = c1 + Math.min(min1,min2);
                        maxR[0] = c1 + Math.max(max1,max2);

                        minR[1] = c2 + Math.min(min3,Math.min(min1,min2));
                        maxR[1] = c2 + Math.max(max3,Math.max(max1,max2));

                        minR[2] = c3 + Math.min(min3,min2);
                        maxR[2] = c3 + Math.max(max3,max2);
                }
            }
        }

        int minResult = Math.min(minR[0], Math.min(minR[1],minR[2]));
        int maxResult = Math.max(maxR[0], Math.max(maxR[1],maxR[2]));

        System.out.printf("%d %d ",maxResult,minResult);

    }

}