package datastructures.medium.SwapNodes;

import java.io.*;
import java.util.*;

class BinaryTree {
    private class Node {
        int index;
        Node left, right;
        Node (int index, Node left, Node right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }

    Node root;
    BinaryTree (int[][] children) {
        this.root = new Node(1, null, null);
        Queue<Node> parents = new LinkedList<>();
        parents.add(root);

        for (int[] child: children) {
            Node childLeft = null, childRight = null;
            if (child[0] != -1) {
                childLeft = new Node(child[0], null, null);
                parents.add(childLeft);
            }
            if (child[1] != -1) {
                childRight = new Node(child[1], null, null);
                parents.add(childRight);
            }
            Node parent = parents.poll();
            parent.left = childLeft;
            parent.right = childRight;
        }
    }

    int[] inOrderTraversal() {
        List<Integer> visited = new ArrayList<Integer>();
        inOrder(visited, root);

        int[] ret = new int[visited.size()];
        for (int i=0; i<ret.length; i++) {
            ret[i] = visited.get(i);
        }

        return ret;
    }

    private void inOrder(List<Integer> visited, Node cur) {
        if (cur == null) return;
        inOrder(visited, cur.left);
        visited.add(cur.index);
        inOrder(visited, cur.right);
    }

    void swapNodes(int depth) {
        swapNodes(depth, 1, root);
    }

    private void swapNodes(int depth, int curDepth, Node cur) {
        if (cur == null) return;
        if (curDepth % depth == 0) {
            Node tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }
        swapNodes(depth, curDepth+1, cur.left);
        swapNodes(depth, curDepth+1, cur.right);
    }
}

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        BinaryTree tree = new BinaryTree(indexes);

        int[][] ret = new int[queries.length][];
        for (int i=0; i<queries.length; i++) {
            tree.swapNodes(queries[i]);
            ret[i] = tree.inOrderTraversal();
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
