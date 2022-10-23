
/****************************************************************************
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. 
You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - 1) ,
2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).
****************************************************************************/
public class MinStepsToOne{
    public static int stepsToOneIte(int n){
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i =2; i<=n; i++){
            dp[i] = -1;
        }
        int ans1,ans2 = Integer.MAX_VALUE,ans3 = Integer.MAX_VALUE;
        for(int i =2; i<=n; i++){
            ans2 = ans3 = Integer.MAX_VALUE;
            //step1
            ans1 = dp[i-1];
            //step2
            if(i%2==0){
                ans2 = dp[i/2];
            }
            //step3
            if(i%3 == 0){
                ans3 = dp[i/3];
            }
            dp[i] = Math.min(ans1,Math.min(ans2,ans3))+1;
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n+" can be reduced to 1 in "+MinStepsToOne(n))+" steps");
    }
}
