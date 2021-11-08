import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Course {

    private String courseName;
    private int courseDuration;

    public Course(String courseName, int courseDuration) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseDuration() {
        return courseDuration;
    }


    public static int timeUntilEnd(LocalDateTime setDate) {
        LocalDateTime currentDate = LocalDateTime.now();
        int tempTime = 0;

        if (setDate.getDayOfWeek().getValue() < 6) {
            if ((setDate.withHour(17)).isBefore(currentDate))
                tempTime = 17 - setDate.getHour();
            else tempTime = currentDate.getHour() - setDate.getHour();
        }
        setDate = setDate.withDayOfYear(setDate.getDayOfYear() + 1);


        while (setDate.isBefore(currentDate)) {
            if (setDate.getDayOfWeek().getValue() < 6)
                tempTime += 8;

            setDate = setDate.withDayOfYear(setDate.getDayOfYear() + 1);
        }

        if (currentDate.getDayOfWeek().getValue() < 6) {
            if (currentDate.getHour() < 9) tempTime -= 8;
            else if (currentDate.getHour() < 17) tempTime -= (17 - currentDate.getHour());
        }
        return tempTime;

    }

    public static int courseTimeLeft(List<Course> courses) {
        int tempDuration = 0;
        for (Course l : courses) {
            tempDuration += l.getCourseDuration();
        }
        return tempDuration;
    }

    public static String courseReport(int duration, int timeElapsed) {
        String tempString = "";
        int diff = 0;
        if (duration > timeElapsed) tempString = "Training is not finished. " + (duration - timeElapsed) / 8 + "d " +
                (duration - timeElapsed) % 8 + " hours are left until the end.";
        else tempString = "Trainig completed. "+ (timeElapsed - duration)/8 + "d " + (timeElapsed - duration)%8 +
                " have passed since the end";
        return  tempString;
    }


}
