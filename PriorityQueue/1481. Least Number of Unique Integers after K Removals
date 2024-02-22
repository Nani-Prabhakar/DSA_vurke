class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        PriorityQueue<Integer> q=new PriorityQueue<>(map.values());
        while(k>0){
                k=k-q.poll();
        }
    return k<0?q.size()+1:q.size();    
    }
}
