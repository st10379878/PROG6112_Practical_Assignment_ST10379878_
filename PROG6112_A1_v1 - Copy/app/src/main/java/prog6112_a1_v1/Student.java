package prog6112_a1_v1;

import java.util.Scanner;
import java.util.ArrayList;
/*PLEASE NOTE:
I have not closed the scanners as this was leading to certain lines being
bypassed when gathering information
*/

public class Student {
    // instance variables
    public String studentId, studentEmail, studentName, studentCourse, studentAgeString;
    public int studentAge;
    // ArrayList to store user Objects
    private static ArrayList<Student> listOfUsers = new ArrayList<Student>();

    // Method to launch Selection Menu
    public static int launchMenu() {
        System.out.println("Please select one of the following menu items: " + "\n"
                + "(1)  Capture a Student" + "\n"
                + "(2)  Search for a Student" + "\n"
                + "(3)  Delete a Student" + "\n"
                + "(4)  Print Student Report" + "\n"
                + "(5)  Exit Application" + "\n");
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();
        return userChoice;
    }

    public static void captureStudent() {
        Scanner input = new Scanner(System.in);
        // create users
        Student studentDetails = new Student();
        System.out.println("CAPTURE A NEW STUDENT" + "\n*****************************************");
        System.out.println("Enter the student ID:");
        studentDetails.studentId = input.nextLine();
        System.out.println("Enter the student name:");
        studentDetails.studentName = input.nextLine();
        System.out.println("Enter the student age:");
        /*
         * Using parse with id in order to avoid using
         * input.nextLine(); to consume leftover key.This lead to lines being skipped.
         * With reference to Mr. Rozan video, titled Problems with User Input and the
         * Scanner in Java
         * available at Url:https://youtu.be/nC9QslLlZc4?si=Xn9_nBU65HkB9BWD
         * 
         */
        //Check Age
        String studAgeString =  input.nextLine();
       while( !isAgeDigit(studAgeString))
        {
            studAgeString = input.nextLine();
          
        }
        studentDetails.studentAge =  Integer.parseInt(studAgeString);
      
        System.out.println("Enter the student email");
        studentDetails.studentEmail = input.nextLine();
        // Check email
        isValidEmail(studentDetails.studentEmail);
        System.out.println("Enter the student course");
        studentDetails.studentCourse = input.nextLine();
        // Saving Student
        saveStudent(studentDetails.studentId, studentDetails.studentName, studentDetails.studentAge,
                studentDetails.studentEmail, studentDetails.studentCourse);
    }

    // Method to add a Student to the arrayList
    public static void addStudToList(Student newStudent) {
        // add user to arraylist
        listOfUsers.add(newStudent);
        System.out.println("User " + newStudent.studentName + " added.");
        System.out.println("----------------------------------------------------------------");
    }

    // Method to save student details
    public static void saveStudent(String Id, String Name, int Age, String Email, String Course) {
        // Create a new student
        Student studentDetails = new Student();
        // Setting student details
        studentDetails.studentId = Id;
        studentDetails.studentName = Name;
        studentDetails.studentAge = Age;
        studentDetails.studentEmail = Email;
        studentDetails.studentCourse = Course;
        // Add the student to the list
        Student.addStudToList(studentDetails);
    }
 

    // Method to determine if age inputed is not a number
    public static boolean isAgeDigit(String isString){
    Scanner getdigitAge = new Scanner(System.in);
    for (int i=0;i< isString.length();i++) {
        if ( !Character.isDigit(isString.charAt(i))) {
            System.out.println("You have entered a incorrect student age!!!" + "\n Re-enter a number for student age: ");
            getdigitAge.nextLine();
            return true;
            
        }
    }
    System.out.println("Is Valid");
    return true;
    };
    
    //Method to see if age is >= 16
    public static boolean isValidAge(String studAge) {

       if( !isAgeDigit(studAge) ){ return false;}
       int studAgeInt = Integer.parseInt(studAge);
        boolean isValid = (studAgeInt >= 16);
        if (!isValid) {
            System.out.println("You have entered a incorrect student age!!!" + "\n Re-enter the student age: ");
           
           
                isValid = false;
            
        }
        return isValid;
    }

     //Method to determine if format of email is correct
    public static boolean isValidEmail(String email) {
        Scanner getEmail = new Scanner(System.in);
        boolean isValid = (email.contains("@") && email.contains("."));

        while (!isValid) {
            System.out.println("You have entered a incorrect email!!!" + "\nRe-enter an email with the following: " +
                    "\n1.Includes an @" + "\n2.Ends with a .");
            email = getEmail.nextLine();
            if (email.contains("@") && email.contains(".")) {
                isValid = true;
            }
        }
        return isValid;
    }

    // Method to fetch user list
    public static ArrayList<Student> getStudent() {
        return listOfUsers;
    }

    // Capturing id to search for
    public static void captureID() {
        Scanner getStud = new Scanner(System.in);
        System.out.println("Please enter studentID:");
        String findId = getStud.nextLine();
        displayStudentById(findId);
    }

    // Searching for a Match
    public static int searchId(String searchId) {
        ArrayList<Student> createdUsers = Student.getStudent();

        // Loop through the ArrayList to find the student
        for (int index = 0; index < createdUsers.size(); index++) {
            if (searchId.equals(createdUsers.get(index).studentId)) {
                return index; // Return the index if a match is found
            }
        }
        return -1; // Return -1 if no student is found
    }

    // Displaying student found
    public static String displayStudentById(String searchId) {
        Scanner getId = new Scanner(System.in);
        ArrayList<Student> createdUsers = Student.getStudent();
        // calling searchId method to get index value
        int index = searchId(searchId);

        // if no match was found
        while (index == -1) {
            System.out.println("Student ID: " + searchId + " not Found.");
            System.out.println("Please re-enter an ID to search: ");
            searchId = getId.nextLine();
            index = searchId(searchId); // updating index
        }
        // Print the student details if found
        Student student = createdUsers.get(index);
        System.out.println("\n----------------------------------------------------------------");
        System.out.println(
                "\nSTUDENT ID: " + student.studentId
                        + "\nSTUDENT NAME: " + student.studentName
                        + "\nSTUDENT AGE: " + student.studentAge
                        + "\nSTUDENT EMAIL: " + student.studentEmail
                        + "\nSTUDENT COURSE: " + student.studentCourse);
        System.out.println("\n----------------------------------------------------------------");
        return searchId;
    }

    // Method to find student index
    public static int findStudentIndexById(String studentId, ArrayList<Student> students) {
        for (int index = 0; index < students.size(); index++) {
            if (studentId.equals(students.get(index).studentId)) {
                return index;
            }
        }
        return -1; // Student not found
    }

    // Method to delete user if confirmed
    public static boolean deleteStudentId(String studentId, boolean confirmDelete) {
        ArrayList<Student> createdUsers = Student.getStudent();
        int index = findStudentIndexById(studentId, createdUsers);

        if (index == -1) {
            return false; // Student not found
        }

        if (confirmDelete) {
            createdUsers.remove(index);
            return true; // Student deleted
        }
        return false; // Deletion not confirmed
    }

    public static void DeleteStudent() {
        Scanner deleteStud = new Scanner(System.in);
        ArrayList<Student> createdUsers = Student.getStudent();
        System.out.println("Enter student id to delete: ");
        String toDelete = deleteStud.nextLine();

        // Using findStudentIndexById() to find the student to delete
        int index = findStudentIndexById(toDelete, createdUsers);
        if (index == -1) {
            System.out.println("Student with ID: " + toDelete + " not found.");
        }
        // confirming if user wishes to delete selected student
        System.out.println("Are you sure you want to delete student: " + toDelete + " from the system?"
                + "\nYes (y) to delete"
                + "\nNo (Any key) to cancle");
        String confirmDelete = deleteStud.nextLine();

        /*
         * Call the delete logic method, we use equalsIgnoreCase as regardless of
         * whether "y" is inputted as
         * Upper or lowercase, both are right option,if anything else inputted, deletion
         * will not take place
         */
        boolean isDeleted = deleteStudentId(toDelete, confirmDelete.equalsIgnoreCase("y"));

        if (isDeleted) {
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("Student with Id: " + toDelete + " WAS deleted!");
            System.out.println("----------------------------------------------------------------");
        } else {
            System.out.println("Student " + toDelete + " has not been removed");
        }
    }

    public static void StudentReport() {
        // get list of users
        ArrayList<Student> createdUsers = Student.getStudent();

        // go through user objects and print names
        for (Student storedUser : createdUsers) {
            System.out.println("STUDENT: " + (findStudentIndexById(storedUser.studentId, createdUsers)+ 1));
            System.out.println(
                    "-------------------------------------" + "\n" +
                            "STUDENT ID: " + storedUser.studentId + "\n"
                            + "STUDENT NAME: " + storedUser.studentName + "\n"
                            + "STUDENT AGE: " + storedUser.studentAge  + "\n"
                            + "STUDENT EMAIL: " + storedUser.studentEmail + "\n"
                            + "STUDENT COURSE: " + storedUser.studentCourse + "\n" +
                            "-------------------------------------" + "\n");
        }
    }
    //Terminate program(end)
    public static void ExitStudentApplication() {
        System.out.println("Have a good day");
    }
}
