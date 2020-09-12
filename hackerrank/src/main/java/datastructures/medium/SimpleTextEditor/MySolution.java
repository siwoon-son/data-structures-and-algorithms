package datastructures.medium.SimpleTextEditor;

import java.util.Scanner;
import java.util.Stack;

public class MySolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        SimpleTextEditor ste = new SimpleTextEditor();
        for (int i=0; i<Q; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                ste.append(sc.next());
            } else if (op == 2) {
                ste.delete(sc.nextInt());
            } else if (op == 3) {
                ste.print(sc.nextInt());
            } else if (op == 4) {
                ste.undo();
            }
        }
    }
}

class SimpleTextEditor {
    private StringBuffer s = new StringBuffer();
    Stack<STEOperator> operators = new Stack<STEOperator>();

    void append (String w) {
        Append append = new Append();
        operators.push(append);
        append.append(s, w);
    }
    void delete (int k) {
        Delete delete = new Delete();
        operators.push(delete);
        delete.delete(s, k);
    }
    void print (int k) {
        new Print().print(s, k);
    }
    void undo () {
        new Undo().undo(s, operators.pop());
    }
}

class Append implements STEOperator {
    int n;
    void append (StringBuffer origin, String w) {
        this.n = w.length();
        origin.append(w);
    }
}

class Delete implements STEOperator {
    String deleted;
    void delete (StringBuffer origin, int k) {
        this.deleted = origin.substring(origin.length()-k);
        origin.delete(origin.length()-k, origin.length());
    }
}

class Print implements STEOperator {
    void print(StringBuffer origin, int k) {
        System.out.println(origin.charAt(k-1));
    }
}

class Undo implements STEOperator {
    void undo(StringBuffer origin, STEOperator op) {
        if (op instanceof Append) {
            Append append = (Append) op;
            new Delete().delete(origin, append.n);
        } else if (op instanceof Delete) {
            Delete delete = (Delete) op;
            new Append().append(origin, delete.deleted);
        }
    }
}

interface STEOperator {}