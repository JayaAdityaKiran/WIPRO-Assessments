package Java.Day_4;
import java.util.*;
public class D_3_Q1 {
//     import java.util.Scanner;
// // import java.util.*;
// public class Person {
    // TODO: Define the 'Person' class with 'name' and 'age' member variables
    String name;
    int age;
    D_3_Q1(String name,int age){
        this.name = name;
        this.age = age;
    }
    void displayInfo(){
        System.out.print("Name: "+name+"\n");
        System.out.print("Age: "+age);
    }
    public static void main(String[] args) {
        // TODO: Write your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        D_3_Q1 p = new D_3_Q1(s,i);
        p.displayInfo();
        
    }
}

