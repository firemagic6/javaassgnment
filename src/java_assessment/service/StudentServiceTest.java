package java_assessment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java_assessment.model.Course;
import java_assessment.model.Student;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;             // private attribute



    @BeforeEach
    void setUp(){
        studentService = new StudentService();         // create a new instance of StudentService before the test is run

    }

    @Test
    void testFindStudent() {
        Student student = studentService.findStudent("stu01");    //find the student stu01 created by StudentService
        assertNotNull(student, "Student should be found");                   // check whether the student exists through assertions to det. we have found the student
        assertEquals("Adrian", student.getFirstName(),"First name should be Adrian");
        assertEquals("Tan", student.getLastName(),"Last name should be Tan");
        assertEquals("Adriantan@gmail.com",student.getEmail(),"email should be Adriantan@gmail.com");
    }
    
    @Test
    void testNotFoundStudent(){
        Student student = studentService.findStudent( "stu09");
        assertNull(student,"Student should not be found");
        
    }

    @Test
    void testisSubscribed() {
        assertTrue(studentService.isSubscribed("stu01"));
        assertFalse(studentService.isSubscribed("stu00"));

    }

    @Test
    void testIsAttendingCourse(){
        Course courseJava = new Course("Introduction to Java", "INTRO-CS-J", 100);
        Student student = new Student("Tony","Stark","tonystark@gmail.com", new Date(101,0,17),"stu0x");
        student.enrollToCourse(courseJava);
        assertTrue(student.isAttendingCourse("INTRO-CS-J"),"Student should be attend course");
        assertFalse(student.isAttendingCourse("INTRO-CS-X"),"Student should not be attending course");
    }
}