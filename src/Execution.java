import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Execution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Student st1 = new Student("Ivanov Ivan", "Java developer", 3);
        Student st2 = new Student("Sidorov Ivan", "AQE", 3);

        List<Course> firstStudentCourses = new ArrayList<>();
        List<Course> secondStudentCourses = new ArrayList<>();

        firstStudentCourses.add(new Course("Java", 16));
        firstStudentCourses.add(new Course("JDBC", 24));
        firstStudentCourses.add(new Course("Spring", 16));
        secondStudentCourses.add(new Course("Test Design", 10));
        secondStudentCourses.add(new Course("Page Object", 16));
        secondStudentCourses.add(new Course("Selenium", 16));

        LocalDateTime startTimeFirstStudent = LocalDateTime.of(2021, 11, 2, 9, 0);
        LocalDateTime startTimeSecondStudent = LocalDateTime.of(2021, 11, 1, 9, 0);


        System.out.println(startTimeFirstStudent);
        //int firstStudentCourseDuration = Course.timeUntilEnd(startTimeFirstStudent);
        //System.out.println(firstStudentCourseDuration);
        int secondStudentCourseDuration = Course.timeUntilEnd(startTimeSecondStudent);
        System.out.println(secondStudentCourseDuration);

        System.out.println("Enter report value");
        String reportType = input.nextLine();

        Report studentRecord = new Report();
        System.out.println(Report.report(st1, firstStudentCourses, Student.report(reportType), startTimeFirstStudent));

    }
}
