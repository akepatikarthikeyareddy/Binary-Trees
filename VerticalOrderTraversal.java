/*
Problem: Given A Binary Tree Print The Vertical Order Traversal Of That Tree.

Input:             1         
                /     \
              2         3
            /   \      /  \
          4       5  6      7
		/      \
	      8          9
        
Output: The Vertical Order Traversal Is: [4, 2, 8, 1, 5, 6, 3, 9, 7]
*/
import java.util.*;
class VerticalOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
		root.left.right.left = new Node(8);
		root.right.left.right = new Node(9);
        System.out.print("The Vertical Order Traversal Is: " + Tree.verticalOrderTraversal(root));
    }
}

class Node{
    int data;
    Node left = null;
    Node right = null;
    Node(int data){
        this.data = data;
    }
}

class Data{
    Node root;
    int x, y;
    Data(Node root, int x, int y){
        this.root = root;
        this.x = x;
        this.y = y;
    }
}

class Tree {
    static ArrayList <Integer> verticalOrderTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Data> queue = new LinkedList<>();
        Data temp = new Data(root, 0, 0);
        queue.offer(temp);
        ArrayList<Integer> arr = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                if(queue.peek().root.left != null){
                    temp = new Data(queue.peek().root.left, queue.peek().x-1, queue.peek().y+1);
                    queue.offer(temp);
                }
                if(queue.peek().root.right != null){
                    temp = new Data(queue.peek().root.right, queue.peek().x+1, queue.peek().y+1);
                    queue.offer(temp);
                }
                if(map.containsKey(queue.peek().x)){
                    arr = map.get(queue.peek().x);
                    arr.add(queue.peek().root.data);
                    map.put(queue.peek().x, arr);
                }
                else{
                    map.put(queue.peek().x, new ArrayList<Integer>(Arrays.asList(queue.peek().root.data)));
                }
                queue.poll();
            }
        }
        for(int i: map.keySet()){
            arr = map.get(i);
            for(int j: arr){
                ans.add(j);
            }
        }
        return ans;
    }
}

/*
Time Complexity: O(N)
Auxillary Space: O(N)
*/
