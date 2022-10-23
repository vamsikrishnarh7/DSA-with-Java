/*******************************************************************************
A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. 
Implementing a method to count and return all possible ways in which the child can run-up to the stairs.
********************************************************************************/

import java.util.Scanner;

public class StairCase {

    public static long staircase(int n) {
        //Your code goes here
        long[] dp = new long[n+1];
        for(int i =0; i<n+1; i++){
            dp[i] = -1;
        }
        return staircase(n,dp,0);
    }
    private static long staircase(int n, long[] dp,int i){
        if(i == n) return 1;
        if(i > n) return 0;
        long single_step =0,double_step =0,triple_step=0;
        //single step
        if(i+1 < dp.length){
            if(dp[i+1] == -1){
                single_step = staircase(n,dp,i+1);
                dp[i+1] = single_step;
            }
            else single_step = dp[i+1];
        }
        //double step
        if(i+2 < dp.length){
            if(dp[i+2] == -1){
                double_step = staircase(n,dp,i+2);
                dp[i+2] = double_step;
            }else double_step = dp[i+2];
        }


        //triple steps
        if(i+3 < dp.length ){
            if(dp[i+3] == -1){
                triple_step = staircase(n,dp,i+3);
                dp[i+3] = triple_step;
            }else triple_step = dp[i+3];
        }


        return single_step + double_step + triple_step;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(staircase(n));
    }
}
