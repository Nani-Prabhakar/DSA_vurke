import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class Solution
{
public static int findTime(HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> map,BinaryTreeNode<Integer> target){
	HashMap<BinaryTreeNode<Integer>,Integer> vis=new HashMap<>();
	Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
	q.offer(target);
	vis.put(target,1);
	int maxi=0;
	while(!q.isEmpty()){
			int size=q.size();
			int fl=0;
			for(int i=0;i<size;i++){
				BinaryTreeNode<Integer> node=q.poll();
				if(node.left!=null && vis.get(node.left)==null){
					fl=1;
					vis.put(node.left,1);
					q.offer(node.left);
				}
				if(node.right!=null && vis.get(node.right)==null){
					fl=1;
					vis.put(node.right,1);
					q.offer(node.right);
				}
				if(map.get(node)!=null && vis.get(map.get(node))==null){
					fl=1;
					vis.put(map.get(node),1);
					q.offer(map.get(node));
				}
				
			}
			if(fl==1)maxi++;
	}
	return maxi;
}
public static BinaryTreeNode<Integer> parentsMap(BinaryTreeNode<Integer> root,HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> map,int start){
	BinaryTreeNode<Integer> res=new BinaryTreeNode<Integer>(-1);
	Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
	q.offer(root);
	while(!q.isEmpty()){
		BinaryTreeNode<Integer> node=q.poll();
		if(node.data==start)res=node;
		if(node.left!=null){
			map.put(node.left,node);
			q.offer(node.left);
		}
		if(node.right!=null){
			map.put(node.right,node);
			q.offer(node.right);
		}
	}
	return res;
}
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
		HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> map=new HashMap<>();
		BinaryTreeNode<Integer> target=parentsMap(root,map,start);
		int maxi=findTime(map,target);
		return maxi;

    }
}
