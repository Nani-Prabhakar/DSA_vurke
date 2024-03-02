class Solution {
   
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int prev2=0,prev=nums[0];
        for(int i=1;i<n-1;i++){
            int take=nums[i];
            if(i>1)take+=prev2;
            int notTake=prev;
            int cur=Math.max(take,notTake);
            prev2=prev;
            prev=cur;
        }

        int prev21=0,prev1=nums[1];
        for(int i=2;i<n;i++){
            int take=nums[i];
            if(i>2)take+=prev21;
            int notTake=prev1;
            int cur=Math.max(take,notTake);
            prev21=prev1;
            prev1=cur;
        }
        return Math.max(prev,prev1);

    }
}
