package Java.Day_3;

// class Class_ex_book {
//     // Data Members
//     String title = "unknown";
//     String author = "abc";
//     double price = 600.5;

//     // Member Functions
//     void displayInfo(){
//         System.out.println("Title: " + title);
//         System.out.println("Author: " + author);
//         System.out.println("Price: " + price);
//     }
// }
// class Main{
//     public static void main(String[] args) {
//         // Object creation
//         Class_ex_book book1 = new Class_ex_book();

//         // Method Invocation
//         book1.displayInfo();
//         new Class_ex_book().displayInfo();

//         Class_ex_book book2 = new Class_ex_book();
//         book2.author = "Geronimo";
//         book2.title = "Aditya";
//         book2.price = 400;
//         book2.displayInfo();

//         book2 = book1;
//         book2.displayInfo();
//         book1.title = "Game of Thrones";
//         book1.displayInfo();
//         book2.displayInfo();
//     }
// }

// -----------------------------------------
// #Constructors
// -----------------------------------------

class Class_ex_book {
    // Data Members
    String title = "unknown";
    String author = "abc";
    double price = 600.5;

    Class_ex_book(){
        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructor
    Class_ex_book(String title, String author){
        this.title = title;
        this.author = author;
        // this.price = price;
    }
    Class_ex_book(double price){
        // this.title = title;
        // this.author = author;
        this("Check","Check");
        this.price = price;
    }

    // Member Functions
    void displayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
class Main{
    public static void main(String[] args) {
        // Object creation
        Class_ex_book book1 = new Class_ex_book();
        System.out.println("----Book 1 Info----");
        book1.displayInfo();

        Class_ex_book book2 = new Class_ex_book("AAA","bbb");
        System.out.println("----Book 2 Info----");
        book2.displayInfo();

        Class_ex_book book3 = new Class_ex_book(900);
        System.out.println("----Book 3 Info----");
        book3.displayInfo();
    }
}