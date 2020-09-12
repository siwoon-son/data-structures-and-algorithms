package datastructures.medium.IsThisABinarySearchTree;

public class Solution {

    boolean checkBST(Node root) {
        // Binary tree가 Binary search tree인지 확인한다.
        // 조건 1. 어떤 노드의 값은 좌측 서브트리의 모든 값보다 크다.
        // 조건 2. 어떤 노드의 값은 우측 서브트리의 모든 값보다 작다.

        // 값이 0부터 10000까지 저장될 수 있으므로,
        // root는 0부터 10000까지의 값이 허용된다.
        return checkBST(root, 0, 10000);
    }

    private boolean checkBST(Node curr, int from, int to) {
        // 현재 노드는 반드시 from과 to 사이의 값이어야 한다.
        // 리프 노드까지 내려가면 Binary search tree이다.
        if (curr == null) return true;
        // 현재 값이 주어진 범위에 포함되면,
        if (from <= curr.data && curr.data <= to) {
            // 왼쪽 서브트리와 오른쪽 서브트리도 Binary search tree인지 확인한다.
            // 이때, 왼쪽 서브트리의 모든 값은 현재 노드보다 반드시 작아야 하며,
            // 오른쪽 서브트리의 모든 값은 현재 노드보다 반드시 커야한다.
            return checkBST(curr.left, from, curr.data-1) &&
                    checkBST(curr.right, curr.data+1, to);
        }
        // 현재 값이 주어진 범위에 포함되지 않으면,
        // Binary search tree가 아니다.
        return false;
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
