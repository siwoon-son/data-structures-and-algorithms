package programmers;

import java.util.Stack;

public class Problems60058 {
    public static void main(String[] args) {
        Problems60058 app = new Problems60058();
        System.out.println(app.solution("(()())()")); // expect "(()())()".
        System.out.println(app.solution(")(")); // expect "()".
        System.out.println(app.solution("()))((()")); // expect "()(())()".   
        System.out.println(app.solution(")()()()(")); // expect "(((())))".   
    }
    
    public String solution(String p) {
        if (p.equals("")) return p;

        int position = divide(p);
        String u = p.substring(0, position);
        String v = p.substring(position);

        if (isCorrect(u)) 
            return u + solution(v);
        return "(" + solution(v) + ")" + turn(u.substring(1, position-1));

    }

    private int divide(String p) {
        int nOfOpened = 0, i = 0;
        do {
            if (p.charAt(i) == '(') nOfOpened++;
            else nOfOpened--;
            i++;
        } while (nOfOpened != 0);
        
        return i;
    }

    private boolean isCorrect(String p) {
        boolean correct = true;
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(') stack.push('(');
            else if (stack.empty() || stack.pop() != '(') return false;
        }

        return correct;
    }

    private String turn(String p) {
        String inv = "";
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(')
                inv += ')';
            else 
                inv += '(';
        }
        return inv;
    }
}