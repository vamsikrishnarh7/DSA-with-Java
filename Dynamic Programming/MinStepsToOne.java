/**********************************************************************************

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. 
You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  

Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 
**********************************************************************************/

import java.util.Scanner;

public class MinStepsToOne {
  

    public static int stepsToOne(int n){
        int[] dp = new int[n];
        for (int i =0; i<n; i++){
            dp[i] = -1;
        }
        return stepsToOne(n,dp);
    }



    private static int stepsToOne(int n,int[] dp){
        if(n==1) return 0;
        int ans1,ans2 = Integer.MAX_VALUE,ans3 =Integer.MAX_VALUE;
        if(dp[n-1] == -1){
            ans1 = stepsToOne(n-1,dp);
            dp[n-1] = ans1;
        }else ans1 = dp[n-1];

        if(n%3 == 0){
            if(dp[n/3] == -1){
                ans2 = stepsToOne(n/3,dp);
                dp[n/3] = ans2;
            }else ans2 = dp[n/3];
        }
        if(n%2 == 0){
            if(dp[n/2] == -1){
                ans3 = stepsToOne(n/2,dp);
                dp[n/2] = ans3;
            }else ans3 = dp[n/2];
        }
        return Math.min(ans1,Math.min(ans2,ans3))+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(stepsToOne(n));
    }
}
