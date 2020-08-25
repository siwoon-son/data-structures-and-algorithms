package hackerrank.datastructures.medium.Contacts;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static class TrieNode {
        // TrieNode는 바로 다음 문자의 노드들을 가진다.
        // 중복된 문자는 허용하지 않으므로 Map을 사용한다.
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        // 현재 노드가 추가된 개수를 저장한다.
        // 이는 이전 문자들부터 현재 문자까지로 시작하는 이름들의 수를 기록한다.
        private int count;

        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
        int getCount () {
            return this.count;
        }
        void incCount () {
            this.count++;
        }
    }

    private static class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }
        void insert(String word) {
            // root부터 시작하여, 문자를 하나씩 삽입한다.
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                // 입력된 문자가 Trie에 없으면,
                if (thisNode.getChildNodes().get(word.charAt(i)) == null) {
                    // 노드를 생성한다.
                    thisNode.getChildNodes().put(word.charAt(i), new TrieNode());
                }
                // 해당 문자의 노드를 가져와서,
                thisNode = thisNode.getChildNodes().get(word.charAt(i));
                // 문자 수를 늘린다.
                thisNode.incCount();
            }
        }
        int count(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(character);
                // 노드가 없다면, 더 이상 볼 필요 없이 partial로 시작하는 이름이 없다.
                if (node == null)
                    return 0;
                thisNode = node;

            }

            // 마지막 문자까지 반복했을 때의 count를 반환한다.₩
            return thisNode.getCount();
        }
    }

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        // 질의는 add name과 find partial로 구성된다.
        // 질의 add name은 name을 연락망에 추가하고,
        // 질의 find partial은 연락망에서 partial로 시작하는 모든 이름의 개수를 반환한다.
        // 질의들의 결과를 반환하자.

        // 질의 find의 개수를 세고 반환할 배열을 생성한다.
        int nOfFind = 0;
        for (String[] query: queries) {
            if (query[0].equals("find")) nOfFind++;
        }
        int[] ret = new int[nOfFind];

        // 연락처를 빠르게 검색하도록 Trie 자료구조를 사용한다.
        Trie trie = new Trie();
        int i=0;
        for (String[] query: queries) {
            // 질의가 add면, trie에 이름을 추가한다.
            if (query[0].equals("add")) {
                trie.insert(query[1]);
            }
            // 질의가 find면, trie에서 partial로 시작하는 이름의 수를 가져온다.
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
