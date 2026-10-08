import java.util.Scanner;

class Student {
    // Data members
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to calculate course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    // Method to check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return marks >= 50.0;
    }

    // Method to calculate scholarship amount
    public double calculateScholarship() {
        double totalFee = calculateFee();
        if (marks >= 85.0) {
            return 0.20 * totalFee; // 20% scholarship
        } else if (marks >= 70.0) {
            return 0.10 * totalFee; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after deducting scholarship
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display student and registration details
    public void displayDetails() {
        System.out.println("\n--- Student & Course Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Marks Obtained: " + marks);
        
        boolean isEligible = checkEligibility();
        System.out.println("Eligibility Status: " + (isEligible ? "Eligible" : "Not Eligible"));

        if (isEligible) {
            System.out.println("Total Course Fee: Rs. " + calculateFee());
            System.out.println("Scholarship Amount: Rs. " + calculateScholarship());
            System.out.println("Final Fee to Pay: Rs. " + calculateFinalFee());
        } else {
            System.out.println("Registration Failed: Marks are below the minimum threshold of 50.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading inputs
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        // Object creation using parameterized constructor
        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

        // Checking eligibility and displaying results using separate methods
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent is not eligible for registration due to low marks.");
        }

        scanner.close();
    }
}