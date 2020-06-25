package hackerrank.datastructures.medium.ComponentsInAGraph;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the componentsInGraph function below.
     */
    static int[] componentsInGraph(int[][] gb) {
        int[] nodeToGraph = new int[gb.length*2+1];
        int lastGraph = 0;

        for (int i=0; i<gb.length; i++) {
            int g = gb[i][0];
            int b = gb[i][1];

            if (nodeToGraph[g] == 0 && nodeToGraph[b] == 0) { // two nodes are not contained.
                nodeToGraph[g] = nodeToGraph[b] = ++lastGraph;
            } else if (nodeToGraph[g] == 0) { // Only node G is not contained.
                nodeToGraph[g] = nodeToGraph[b];
            } else if (nodeToGraph[b] == 0) { // Only node B is not contained.
                nodeToGraph[b] = nodeToGraph[g];
            } else { // Merge two graphs. Nodes connected with B are migrated to G.
                int graphIdOfG = nodeToGraph[g];
                int graphIdOfB = nodeToGraph[b];

                for (int j=1; j<nodeToGraph.length; j++) {
                    if (nodeToGraph[j] == graphIdOfB)
                        nodeToGraph[j] = graphIdOfG;
                }
            }
        }

        int[] nOfNodesInGraphs = new int[lastGraph+1];
        for (int i=1; i<nodeToGraph.length; i++) {
            if (nodeToGraph[i] != 0)
                nOfNodesInGraphs[nodeToGraph[i]]++;
        }

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i=1; i<=lastGraph; i++) {
            if (nOfNodesInGraphs[i] == 0) continue;
            if (smallest > nOfNodesInGraphs[i]) smallest = nOfNodesInGraphs[i];
            if (largest < nOfNodesInGraphs[i]) largest = nOfNodesInGraphs[i];
        }

        return new int[]{smallest, largest};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] SPACE = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < SPACE.length; SPACEItr++) {
            System.out.print(String.valueOf(SPACE[SPACEItr]));

            if (SPACEItr != SPACE.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
