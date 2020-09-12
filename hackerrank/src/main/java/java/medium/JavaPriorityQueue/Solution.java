package java.medium.JavaPriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://www.hackerrank.com/challenges/java-priority-queue/problem
// my code
class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double cgpa;
    public Student(String id, String name, String cgpa) {
        this(Integer.parseInt(id), name, Double.parseDouble(cgpa));
    }
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getCgpa() {
        return this.cgpa;
    }
    @Override
    public int compareTo(Student other) {
        // Sort Students by cgpa in descending order.
        double compareCgpa = this.cgpa - other.cgpa;
        if (compareCgpa > 0) return -1;
        else if (compareCgpa < 0) return 1;

        // Sort Students by name in ascending order.
        int compareName = this.name.compareTo(other.name);
        if (compareName > 0) return 1;
        else if (compareName < 0) return -1;

        // Sort Students by id in ascending order.
        return this.id > other.id ? 1 : -1;
    }
}
// end

class Solution {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<Student>(); 
        for (String event: events) {
            if (event.charAt(0) == 'E') {
                String[] splitted = event.split("\\s+");
                queue.add(new Student(splitted[3], splitted[1], splitted[2]));
            } else if (event.charAt(0) == 'S') {
                queue.poll();   
            }
        }

        List<Student> list = new ArrayList<Student>();
        while(!queue.isEmpty()) {
            list.add(queue.remove());
        }
        return list;
    }
}



