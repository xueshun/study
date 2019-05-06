package list;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.xuesran.Student;
import com.xuesran.guava.Func;
import com.xuesran.guava.Reduce;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Demo01 {

    public static void main(String[] args) {
        ArrayList<Student> students = initData();
        BigDecimal apply = getFunction().apply(students);
        System.out.println(apply);
        Ordering<Student> ordering = getOrdering();


        System.out.println("排序前------------");
        System.out.println(students);
        Collections.sort(students, ordering);
        System.out.println("排序后-----------");
        System.out.println(students);


        System.out.println("计算加法----------------");
        BigDecimal reduce = Reduce.reduce(students, new Func<Student, BigDecimal>() {
            @Override
            public BigDecimal apply(Student currentElement, BigDecimal origin) {
                return origin.add(currentElement.getScore());
            }
        }, BigDecimal.ZERO);
        System.out.println(reduce);
    }

    private static Ordering<Student> getOrdering() {
        Ordering<Student> ordering = new Ordering<Student>() {
            @Override
            public int compare(@Nullable Student t1, @Nullable Student t2) {
                return t1.getScore().compareTo(t2.getScore());
            }
        };
        return ordering;
    }

    private static Function<List<Student>, BigDecimal> getFunction() {
        Function<List<Student>, BigDecimal> addFunction = new Function<List<Student>, BigDecimal>() {
            @Override
            public BigDecimal apply(List<Student> students) {
                BigDecimal fkhj = new BigDecimal(0);
                for (Student student :
                        students) {
                    fkhj = fkhj.add(student.getScore());
                }
                return fkhj;
            }
        };
        return addFunction;
    }

    private static ArrayList<Student> initData() {
        ArrayList<Student> stuList = Lists.newArrayList();
        Student s1 = new Student(1, new BigDecimal("1.11"), "张三");
        Student s2 = new Student(2, new BigDecimal("2.22"), "李四");
        Student s3 = new Student(3, new BigDecimal("2.22"), "王五");
        stuList.add(s3);
        stuList.add(s2);
        stuList.add(s1);
        return stuList;
    }
}
