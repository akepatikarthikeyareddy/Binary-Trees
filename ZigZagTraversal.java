/*
Problem: Given A Binary Tree Print The Zig-Zag Traversal Of That Tree.

Input:             1         
                /     \
              2         3
            /   \      /  \
          4       5  6      7
        
Output: The Zig-Zag Traversal Of The Given Tree Is: [1, 3, 2, 4, 5, 6, 7]
*/
import java.util.*;
class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.print("The Zig-Zag Traversal Of The Given Tree Is: " + Tree.zigZagTraversal(root));
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
    static ArrayList<Integer> zigZagTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
	if(root == null) return ans;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	boolean flag = false;
	while(!queue.isEmpty()){
	    int size = queue.size();
	    ArrayList<Integer> temp = new ArrayList<>();
	    for(int i = 0; i < size; i++){
	        if(queue.peek().left != null) queue.offer(queue.peek().left);
	        if(queue.peek().right != null) queue.offer(queue.peek().right);
	        temp.add(queue.poll().data);
	    }
	    if(flag){
	        Collections.reverse(temp);
	    }
	    for(int i: temp) ans.add(i);
	    flag = !flag;
	}
	return ans;
    }
}

/*
Time Complexity: O(N)
Auxillary Space: O(N)
*/
