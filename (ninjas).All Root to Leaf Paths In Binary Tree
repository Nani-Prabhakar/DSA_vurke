import java.util.List;
import java.util.ArrayList;
public class Solution{

 public static void path(BinaryTreeNode root, List<String> list, String str) {
        if (root == null) {
            return;
        }

        str=str+ " " +root.data;

        if (root.left == null && root.right == null) {
            // Leaf node, add the path to the list
            list.add(str.trim());
            return;
        }

       if(root.left!=null){
             path(root.left, list, str);

       }
       if(root.right!=null){
                   path(root.right, list, str);

       }
    }
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> list=new ArrayList<String>();
        path(root,list,"");
        return list;
        
    }
}
