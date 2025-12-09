package Java.Day_5;

class student{
    private String s_name;
    private int s_class;
    private int s_roll_no;

    String get_sname(){
        return s_name;
    }
    void set_sname(String s_name){
        this.s_name = s_name;
    }

    int get_sclass(){
        return s_class;
    }
    void set_sclass(int s_class){
        this.s_class = s_class;
    }

    int get_sRollNo(){
        return s_roll_no;
    }
    void set_sRollNo(int s_roll_no){
        this.s_roll_no = s_roll_no;
    }

}
public class Student_encapsulation {
    public static void main(String[] args) {
        student s1 = new student();
        s1.set_sname("Aditya");
        s1.set_sclass(8);   
        s1.set_sRollNo(26);

        System.out.println("\nStudent Name : "+ s1.get_sname());
        System.out.println("Student Roll No : "+ s1.get_sRollNo());
        System.out.println("Student Class : "+ s1.get_sclass()+"\n");
    }
}
