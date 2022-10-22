/*
this program demonstrates dynamic programming using Nth fibonacci as an example
*/

import java.util.Scanner;

public class Fibonacci {
    /* the below function is implemented using recusrion        
    public static int fibUsingRecursion(int n){
         if(n==0 || n==1) return n;
          return fibUsingRecursion(n-1)+fibUsingRecursion(n-2);
      }
    */
    
    //finding Nth fibonacci number using Dynamic Programming
    public static int fibUsingDP(int n, int[] dp){
        if(n==0 || n==1) return n;
        int fib1,fib2;
        if(dp[n-1] == -1){
            fib1 = fibUsingDP(n-1,dp);
            dp[n-1] = fib1;
        }else fib1 = dp[n-1];
        if(dp[n-2] == -1){
            fib2 = fibUsingDP(n-2,dp);
            dp[n-2] = fib2;
        }else fib2 = dp[n-2];

        return fib1+fib2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Nth fibonacci
        int n;
        System.out.println("Enter n value : ");
        n = sc.nextInt();
        //System.out.println(n+"th fibonacci number is : " + fibUsingRecursion(n));
        
        //creating an array for memoization
        int[] dp = new int[n+1];
        for (int i =0 ; i<n+1;i++){
            dp[i] = -1;
        }
        System.out.println(fibUsingDP(n,dp));
    }
}
