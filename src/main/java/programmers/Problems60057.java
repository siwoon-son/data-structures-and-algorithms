package programmers;

public class Problems60057 {
    public static void main(String[] args) {
        Problems60057 app = new Problems60057();
        // System.out.println(app.encode("ababcdcdababcdcd", 8));
        System.out.println(app.solution("aabbaccc")); // expect 7.
        System.out.println(app.solution("ababcdcdababcdcd")); // expect 9.
        System.out.println(app.solution("abcabcdede")); // expect 8.
        System.out.println(app.solution("abcabcabcabcdededededede")); // expect 14.
        System.out.println(app.solution("xababcdcdababcdcd")); // expect 17.
    }

    public int solution(String s) {
        int answer = s.length();
        for (int gap=1; gap<=s.length()/2; gap++) {
            answer = Math.min(answer, encode(s, gap).length());
        }
        return answer;
    }

    private String encode(String s, int len) {
        String encoded = "";
        int i=0;
        while (i<=s.length()-len*2) {
            int nOfRep = 1;
            int right = i+len;
            while (right+len <= s.length() && equalsSubstring(s, i, right, len)) {
                right += len;
                nOfRep++;
            }
            if (nOfRep > 1) encoded += nOfRep;
            encoded += s.substring(i, i+len);
            i += len*nOfRep;
        }
        encoded += s.substring(i, s.length());
        return encoded;
    }

    private boolean equalsSubstring(String s, int left, int right, int length) {
        for (int i=0; i<length; i++) {
            if (s.charAt(left+i) != s.charAt(right+i))
                return false;
        }
        return true;
    }
}