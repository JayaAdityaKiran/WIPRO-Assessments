package Java.Day_5;

class Person{
    String p_name;
    Person(String p_name){
        this.p_name = p_name;}
    void displayInfo(){
        System.out.println("\nName : "+p_name);
    }
}

class Student extends Person{
    int rollNumber;
    String name;
    Student(int rollNumber,String name){
        super(name);
        this.name = name;
        this.rollNumber = rollNumber;}
    void displayInfo(){
        super.displayInfo();
        // System.out.println("Name : "+p_name);
        System.out.println("Roll No : "+rollNumber+"\n");
    }
}

public class inheritance_ex {
    public static void main(String[] args) {
        Person p = new Person("p_name");
        Student s = new Student(26,"name");
        // p.displayInfo();
        s.displayInfo();
    }
 
}