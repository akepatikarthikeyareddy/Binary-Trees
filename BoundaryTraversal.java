/*
Problem: Given A Binary Tree Print The Boundary(Anti-Clock Wise) Traversal Of That Tree.

Input:             1         
                /     \
              2         3
            /   \      /  \
          4       5  6      7
		        /      \
		      8          9
        
Output: The Boundary Traversal Is: [1, 2, 4, 8, 9, 7, 3]
*/
import java.util.*;
class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(8);
		root.right.left.right = new TreeNode(9);
        System.out.print("The Boundary Traversal Is: " + Tree.boundaryTraversal(root));
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
    static ArrayList<Integer> ans = new ArrayList<>();
    static ArrayList<Integer> temp = new ArrayList<>();
    static ArrayList <Integer> boundaryTraversal(TreeNode root) {
        if(root == null) return ans;
	if(root.left != null || root.right != null) ans.add(root.data);
	leftBoundary(root.left);
	leafNodes(root);
	rightBoundary(root.right);
	Collections.reverse(temp);
	for(int i: temp) ans.add(i);
	return ans;
    }
    static void leftBoundary(TreeNode root){
        if(root == null) return;
	if(root.left == null && root.right == null) return;
	ans.add(root.data);
	if(root.left != null) leftBoundary(root.left);
	else leftBoundary(root.right);
    }
    static void leafNodes(TreeNode root){
	if(root == null) return;
	leafNodes(root.left);
	if(root.left == null && root.right == null){
	    ans.add(root.data);
	    return;
	}
	leafNodes(root.right);
    }
    static void rightBoundary(TreeNode root){
	if(root == null) return;
	if(root.left == null && root.right == null) return;
	temp.add(root.data);
	if(root.right != null) rightBoundary(root.right);
	else rightBoundary(root.left);
    }
}


/*
Time Complexity: O(N)
Auxillary Space: O(N)
*/
