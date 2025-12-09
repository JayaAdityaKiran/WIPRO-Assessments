
/* # Student application
1. Add ## done 
2. display ## done 
3. display one ## done 
4. delete (move each element up) 
5. Modify (make nested menu in which you should ask what needs to be modifies ) 
6. sort as per the Marks */

package Java.Day_3;
import java.util.*;

class Student_app {

    private String name;
    private int rollNo;
    private double marks;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    // Constructors
    Student_app() {
        System.out.println("Default Constructor Called");
    }

    Student_app(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    void displayInfo() {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
        System.out.println("Marks : " + marks);
    }
}

class m {
    void menu() {
        System.out.println("\nMenu");
        System.out.println("0. Exit");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Display Single Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Modify Student Details");
        System.out.println("6. Sort Students by Marks");
    }

    public static void main(String[] args) {
        m obj = new m();
        Student_app[] students = new Student_app[10];
        Scanner sc = new Scanner(System.in);
        int choice;
        int actual_students_count = 0; // ✅ moved outside the loop

        do {
            obj.menu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (actual_students_count < students.length) {
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Roll No: ");
                        int rollNo = sc.nextInt();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        students[actual_students_count] = new Student_app(name, rollNo, marks);
                        System.out.println("Student added successfully!");
                        actual_students_count++;
                    } else {
                        System.out.println("Array full! Cannot add more students.");
                    }
                    break;

                case 2:
                    System.out.println("\nStudent Details:");
                    for (int i = 0; i < actual_students_count; i++) {
                        students[i].displayInfo();
                        System.out.println("-----");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int searchRollNo = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < actual_students_count; i++) {
                        if (students[i].getRollNo() == searchRollNo) {
                            students[i].displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Student not found!");
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int deleteRollNo = sc.nextInt();
                    boolean deleted = false;

                    for (int i = 0; i < actual_students_count; i++) {
                        if (students[i] != null && students[i].getRollNo() == deleteRollNo) {
                            for (int j = i; j < actual_students_count - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            students[actual_students_count - 1] = null; // clear last slot
                            actual_students_count--;
                            deleted = true;
                            break;
                        }
                    }

                    if (deleted)
                        System.out.println("Deleted student with roll no " + deleteRollNo);
                    else
                        System.out.println("Student not found.");
                    break;
                
                case 5:
                    boolean roll_modify = false;
                    System.out.print("Enter Roll No for Student detail modification : ");
                    int r_modify = sc.nextInt();
                    for(int i =0;i<actual_students_count;i++){
                        if(r_modify==students[i].getRollNo()){
                             sc.nextLine();
                            System.out.println("Enter new name : ");
                            String n_modify = sc.nextLine();
                            System.out.println("Enter new marks : ");
                            double m_modify = sc.nextDouble();
                            students[i].setMarks(m_modify);
                            students[i].setName(n_modify);
                            roll_modify = true;
                            break;
                        }
                    }
                    if (roll_modify)
                        System.out.println("Modified student details with roll no " + r_modify);
                    else
                        System.out.println("Student not found.");
                    break;

                case 6:
                    System.out.println("\nStudent Details before Sorting:");
                    // System.err.println();
                    System.out.println("\nStudent Details:");
                    for (int i = 0; i < actual_students_count; i++) {
                        students[i].displayInfo();
                        System.out.println("-----");
                    }
                    for (int i = 0; i < actual_students_count; i++){
                        for (int j = i + 1; j < actual_students_count; j++) {
                            if (students[i] != null && students[j] != null && students[i].getMarks() < students[j].getMarks()) {
                                Student_app temp = students[i];
                                students[i] = students[j];
                                students[j] = temp;
                            }
                        }
                    }
                    System.out.println("\nStudent Details after Sorting:");
                    for (int i = 0; i < actual_students_count; i++) {
                        if (students[i] != null) {
                            students[i].displayInfo();
                            System.out.println("-----");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
