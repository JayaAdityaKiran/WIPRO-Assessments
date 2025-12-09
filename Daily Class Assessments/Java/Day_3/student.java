package Java.Day_3;
import java.util.*;
class student {

    // Data Members
    private String name;
    private int rollNo;
    private double marks;

    // Getters and Setters for name,rollNo and marks.
    private String getName(){
        return name;
    }
    private void setName(String name){
        this.name = name;
    }

    private int getrollNo(){
        return rollNo;
    }
    private void setName(int rollNo){
        this.rollNo = rollNo;
    }

    private double getmarks(){
        return marks;
    }
    private void setmarks(double marks){
        this.marks = marks;
    }

    // Default Constructor
    student(){
        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructors
    student(String name,int rollNo, double marks){
        this.name = name;
        this.rollNo = rollNo;
        this.setmarks(marks);
    }

    // Display Info
    void displayInfo(){
        System.err.println("Name : "+name);
        System.err.println("Roll No : "+rollNo);
        System.err.println("Marks : "+marks);
    }
}

class Main{
    
     void menu() {
        System.out.println("Menu");
        System.out.println("1. Add Student");
        System.out.println("2. Display Student");
        System.out.println("0. Exit");
    }
    public static void main(String[] args) {
        Main obj = new Main();
        student [] students =new student[10]; 
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            obj.menu;
            System.out.print("Enter your choice: ");   
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    for(int i=0;i<students.length;i++){
                        if(students[i]==null){
                            System.out.print("Enter Name: ");                  
                            String name = sc.next();
                            System.out.print("Enter Roll No: ");
                            int rollNo = sc.nextInt();
                            System.out.print("Enter Marks: ");                  
                            double marks = sc.nextDouble();
                            students[i]= new student(name,rollNo,marks);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Student Details:");
                    for(student s : students){
                        if(s!=null){
                            s.displayInfo();
                            System.out.println("-----");
                        }
                    }
                     break;
                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int searchRollNo = sc.nextInt();
                    boolean found = false;
                    for(student s : students){
                        if(s!=null && s.getRollNo() == searchRollNo){
                            s.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
    }while (choice != 0);
        sc.close();
    }
}
    