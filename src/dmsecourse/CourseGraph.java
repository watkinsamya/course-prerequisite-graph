package dmsecourse;

import java.util.*;

public class CourseGraph {
    private Map<String, Course> courses;
    private Map<String, List<Course>> prerequisites;

    public CourseGraph() {
        courses = new HashMap<>();
        prerequisites = new HashMap<>();
    }

    // Function to add a course to the graph
    public void addCourse(Course c) {
        courses.putIfAbsent(c.getCourseNumber(), c);
        prerequisites.putIfAbsent(c.getCourseNumber(), new ArrayList<>()); // Avoid unnecessary initialization
    }

    // Function to add a prerequisite (Course pre -> Course c) with cycle detection
    public void addPrerequisite(Course pre, Course c) {
        if (!courses.containsKey(pre.getCourseNumber()) || !courses.containsKey(c.getCourseNumber())) {
            throw new IllegalArgumentException("One or both courses are not in the graph.");
        }
        
        // Check for cycles before adding
        if (detectCycle(c.getCourseNumber(), pre.getCourseNumber(), new HashSet<>())) {
            throw new IllegalArgumentException("Circular prerequisite detected!");
        }
        
        prerequisites.get(c.getCourseNumber()).add(pre);
    }

    // Function to detect a cycle using DFS
    private boolean detectCycle(String start, String target, Set<String> visited) {
        if (start.equals(target)) return true;
        if (!prerequisites.containsKey(start)) return false;

        visited.add(start);
        for (Course pre : prerequisites.get(start)) {
            if (!visited.contains(pre.getCourseNumber()) && detectCycle(pre.getCourseNumber(), target, visited)) {
                return true;
            }
        }
        visited.remove(start);
        return false;
    }

    // Function to display the graph
    public void displayGraph() {
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            Course course = entry.getValue();
            System.out.println(course);

            List<Course> prereqs = prerequisites.get(course.getCourseNumber());
            if (prereqs != null && !prereqs.isEmpty()) {
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

