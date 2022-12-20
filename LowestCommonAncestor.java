/*
Problem: Given A Binary And Two Numbers Print The Lowest Common Ancestor Of Those Numbers.

Input:             1         
                /     \
              2         3
            /   \      /  \
          4       5  6      7
        Two Nodes: n1 = 5, n2 = 7
        
Output: The Lowest Common Ancestor For 5 & 7 Is: 1
*/

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int n1 = 5, n2 = 7;
        System.out.print("The Lowest Common Ancestor For " + n1 + " & " + n2 + " Is: " + Tree.lca(root, 5, 7).data);
    }
}

class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int data){
        this.data = data;
    }
}

class Tree{
    static TreeNode lca(TreeNode root, int n1,int n2) {
	    if(root == null || root.data == n1 || root.data == n2) return root;
	    TreeNode left = lca(root.left, n1, n2);
	    TreeNode right = lca(root.right, n1, n2);
	    if(left == null) return right;
	    else if(right == null) return left;
	    else return root;
	}
}

/*
Time Complexity: O(N)
Auxillary Space: O(N)
*/