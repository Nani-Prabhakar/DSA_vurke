class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<k)q.add(nums[i]);
        }
        int count=0;
        while(q.size()>1 && !q.isEmpty()){
            int fir=q.poll();
            int sec=q.poll();
            long num=(fir*2);
            if(num<k)num+=sec;
            if(num<k){
                int ans=(int)num;
                q.add(ans);
            }
            ++count;
        }
        if(!q.isEmpty())count++;
        return count;
        
    }
}
