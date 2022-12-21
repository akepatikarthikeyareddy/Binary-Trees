/*
Problem: Given A Binary Tree Print The Diamter Of That Tree.

Input:             1         
                /     \
              2         3
            /   \      /  \
          4       5  6      7
        
Output: The Diameter Of The Given Tree Is: 5
*/

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.print("The Diameter Of The Given Tree Is: " + Tree.diameter(root));
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

class Tree {
    static int max[] = {0};
    static int diameter(TreeNode root) {
        height(root);
        return max[0];
    }
    static int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        max[0] = Math.max(max[0], lh+rh+1);
        return 1 + Math.max(lh, rh);
    }
}

/*
Time Complexity: O(N)
Auxillary Space: O(N)
*/