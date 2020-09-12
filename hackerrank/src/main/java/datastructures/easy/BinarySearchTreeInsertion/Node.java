package datastructures.easy.BinarySearchTreeInsertion;

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
  
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
	    // 현재 부분트리의 root가 null이면 새로운 노드를 부분트리의 root로 반환한다.
	    if (root == null) return new Node(data);
	    // root의 데이터가 새로운 데이터보다 크면,
	    if (root.data > data)
	        // root의 왼쪽 자식 노드를,
	        // root의 왼쪽 부분트리에 새로운 노드를 추가한 부분트리로 바꾼다.
	        root.left = insert(root.left, data);
	    // root의 데이터가 새로운 데이터보다 작으면,
	    else
	        // root의 오른쪽 자식 노드를,
            // root의 오른쪽 부분트리에 새로운 노드를 추가한 부분트리로 바꾼다.
	        root.right = insert(root.right, data);
	    // root를 반환한다.
    	return root;
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
      	preOrder(root);
    }
}