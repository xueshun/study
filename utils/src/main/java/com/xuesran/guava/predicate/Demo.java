package com.xuesran.guava.predicate;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Iterable<String> result = Iterables.filter(names, Predicates.containsPattern("a"));
        Collection<String> result1 = Collections2.filter(names, Predicates.containsPattern("a"));
        System.out.println(result);
        System.out.println(result1);

        List<Student> studentList = Lists.newArrayList();
        Student s1 = new Student(1, "张三", false, 62.2);
        Student s2 = new Student(2, "李四", false, 70.2);
        Student s3 = new Student(3, "李月", true, 80.2);
        Student s4 = new Student(4, "王五", false, 75.2);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        Predicate<Student> predicate1 = student -> {
            if (student.getName().contains("李")) {
                return true;
            }
            return false;
        };

        Predicate<Student> predicate2 = student -> {
            if (student.getScore() > 60) {
                return true;
            }
            return false;
        };

        Predicate<Student> and = Predicates.and(predicate1, predicate2);

        ArrayList<Student> students = Lists.newArrayList(Iterables.filter(studentList, and));

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
