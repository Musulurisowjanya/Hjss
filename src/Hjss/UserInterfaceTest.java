package Hjss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInterfaceTest {
    private UserInterface userInterface;

    @BeforeEach
    public void setUp() {
        userInterface = new UserInterface();
    }

    @Test
    public void testGenerateReports() {
        // Test if reports are generated properly
        userInterface.generateReports();
        // Assuming outputArea is updated correctly, you can test its content
        assertEquals("ExpectedReports", userInterface.getOutputArea().getText());
    }

    @Test
    public void testBookLesson() {
        // Test booking a lesson
        userInterface.getLearnerNameField().setText("John Doe");
        userInterface.getLessonField().setText("Lesson");
        userInterface.bookLesson();
        // Add assertions to verify the booking process
    }

    @Test
    public void testCancelLesson() {
        // Test canceling a lesson
        userInterface.getLearnerNameField().setText("John Doe");
        userInterface.getLessonField().setText("Lesson");
        userInterface.cancelLesson();
        // Add assertions to verify the cancellation process
    }

    @Test
    public void testWriteReview() {
        // Test writing a review
        userInterface.getLearnerNameField().setText("John Doe");
        userInterface.getLessonField().setText("Lesson");
        userInterface.getRatingField().setText("5");
        userInterface.writeReview();
        // Add assertions to verify the review writing process
    }
}
