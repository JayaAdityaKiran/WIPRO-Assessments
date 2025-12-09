package Java.Day_4;

public class book_function {
    String B_name;
    String A_name;
    String B_genre;
    double price;
    static int b_count;
    static int a_count;

    book_function(String B_name,String A_name,String B_genre ,double price) {
    this.B_name = B_name;
    this.A_name = A_name;
    this.B_genre = B_genre;
    this.price = price;
    b_count++;
    a_count++;
    }
    
    void displayInfo(){
        System.err.println("\nBook name : "+B_name);
        System.err.println("Author name : "+A_name);
        System.err.println("Book Genre : "+B_genre);
        System.err.println("Price : "+price);
        System.err.println("Book count : "+b_count);
    }

    static void authorCount(){
        System.err.println("Author count : "+a_count+"\n");
    }

    public static void main(String[] args) {
        book_function b1 = new book_function("Geronimo","Aditya","Comedy",500);
        b1.displayInfo();
        authorCount();

        book_function b2 = new book_function("Game Of Thrones","Martin","Fantasy",600);
        b2.displayInfo();
        authorCount();

        book_function b3 = new book_function("Romeo and Julliet","William","Romance",800.5);
        b3.displayInfo();
        authorCount();
    }
}
