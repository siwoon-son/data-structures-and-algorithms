package algorithms.medium.RoadsAndLibraries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static class Graph {
        // 그래프에 속한 노드들은 각각 연결된 인접 노드들의 리스트를 가진다.
        List<Integer>[] nodes;
        Graph(int n) {
            // 1-기반 인덱스이므로, n+1개의 노드를 만든다.
            nodes = new ArrayList[n+1];
            for (int i=1; i<=n; i++)
                nodes[i] = new ArrayList<>();
        }

        void addEdge(int node1, int node2) {
            // 주어진 간선으로부터,
            // node1의 인접 노드에 node2를 추가하고,
            // node2의 인접 노드에 node1을 추가한다.
            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }

        int dfs(int node, boolean[] visited) {
            // 주어진 노드 node와 연결될 수 있는 모든 노드의 수를 반환한다.
            // 현재 노드를 방문한 적이 있다면, 0을 반환한다.
            if (visited[node]) return 0;
            // 현재 노드를 방문한다.
            visited[node] = true;

            // 연결된 노드의 수를 1로 초기화한다. (현재 노드)
            int nOfNodes = 1;
            // 현재 노드의 인접 노드들을 방문한다.
            for (int neighbor: nodes[node]) {
                // 인접 노드와 연결된 모든 노드의 수를 누적 합한다.
                nOfNodes += dfs(neighbor, visited);
            }

            return nOfNodes;
        }
    }

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        // n개의 도시들은 cities와 같이 도로로 연결되어 있다.
        // 태풍으로 인해 도로와 도서관이 모두 유실되었다.
        // 도로로 서로 연결된 도시들은 하나의 도서관을 지어야 한다.
        // 도로와 도서관의 최소 복구비용을 계산하자.

        // 도서관 복구비용 보다 도로 복구비용이 더 비싸면,
        // 도로를 복구할 필요 없이 모든 도시에 도서관을 짓는게 더 낫다.
        if (c_lib <= c_road) return (long) c_lib * n;

        // 도서관 복구비용이 도로 복구비용보다 비싸면,
        // 기존의 연결된 도시들을 최소한의 도로로 연결하고, 도서관을 1개씩 지어야 한다.

        // n개의 도시로 Graph를 만든다.
        Graph g = new Graph(n);
        for (int[] city: cities) {
            g.addEdge(city[0], city[1]);
        }

        // 필요한 최소 도로 수를 0으로 초기화한다.
        int nOfRoads = 0;
        // 필요한 최소 도서관 수를 0으로 초기화한다.
        int nOfLibraries = 0;

        // 1-기반 인덱스이므로, n+1의 방문여부 배열을 생성한다.
        boolean[] visited = new boolean[n+1];
        // 1부터 n까지 노드들을 순회한다.
        for (int i=1; i<=n; i++) {
            // i-번째 노드와 연결될 수 있는 모든 노드의 수를 가져온다.
            int nOfNodes = g.dfs(i, visited);
            // 이미 방문한 노드이면 무시한다.
            if (nOfNodes == 0) continue;
            // 연결된 노드들은 1개의 도서관이 필요하다.
            nOfLibraries++;
            // 연결된 노드의 수에서 1을 빼면, 해당 노드들이 연결될 수 있는 도로 수이다.
            nOfRoads += (nOfNodes - 1);
        }

        return (long) nOfRoads * c_road + (long) nOfLibraries * c_lib;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
