package Hjss;



import java.util.*;
class ReportGenerator {
    public void generateLearnerReport(List<Learner> learners, StringBuilder reportBuilder) {
        reportBuilder.append("Learner Report:\n");
        for (Learner learner : learners) {
            reportBuilder.append("Learner: ").append(learner.getName()).append("\n");
            reportBuilder.append("Booked Lessons: ").append(learner.getBookedLessons().size()).append("\n");
            reportBuilder.append("Cancelled Lessons: ").append(learner.getCancelledLessons().size()).append("\n");
            reportBuilder.append("Attended Lessons: ").append(learner.getAttendedLessons().size()).append("\n\n");
        }
    }

    public void generateCoachReport(List<Coach> coaches, ReviewManager reviewManager, StringBuilder reportBuilder) {
        reportBuilder.append("Coach Report:\n");
        for (Coach coach : coaches) {
            reportBuilder.append("Coach: ").append(coach.getName()).append("\n");
            double averageRating = reviewManager.getAverageRatingForCoach(coach);
            reportBuilder.append("Average Rating: ").append(averageRating).append("\n\n");
        }
    }
}