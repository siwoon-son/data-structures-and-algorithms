package hackerrank.datastructures.medium.Contacts;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();

        private boolean isLastChar;
        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
        boolean isLastChar() {
            return this.isLastChar;
        }
        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }

    private static class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }
        void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsLastChar(true);
        }
        int count(String word) {
            TrieNode thisNode = this.rootNode;

            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(character);
                if (node == null)
                    return count;
                count++;
                thisNode = node;

            }

            return count;
        }
    }

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        int nOfFind = 0;
        for (String[] query: queries) {
            if (query[0].equals("find")) nOfFind++;
        }

        int[] ret = new int[nOfFind];
        Trie trie = new Trie();
        int i=0;
        for (String[] query: queries) {
            if (query[0].equals("add")) {
                trie.insert(query[1]);
            }
            else {
                ret[i] = trie.count(query[1]);
                i++;
            }
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
