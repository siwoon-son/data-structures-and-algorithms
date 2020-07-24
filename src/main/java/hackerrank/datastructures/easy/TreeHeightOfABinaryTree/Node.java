package hackerrank.datastructures.easy.TreeHeightOfABinaryTree;

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

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
        // 이진트리의 높이를 계산한다.
        // root에서는 높이가 0이다.
        return height(root, 0);
    }

    private static int height(Node curr, int currHeight) {
	    // 현재 노드가 null이면, 높이에 포함시키지 않아 1을 빼고 반환한다.
	    if (curr == null) return currHeight-1;
	    // 왼쪽 자식 노드와 오른쪽 자식 노드 중, 더 큰 높이를 반환한다.
	    return Math.max(height(curr.left, currHeight+1),
                height(curr.right, currHeight+1));
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
        int height = height(root);
        System.out.println(height);
    }	
}