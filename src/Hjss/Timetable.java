package Hjss;
import java.util.*;

class Timetable {
    private List<Lesson> lessons;

    public Timetable() {
        this.lessons = new ArrayList<>();
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Lesson> viewLessonsByDay(String day) {
        List<Lesson> lessonsByDay = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getDay().equalsIgnoreCase(day)) {
                lessonsByDay.add(lesson);
            }
        }
        return lessonsByDay;
    }

    public List<Lesson> viewLessonsByGrade(int gradeLevel) {
        List<Lesson> lessonsByGrade = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getGradeLevel() == gradeLevel) {
                lessonsByGrade.add(lesson);
            }
        }
        return lessonsByGrade;
    }

    public List<Lesson> viewLessonsByCoach(String coachName) {
        List<Lesson> lessonsByCoach = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getCoach().getName().equalsIgnoreCase(coachName)) {
                lessonsByCoach.add(lesson);
            }
        }
        return lessonsByCoach;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}