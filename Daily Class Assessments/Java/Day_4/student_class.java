package Java.Day_4;

public class student_class {

    String name;
    int age;
    String grade;

    student_class(String n,int a,String g){
        name = n;
        age = a;
        grade = g;
    }
                                                                                    
    void displayInfo(){
        System.err.println("\nStudent name : "+name);
        System.err.println("Student Age : "+ age);
        System.err.println("Student Grade : "+grade+"\n");
    }

    public static void main(String[] args) {
        student_class s1 = new student_class("Aditya",22,"A1");
        s1.displayInfo();
    }
}
