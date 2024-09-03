/*
 * This source file was generated by the Gradle 'init' task
 */
package prog6112_a1_v1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class StudentTest {
    @Test
    public void TestSaveStudent() {
        // Test data
        String studentId = "2048";
        String studentName = "Toji";
        int studentAge = 20;
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";

        Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);

        ArrayList<Student> students = Student.getStudent();
        assertEquals("2048", students.get(0).studentId);
        assertEquals("Toji", students.get(0).studentName);
        assertEquals(20, students.get(0).studentAge);
        assertEquals("Toji@Test.com", students.get(0).studentEmail);
        assertEquals("Computer Science", students.get(0).studentCourse);
    }

    @Test
    public void testSearchStudent() {
        // Test data
        String studentId = "2048";
        String studentName = "Toji";
        int studentAge = 20;
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";
        // Saving student data
        Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
        // Storing output
        int actualOutput = Student.searchId(studentId);

        int expectedOutput = 0;
        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void TestSearchStudent_StudentNotFound() {
        // Test data
        String studentId = "2048";
        String studentName = "Toji";
        int studentAge = 20;
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";
        // Saving student data
        Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
        int actualOutput = Student.searchId(studentId);
        
        // Verify the output
        int expectedOutput = 0;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void TestDeleteStudent() {
        // Test data
        ArrayList<Student> createdUsers = Student.getStudent();
        String studentId = "2048";
        String studentName = "Toji";
        int studentAge = 20;
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";
        
        // Saving student data
        Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
        int actualOutput = Student.findStudentIndexById("2048",createdUsers);
        // Verify the output
        int expectedOutput = 0;
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void TestDeleteStudent_StudentNotFound() {
        // Test data
        ArrayList<Student> createdUsers = Student.getStudent();
        String studentId = "2048";
        String studentName = "Toji";
        int studentAge = 20;
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";
        
        // Saving student data
        Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
        int actualOutput = Student.findStudentIndexById("1998",createdUsers);
        // Verify the output
        int expectedOutput = -1;
        assertEquals(expectedOutput, actualOutput);
    }

   

    @Test
    public void TestStudentAge_StudentAgeValid() {
        // Test data
        String studentId = "2048";
        String studentName = "Toji";
        int studentAge = 20; // Valid age
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";
        Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
        boolean actualOutput = Student.isAgeDigit("20");
        boolean expectedOutput = true;
        assertEquals(actualOutput, expectedOutput);
    }
    @Test
    public void TestStudentAge_StudentAgeInValid() {
        // Test data
        String studentId = "2048";
        String studentName = "Toji";
        int studentAge = 10; // Not a valid age
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";
        Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
        boolean actualOutput = Student.isValidAge("10");
        boolean expectedOutput = false;
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void TestStudentAge_StudentAgeInValidCharacter() {
        // Test data
        String studentId = "2048";
        String studentName = "Toji";
        String studentAgeStore = "word";// Not valid 
        //int studentAge = Integer.parseInt(studentAgeStore); 
        String studentEmail = "Toji@Test.com";
        String studentCourse = "Computer Science";
        //Student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
        boolean actualOutput = Student.isAgeDigit(studentAgeStore);
        boolean expectedOutput = false;
        assertEquals(actualOutput,expectedOutput);
    }

}
