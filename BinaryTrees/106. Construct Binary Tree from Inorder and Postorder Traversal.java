class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=createTree(postorder,postorder.length-1,0,inorder,0,inorder.length-1,map);

        return root;
        
    }
     public TreeNode createTree(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
        if(postStart<postEnd || inStart>inEnd)return null;
        TreeNode root=new TreeNode(postorder[postStart]);

        int inRoot=map.get(root.val);
        int numsRight=inEnd-inRoot;

        root.left=createTree(postorder,postStart-numsRight-1,postEnd,inorder,inStart,inRoot-1,map);
        root.right=createTree(postorder,postStart-1,postStart-numsRight,inorder,inRoot+1,inEnd,map);

        return root;

    }
}
