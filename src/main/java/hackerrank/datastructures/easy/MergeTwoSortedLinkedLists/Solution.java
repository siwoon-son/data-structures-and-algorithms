package hackerrank.datastructures.easy.MergeTwoSortedLinkedLists;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        // 정렬된 연결리스트르 2개를 병합하여 새로운 정렬된 연결리스트를 생성한다.
        // 새로운 연결리스트의 head를 생성한다.
        SinglyLinkedListNode head = null;

        // 연결리스트의 길이는 반드시 1 이상이므로,
        // 두 연결리스트의 첫 노드를 비교하여,
        // 더 작은 노드를 새로운 연결리스트의 head로 지정한다.
        if (head1.data <= head2.data) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        // head는 반환해야하므로 그대로 두고,
        // 새로운 변수를 head로 연결한다.
        SinglyLinkedListNode prev = head;
        // 두 연결리스트 중 하나라도 null이 아니면 반복한다.
        while (head1 != null || head2 != null) {
            // head1이 null이면,
            if (head1 == null) {
                // head2의 나머지를 새 연결리스트에 연결한다.
                prev.next = head2;
                break;
            }
            // head2가 null이면,
            else if (head2 == null) {
                // head1의 나머지를 새 연결리스트에 연결한다.
                prev.next = head1;
                break;
            }
            // 두 연결리스트에 모두 값이 있으면,
            // 더 작은 값을 새 연결리스트에 연결하고,
            // 연결리스트를 하나씩 이동한다.
            else if (head1.data <= head2.data) {
                prev.next = head1;
                head1 = head1.next;
                prev = prev.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
                prev = prev.next;
            }
        }

        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }
          
          	SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
