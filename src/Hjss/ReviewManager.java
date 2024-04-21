package Hjss;

import java.util.*;

class ReviewManager {
    private Map<Coach, List<Integer>> reviewsByCoach;

    public ReviewManager() {
        this.reviewsByCoach = new HashMap<>();
    }

    public void addReview(Lesson lesson, int rating) {
        Coach coach = lesson.getCoach();
        List<Integer> ratings = reviewsByCoach.getOrDefault(coach, new ArrayList<>());
        ratings.add(rating);
        reviewsByCoach.put(coach, ratings);
    }

    public double getAverageRatingForCoach(Coach coach) {
        List<Integer> ratings = reviewsByCoach.get(coach);
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return (double) sum / ratings.size();
    }
}