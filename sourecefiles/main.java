import java.util.Scanner;

class Student {
    String name, usn;
    int n;
    int[] marks = new int[10];
    int[] credits = new int[10];
    Scanner obj = new Scanner(System.in);

    void accept() {
        System.out.println("Enter name:");
        name = obj.nextLine();
        System.out.println("Enter USN:");
        usn = obj.nextLine();
        System.out.println("Enter number of subjects:");
        n = obj.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the marks of Subject " + (i + 1) + ":");
            marks[i] = obj.nextInt();
            System.out.println("Enter the credits of Subject " + (i + 1) + ":");
            credits[i] = obj.nextInt();
        }
    }

    int gradePoint(int marks) {
        if (marks >= 90) {
            return 10;
        } else if (marks >= 80) {
            return 9;
        } else if (marks >= 70) {
            return 8;
        } else if (marks >= 60) {
            return 7;
        } else {
            return 0;
        }
    }

    float sgpa() {
        int totalPoints = 0;
        int totalCredits = 0;
        for (int i = 0; i < n; i++) {
            int gp = gradePoint(marks[i]);
            totalPoints += gp * credits[i];
            totalCredits += credits[i];
        }
        return (float) totalPoints / totalCredits;
    }

    void display() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.println("Number of subjects: " + n);

        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1) + ": Marks = " + marks[i] + ", Credits = " + credits[i]);
        }
        System.out.println("SGPA: " + sgpa());
    }
}

public class main {
    public static void main(String[] args) {
        Student s = new Student();
        s.accept();
        s.display();
    }
}
