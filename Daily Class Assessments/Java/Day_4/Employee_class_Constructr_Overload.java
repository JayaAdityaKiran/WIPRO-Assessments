package Java.Day_4;

public class Employee_class_Constructr_Overload {
    String Name;
    int Salary;
    String Department;
    static int e_count;

    Employee_class_Constructr_Overload(){
        System.out.println("\nThis is the 1st Constructor");
        Name = "Rohan";
        Salary = 100;
        e_count++;
    }

    Employee_class_Constructr_Overload(String Name, int Salary,String Department ){
        System.out.println("This is the 2nd Constructor");
        this.Name = Name;
        this.Salary = Salary;
        this.Department = Department;
        e_count++;
    }

    Employee_class_Constructr_Overload(String Name, int Salary){
        System.out.println("This is the 3rd Constructor");
        this.Name = Name;
        this.Salary = Salary;
        e_count++;
    }

    Employee_class_Constructr_Overload(String Name,String Department){
        System.out.println("This is the 4th Constructor");
        this.Department = Department;
        // Department = "HR";
        this.Name = Name;
        e_count++;
    }

    void displayInfo(){
        System.out.println("Name : "+Name);
        System.out.println("Salary : "+Salary);
        System.out.println("Department : "+Department);
        System.out.println("Count of Employee : "+e_count+"\n");
    }

    public static void main(String[] args) {
        Employee_class_Constructr_Overload e1 = new Employee_class_Constructr_Overload();
        e1.displayInfo();

        Employee_class_Constructr_Overload e2 = new Employee_class_Constructr_Overload("Aditya",300,"Analyst");
        e2.displayInfo();

        Employee_class_Constructr_Overload e3 = new Employee_class_Constructr_Overload("Ram",500);
        e3.displayInfo();

        Employee_class_Constructr_Overload e4 = new Employee_class_Constructr_Overload("Nikhil","Manager");
        e4.displayInfo();
    }
}
