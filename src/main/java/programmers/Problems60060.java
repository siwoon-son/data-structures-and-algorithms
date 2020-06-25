package programmers;

import java.util.Arrays;

public class Problems60060{
    public static void main(String[] args) {
        Problems60060 app = new Problems60060();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(app.solution(words, queries))); // expect true
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie[] preTrie = new Trie[10001];
        Trie[] postTrie = new Trie[10001];
        for (String word: words) {
            int len = word.length();
            if (preTrie[len] == null) {
                preTrie[len] = new Trie();
                postTrie[len] = new Trie();
            }
            preTrie[len].add(reverse(word));
            postTrie[len].add(word);
        }

        for (int i=0; i<queries.length; i++) {
            int len = queries[i].length();
            if (preTrie[len] == null)
                answer[i] = 0;
            else if (queries[i].charAt(0) == '?')
                answer[i] = preTrie[len].nOfMatched(reverse(queries[i]));
            else
                answer[i] = postTrie[len].nOfMatched(queries[i]);
        }
        return answer;
    }
    private String reverse(String str) {
        return (new StringBuffer(str)).reverse().toString();
    }
}
class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    public void add(String word) {
        Node cur = root;
        for (int i=0; i<word.length(); i++) {
            cur = cur.putAndGetChild(word.charAt(i), word.length());
        }
    }
    public int nOfMatched(String query) {
        Node cur = root;
        for (int i=0; i<query.length(); i++) {
            if (query.charAt(i) == '?') return cur.getSize();
            cur = cur.getChild(query.charAt(i));
            if (cur == null) break;
        }
        return 0;
    }
    class Node {
        private Node[] childs;
        private int size;
        
        public Node() {
            childs = new Node[26];
        }

        public Node putAndGetChild(char key, int length) {
            int idx = key - 'a';
            if (childs[idx] == null)
                childs[idx] = new Node();
            size++;
            return childs[idx];
        }

        public Node getChild(char key) {
            int idx = key - 'a';
            return childs[idx];
        }

        public int getSize() {
            return size;
        }
    }
}