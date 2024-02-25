public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        StringBuilder res=new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                res.append("Sri,");
                continue;
            }
            res.append(node.val+",");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        Queue<TreeNode> q=new LinkedList<>();
        String[] ans=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(ans[0]));
        q.add(root);
        for(int i=1;i<ans.length;i++){
            TreeNode parent=q.poll();
            if(!ans[i].equals("Sri")){
                TreeNode left=new TreeNode(Integer.parseInt(ans[i]));
                parent.left=left;
                q.add(left);
            }
            if( (i+1)<ans.length && !ans[++i].equals("Sri")){
                TreeNode right=new TreeNode(Integer.parseInt(ans[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }
}
