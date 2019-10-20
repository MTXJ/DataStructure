package DFS;

import java.util.ArrayList;

class maxDepthTree{
    class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode(Integer x){ val=x;}

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
    public void showTree(TreeNode tree){
        if(tree==null){
            return;
        }
        System.out.println(tree.val);
        showTree(tree.left);
        showTree(tree.right);
    }
    public TreeNode build_Tree(ArrayList<Integer> data,int father){
        if(father>=data.size()){
            return null;
        }
        if(data.get(father)==null){
            return new TreeNode(null);
        }
        Integer left_child=father*2+1;
        Integer right_child=father*2+2;
        TreeNode Ftree=new TreeNode(data.get(father));
        Ftree.setLeft(build_Tree(data,left_child));
        Ftree.setRight(build_Tree(data,right_child));
        return Ftree;

    }
    public int maxDepth(TreeNode root){
        if(root==null||root.val==null){
            return 0;
        }
        return maxDepth(root.left)>maxDepth(root.right)?maxDepth(root.left)+1:maxDepth(root.right)+1;

    }
}
public class Main {
    public static TreeNode getTree(){
        TreeNode tree=new TreeNode(5);
        tree.left=new TreeNode(4);
        tree.left.right=new TreeNode(11);
        tree.left.right.left=new TreeNode(7);
        tree.left.right.right=new TreeNode(2);
        tree.right=new TreeNode(8);
        tree.right.left=new TreeNode(13);
        tree.right.right=new TreeNode(4);
        tree.right.right.right=new TreeNode(1);
        return tree;
    }
    public static boolean hasPath(TreeNode tree,int sum){
        if(tree==null){
            return false;
        }
        if(tree.right==null&&tree.left==null){
            return sum-tree.val==0;
        }
  //      sum=sum-tree.val;
        return hasPath(tree.left,sum-tree.val)||hasPath(tree.right, sum-tree.val);

    }
    public static void main(String[] args) {
        TreeNode tree=getTree();
        System.out.println(hasPath(tree,22));
    }


}
