/***********************************************************************************
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. 
The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)

B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)

C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
***********************************************************************************/

import java.util.Scanner;

public class MinNoSquares {

    public static int minCount(int n, int[] dp){
        if(n == 0) return 0;
        int ans,min = Integer.MAX_VALUE;
        for (int i =1;i*i<=n;i++){
            if(dp[n-(i*i)] == -1){
                ans = minCount(n-(i*i),dp);
                dp[n-i*i] = ans;
            }else ans = dp[n-i*i];
            min = Math.min(ans,min);
        }
        return min+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for (int i =0; i<=n ; i++){
            dp[i] = -1;
        }
        System.out.println(minCount(n,dp));
    }
}
