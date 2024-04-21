package Hjss;

import java.util.*;

class Lesson {
    private String day;
    private String timeSlot;
    private int gradeLevel;
    private Coach coach;
    private List<Learner> registeredLearners;

    public Lesson(String day, String timeSlot, int gradeLevel, Coach coach) {
        this.day = day;
        this.timeSlot = timeSlot;
        this.gradeLevel = gradeLevel;
        this.coach = coach;
        this.registeredLearners = new ArrayList<>();
    }

    public boolean isFull() {
        return registeredLearners.size() >= 4;
    }

    public void registerLearner(Learner learner) {
        registeredLearners.add(learner);
    }

    public void unregisterLearner(Learner learner) {
        registeredLearners.remove(learner);
    }

    public String getDay() {
        return day;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<Learner> getRegisteredLearners() {
        return registeredLearners;
    }
}