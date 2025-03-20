package dmsecourse;

public class Main {
    public static void main(String[] args) {
        CourseGraph graph = new CourseGraph();

        // Create sample courses
        Course courseA = new Course("Intro to CS", "CSE101", 3, "Basic programming concepts");
        Course courseB = new Course("Data Structures", "CSE102", 3, "Introduction to data structures");
        Course courseC = new Course("Algorithms", "CSE103", 3, "Algorithm design and analysis");

        // Adding courses to the graph
        graph.addCourse(courseA);
        graph.addCourse(courseB);
        graph.addCourse(courseC);

        // Adding valid prerequisites
        graph.addPrerequisite(courseA, courseB);
        graph.addPrerequisite(courseB, courseC);

        // Attempting to add a circular prerequisite (Should throw an exception)
        try {
            graph.addPrerequisite(courseC, courseA);
        } catch (IllegalArgumentException e) {
            System.out.println("Error caught as expected: " + e.getMessage());
        }

        // Display the graph to verify the data
        graph.displayGraph();
    }
}

