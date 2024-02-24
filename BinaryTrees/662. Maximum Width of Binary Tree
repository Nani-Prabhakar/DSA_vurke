class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(1,root));
        int maxWidth=1;
        while(!q.isEmpty()){
            int size=q.size(),left=0,right=0;
            for(int i=1;i<=size;i++){
                Pair cur=q.poll();
                int serial=cur.num;
                TreeNode curNode=cur.node;
                if(curNode.left!=null){
                    q.add(new Pair(2*serial,curNode.left));
                }
                 if(curNode.right!=null){
                    q.add(new Pair(2*serial+1,curNode.right));
                }
                if(i==size){
                    right=serial;
                }
                if(i==1){
                     left=serial;
                }

            }
            maxWidth=Math.max(maxWidth,(right-left)+1);
        }
        return maxWidth;
    }
}
