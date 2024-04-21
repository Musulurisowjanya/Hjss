package Hjss;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class UserInterface extends Frame implements ActionListener {
    private TextArea outputArea;
    private Button generateReportsButton, bookLessonButton, cancelLessonButton, writeReviewButton;
    private TextField learnerNameField, lessonField, ratingField;

    private List<Learner> learners;
    private List<Coach> coaches;
    private Timetable timetable;
    private ReviewManager reviewManager;

    public UserInterface() {
        setTitle("Hatfield Junior Swimming School");
        setLayout(new BorderLayout());

        // Create output area
        outputArea = new TextArea();
        outputArea.setEditable(false);
        add(outputArea, BorderLayout.CENTER);

        // Create input panel
        Panel inputPanel = new Panel(new GridLayout(3, 2));
        inputPanel.add(new Label("Learner Name:"));
        learnerNameField = new TextField();
        inputPanel.add(learnerNameField);
        inputPanel.add(new Label("Lesson:"));
        lessonField = new TextField();
        inputPanel.add(lessonField);
        inputPanel.add(new Label("Rating:"));
        ratingField = new TextField();
        inputPanel.add(ratingField);
        add(inputPanel, BorderLayout.NORTH);

        // Create button panel
        Panel buttonPanel = new Panel();
        generateReportsButton = new Button("Generate Reports");
        generateReportsButton.addActionListener(this);
        buttonPanel.add(generateReportsButton);
        bookLessonButton = new Button("Book Lesson");
        bookLessonButton.addActionListener(this);
        buttonPanel.add(bookLessonButton);
        cancelLessonButton = new Button("Cancel Lesson");
        cancelLessonButton.addActionListener(this);
        buttonPanel.add(cancelLessonButton);
        writeReviewButton = new Button("Write Review");
        writeReviewButton.addActionListener(this);
        buttonPanel.add(writeReviewButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize data
        initializeData();

        setSize(600, 400);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateReportsButton) {
            generateReports();
        } else if (e.getSource() == bookLessonButton) {
            bookLesson();
        } else if (e.getSource() == cancelLessonButton) {
            cancelLesson();
        } else if (e.getSource() == writeReviewButton) {
            writeReview();
        }
    }

    private void generateReports() {
        ReportGenerator reportGenerator = new ReportGenerator();
        reviewManager = new ReviewManager();

        // Generate learner report
        StringBuilder learnerReportBuilder = new StringBuilder();
        reportGenerator.generateLearnerReport(learners, learnerReportBuilder);

        // Generate coach report
        StringBuilder coachReportBuilder = new StringBuilder();
        reportGenerator.generateCoachReport(coaches, reviewManager, coachReportBuilder);

        // Update the output area with the reports
        outputArea.setText(learnerReportBuilder.toString() + coachReportBuilder.toString());
    }

    private void bookLesson() {
        learnerNameField.getText();
        lessonField.getText();
    }

    private void cancelLesson() {
        learnerNameField.getText();
        lessonField.getText();
    }

    private void writeReview() {
        learnerNameField.getText();
        lessonField.getText();
        Integer.parseInt(ratingField.getText());
    }

    private void initializeData() {
        // Initialize learners
        learners = new ArrayList<>();
        Learner john = new Learner("John Doe", 'M', 8, "1234567890", 2);
        Learner jane = new Learner("Jane Smith", 'F', 6, "9876543210", 1);
        Learner michael = new Learner("Michael Johnson", 'M', 10, "5555555555", 3);
        learners.add(john);
        learners.add(jane);
        learners.add(michael);

        // Initialize coaches
        coaches = new ArrayList<>();
        Coach alice = new Coach("Alice");
        Coach bob = new Coach("Bob");
        Coach charlie = new Coach("Charlie");
        coaches.add(alice);
        coaches.add(bob);
        coaches.add(charlie);

        // Initialize timetable
        timetable = new Timetable();
        Lesson lesson1 = new Lesson("Monday", "4-5pm", 1, alice);
        Lesson lesson2 = new Lesson("Monday", "5-6pm", 2, bob);
        Lesson lesson3 = new Lesson("Monday", "6-7pm", 3, charlie);
        timetable.addLesson(lesson1);
        timetable.addLesson(lesson2);
        timetable.addLesson(lesson3);
        // Add more lessons for the remaining days and time slots

        // Book some lessons for learners
        john.bookLesson(lesson1);
        jane.bookLesson(lesson2);
        michael.bookLesson(lesson3);

        // Attend some lessons for learners
        john.attendLesson(lesson1);
        jane.attendLesson(lesson2);

        // Write some reviews for learners
        john.writeReview(lesson1, 4);
        jane.writeReview(lesson2, 3);
    }

    public static void main(String[] args) {
        new UserInterface();
    }
}