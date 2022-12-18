/*
Problem: Given A Binary Tree Print Preorder, Inorder, Postorder & Level Order Traversals

Input:             1
                /     \
              2         3
            /   \      /   \
          4       5  6       7
          
Output: Preorder: [1, 2, 4, 5, 3, 6, 7]
        Inorder: [4, 2, 5, 1, 6, 3, 7]
        Postorder: [4, 5, 2, 6, 7, 3, 1]
        Level Order Traversal: [[1], [2, 3], [4, 5, 6, 7]]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class TreeTraversals{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> ans = new ArrayList<>();
        Tree.preOrder(root, ans);
        System.out.println("Preorder: " + ans);
        ans.clear();
        Tree.inOrder(root, ans);
        System.out.println("Inorder: " + ans);
        ans.clear();
        Tree.postOrder(root, ans);
        System.out.println("Postorder: " + ans);
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        Tree.levelOrderTraversal(root, out);
        System.out.println("Level Order Traversal: " + out);
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
    static void inOrder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;
        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }
    static void preOrder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;
        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }
    static void postOrder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;
        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.data);
    }
    static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode root, ArrayList<ArrayList<Integer>> out){
        if(root == null) return out;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            temp.clear();
            for(int i = 0; i < size; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                temp.add(queue.poll().data);
            }
            out.add(new ArrayList<Integer>(temp));
        }
        return out;
    }
}

/*
Time Complexity: O(N)
Auxillary Space: O(N)
*/