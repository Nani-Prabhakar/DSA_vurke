class Solution {
    public void markParent(TreeNode root,Map<TreeNode,TreeNode> parents){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    parents.put(node.left,node);
                    q.offer(node.left);
                }
                 if(node.right!=null){
                    parents.put(node.right,node);
                    q.offer(node.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parents=new HashMap<>();
        markParent(root,parents);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target,true);
        int dis=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(dis==k)break;
            dis++;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null && visited.get(cur.left)==null){
                    visited.put(cur.left,true);
                    q.offer(cur.left);
                }
                 if(cur.right!=null && visited.get(cur.right)==null){
                    visited.put(cur.right,true);
                    q.offer(cur.right);
                }
                if(parents.get(cur)!=null && visited.get(parents.get(cur))==null){
                    visited.put(parents.get(cur),true);
                    q.offer(parents.get(cur));
                }

            }

        }
        List<Integer> ans=new ArrayList<Integer>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
        
    }
}
