package dmsecourse;

public class Course {
    private String name;
    private String courseNumber;
    private int credits;
    private String description; // Optional, you can add this if desired

    // Constructor to initialize the course
    public Course(String name, String courseNumber, int credits, String description) {
        this.name = name;
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.description = description;
    }

    // Getters for the course details
    public String getName() {
        return name;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public int getCredits() {
        return credits;
    }

    public String getDescription() {
        return description;
    }

    // Override the toString method for better course display
    @Override
    public String toString() {
        return "Course{" +
               "name='" + name + '\'' +
               ", courseNumber='" + courseNumber + '\'' +
               ", credits=" + credits +
               ", description='" + description + '\'' +
               '}';
    }
}
