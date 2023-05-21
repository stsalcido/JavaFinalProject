package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person implements Evaluation {
    private double average;
    private final List<Course> courses = new ArrayList<>();
    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);
    }

    public void enrollToCourse(Course course) {
        if ( !isAttendingCourse(course.getCode()) ) {
            courses.add(course);
            System.out.println("Student enrolled in course: " + course.getCode());
        } else {
            System.out.println("Student is already enrolled in this course.");
        }
    }

    public boolean isAttendingCourse(String courseCode) {
        // Check if the student is attending the course
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public void registerApprovedCourse(Course course) {
        approvedCourses.put(course.getCode(), course);
    }

    @Override
    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Student {" + super.toString() + "}";
    }
}