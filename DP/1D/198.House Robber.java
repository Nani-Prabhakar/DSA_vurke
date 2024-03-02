# Memoiztion-------->

class Solution {
    public int maxRob(int i,int[] nums,int[] dp){
        if(i<=1)return nums[i];
        if(dp[i]!=-1)return dp[i];
        int fir=Integer.MIN_VALUE,sec=Integer.MIN_VALUE;
        if(i>=2){
            fir=nums[i]+maxRob(i-2,nums,dp);
        }
        if(i>=3) {
           sec=nums[i]+maxRob(i-3,nums,dp);
        }
        dp[i]=Math.max(fir,sec);
        return dp[i];

    }
    public int rob(int[] nums) {
        
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int left=maxRob(nums.length-1,nums,dp);
        int right=maxRob(nums.length-2,nums,dp);;
        return Math.max(left,right);
    }
}

# Space Optimization------->
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev2=0,prev=nums[0];
        for(int i=1;i<n;i++){
            int take=nums[i];
            if(i>1)take+=prev2;
            int notTake=prev;
            int cur=Math.max(take,notTake);
            prev2=prev;
            prev=cur;
        }
        return prev;
   
    }
}
