/*
Problem: Given A Binary Tree Print The Height Of The Binary Tree.

Input:             1
                /     \
              2         3
            /   \      /  \
          4       5  6      7

Output: The Height Of The Given Binary Tree Is: 3
*/

public class HeightOfTheBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.print("The Height Of The Given Binary Tree Is: " + Tree.height(root));
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
    static int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

/*
Time Complexity: O(N)
Auxillary Space: O(N)
*/