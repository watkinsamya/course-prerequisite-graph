package dmsecourse;

public class Main {
    public static void main(String[] args) {
        // Create course instances
        Course seng101 = new Course("Introduction to Software Engineering", "SENG101", 3, "Basic software engineering concepts.");
        Course seng102 = new Course("Data Structures", "SENG102", 4, "Study of data structures.");
        Course seng201 = new Course("Algorithms", "SENG201", 3, "Introduction to algorithms.");
        Course seng202 = new Course("Software Design", "SENG202", 3, "Design patterns and software architecture.");

        // Create a course graph
        CourseGraph graph = new CourseGraph();

        // Add courses to the graph
        graph.addCourse(seng101);
        graph.addCourse(seng102);
        graph.addCourse(seng201);
        graph.addCourse(seng202);

        // Define prerequisite relationships
        graph.addPrerequisite(seng101, seng102); // seng102 is a prerequisite for seng101
        graph.addPrerequisite(seng102, seng201); // seng201 is a prerequisite for seng102
        graph.addPrerequisite(seng201, seng202); // seng202 is a prerequisite for seng201

        // Display the graph content
        graph.displayGraph();
    }
}
