class Solution {
      public int leftHeight(TreeNode root){
        int count=0;
        while(root!=null && root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    public int rightHeight(TreeNode root){
        int count=0;
        while(root!=null && root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        if(root==null)return 0;

        int left=leftHeight(root);
        int right=rightHeight(root);

        if(left==right)return ((2<<left)-1);

        return countNodes(root.left)+countNodes(root.right)+1;
    }
  
}
