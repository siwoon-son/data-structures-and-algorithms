package datastructures.easy.TreeLevelOrderTraversal;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
	    // binary tree에서 root부터 level 별로 노드들을 출력한다.
        // (즉, breadth-first search)

        // 큐를 생성하고 root를 저장한다.
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(root);
	    // 큐가 비어있을 때까지 반복한다.
	    while (!queue.isEmpty()) {
	        // 노드를 하나 꺼낸다.
	        Node curr = queue.poll();
	        // 노드가 null이면 아무 작업도 하지 않는다.
	        if (curr == null) continue;
	        // 노드의 왼쪽 자식노드와 오른쪽 자식노드를 큐에 저장한다.
            queue.add(curr.left);
            queue.add(curr.right);

            // 노드를 출력한다.
	        System.out.print(curr.data + " ");
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}