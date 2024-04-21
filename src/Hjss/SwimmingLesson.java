package Hjss;
import java.util.ArrayList;
import java.util.List;

public class SwimmingLesson {
    private String date;
    private String timeSlot;
    private String coach;
    private int gradeLevel;
    private int maxCapacity;
    private List<Learner> bookedLearners;

    public SwimmingLesson(String date, String timeSlot, String coach, int gradeLevel, int maxCapacity) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.coach = coach;
        this.gradeLevel = gradeLevel;
        this.maxCapacity = maxCapacity;
        this.bookedLearners = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getCoach() {
        return coach;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Learner> getBookedLearners() {
        return bookedLearners;
    }

    public boolean addLearner(Learner learner) {
        if (bookedLearners.size() < maxCapacity) {
            bookedLearners.add(learner);
            return true;
        }
        return false;
    }

    public boolean removeLearner(Learner learner) {
        return bookedLearners.remove(learner);
    }

    public boolean isFull() {
        return bookedLearners.size() >= maxCapacity;
    }

    public int getVacancies() {
        return maxCapacity - bookedLearners.size();
    }
}
