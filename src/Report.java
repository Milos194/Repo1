import java.time.LocalDateTime;
import java.util.List;

public class Report {

    public static String report(Student student, List<Course> course, String reportType, LocalDateTime time) {
        String tempString = "";
        if (reportType.equals("Short")) {
            tempString = student.getStudentName() + " ( " + student.getStudentOccupation() +
                    " ) " + Course.courseReport(Course.courseTimeLeft(course), Course.timeUntilEnd(time));
        } else if (reportType.equals("Long")) {
        }
        return tempString;
    }
}

