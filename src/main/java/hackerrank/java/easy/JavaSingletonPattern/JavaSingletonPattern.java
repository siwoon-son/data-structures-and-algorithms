package hackerrank.java.easy.JavaSingletonPattern;


// https://www.hackerrank.com/challenges/java-singleton/problem
class JavaSingletonPattern {
    private JavaSingletonPattern() {}
    private static JavaSingletonPattern instance;
    static JavaSingletonPattern getSingleInstance() {
        if (instance == null) {
            synchronized (JavaSingletonPattern.class) {
                if (instance == null) {
                    instance = new JavaSingletonPattern();
                }
            }
        }
        return instance;
    }

}