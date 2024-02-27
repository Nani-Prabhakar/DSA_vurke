class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp=root;
        TreeNode prev=root;
        TreeNode add=new TreeNode(val);
        if(root==null)return add;
        while(root!=null){
            if(root.val>val){
                prev=root;
                root=root.left;
                if(root==null){
                    prev.left=add;
                    break;
                }
            }
            else{
                prev=root;
                root=root.right;
                 if(root==null){
                    prev.right=add;
                    break;
                }
            }
        }
        return temp;
        
    }
}
