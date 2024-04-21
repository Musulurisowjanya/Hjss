package Hjss;
import java.util.*;

class Learner {
    private String name;
    private char gender;
    private int age;
    private String emergencyContact;
    private int currentGradeLevel;
    private List<Lesson> bookedLessons;
    private List<Lesson> cancelledLessons;
    private List<Lesson> attendedLessons;
    private Map<Lesson, Integer> reviews;

    public Learner(String name, char gender, int age, String emergencyContact, int currentGradeLevel) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.emergencyContact = emergencyContact;
        this.currentGradeLevel = currentGradeLevel;
        this.bookedLessons = new ArrayList<>();
        this.cancelledLessons = new ArrayList<>();
        this.attendedLessons = new ArrayList<>();
        this.reviews = new HashMap<>();
    }

    public boolean bookLesson(Lesson lesson) {
        int allowedGradeLevel = currentGradeLevel + 1;
        if (lesson.getGradeLevel() > allowedGradeLevel || lesson.isFull()) {
            return false;
        }
        if (bookedLessons.contains(lesson)) {
            return false;
        }
        bookedLessons.add(lesson);
        lesson.registerLearner(this);
        return true;
    }

    public boolean cancelLesson(Lesson lesson) {
        if (!bookedLessons.contains(lesson)) {
            return false;
        }
        bookedLessons.remove(lesson);
        cancelledLessons.add(lesson);
        lesson.unregisterLearner(this);
        return true;
    }

    public void attendLesson(Lesson lesson) {
        if (bookedLessons.contains(lesson)) {
            attendedLessons.add(lesson);
            if (lesson.getGradeLevel() == currentGradeLevel + 1) {
                currentGradeLevel++;
            }
        }
    }

    public void writeReview(Lesson lesson, int rating) {
        reviews.put(lesson, rating);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public int getCurrentGradeLevel() {
        return currentGradeLevel;
    }

    public List<Lesson> getBookedLessons() {
        return bookedLessons;
    }

    public List<Lesson> getCancelledLessons() {
        return cancelledLessons;
    }

    public List<Lesson> getAttendedLessons() {
        return attendedLessons;
    }
}