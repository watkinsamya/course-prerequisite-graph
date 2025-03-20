package dmsecourse;

import java.util.*;

public class CourseGraph {
    // Map to store course number -> Course object
    private Map<String, Course> courses;
    
    // Map to store prerequisites for each course
    private Map<String, List<Course>> prerequisites;

    public CourseGraph() {
        courses = new HashMap<>();
        prerequisites = new HashMap<>();
    }

    // Function to add a course to the graph
    public void addCourse(Course c) {
        courses.put(c.getCourseNumber(), c);
        prerequisites.put(c.getCourseNumber(), new ArrayList<>()); // Initialize prerequisites list
    }

    // Function to add a prerequisite relationship (Course pre -> Course c)
    public void addPrerequisite(Course pre, Course c) {
        if (courses.containsKey(pre.getCourseNumber()) && courses.containsKey(c.getCourseNumber())) {
            prerequisites.get(c.getCourseNumber()).add(pre);
        } else {
            System.out.println("One or both courses are not in the graph.");
        }
    }

    // Function to display the graph content
    public void displayGraph() {
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            Course course = entry.getValue();
            System.out.println(course); // Print course details

            // Get prerequisites for the course
            List<Course> prereqs = prerequisites.get(course.getCourseNumber());
            if (!prereqs.isEmpty()) {
                System.out.print("Prerequisites: ");
                for (Course prereq : prereqs) {
                    System.out.print(prereq.getName() + " (" + prereq.getCourseNumber() + "), ");
                }
                System.out.println();
            } else {
                System.out.println("No prerequisites.");
            }
        }
    }
}
