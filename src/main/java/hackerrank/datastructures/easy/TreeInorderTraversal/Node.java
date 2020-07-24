package hackerrank.datastructures.easy.TreeInorderTraversal;

import java.util.*;
import java.io.*;

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

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void inOrder(Node root) {
        // 트리를 in-order로 순회한다.
        // 현재 노드가 null이면 아무 작업도 수행하지 않는다.
        if (root == null) return;
        // 왼쪽 노드를 방문한다.
        inOrder(root.left);
        // 현재 노드의 값을 출력한다.
        System.out.print(root.data + " ");
        // 오른쪽 노드를 방문한다.
        inOrder(root.right);
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
        inOrder(root);
    }	
}