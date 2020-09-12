package datastructures.easy.BinarySearchTreeLowestCommonAncestor;

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
	public static Node lca(Node root, int v1, int v2) {
        // Binary tree부터 v1과 v2의 lowest common ancestor (LCA)를 찾는다.
        // 즉, v1의 노드와 v2의 노드의 가장 가까운 조상 노드를 찾는다.
        // v1과 v2 중에서 큰값과 작은값을 찾는다.
        int small = Math.min(v1, v2);
        int large = Math.max(v1, v2);
        // root의 값이 v1과 v2 사이면, root는 LCA이다.
        if (root.data >= small && root.data <= large) {
            return root;
        }
        // 작은값보다 root가 작으면, LCA는 오른쪽 서브트리에 있다.
        else if (root.data < small) {
            return lca(root.right, v1, v2);
        }
        // 큰값보다 root가 크면, LCA는 왼쪽 서브트리에 있다.
        else {
            return lca(root.left, v1, v2);
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
        int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}