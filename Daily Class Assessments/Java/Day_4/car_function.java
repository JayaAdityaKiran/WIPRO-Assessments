package Java.Day_4;

public class car_function {

    String name;
    String colour;
    int year;
    static int car_count; // class level var, rest all are object level
    
    car_function(String n, String c, int y){
        name = n;
        colour = c;
        year = y;
        car_count++; // if 2 obj are calles then car count will incraese and become 2 as it doesnt care about obj
    }

    car_function(){
        name = "Any Name";
        colour = "Any Colour";
        year = 2023;
    }

    car_function(String name){
        this.name = name;
        colour = "maroon";
        year = 2022;
    }

    void displayInfo(){
        System.err.println("\nCar name : "+name);
        System.err.println("Car name : "+colour);
        System.err.println("Car name : "+year+"\n");
    }

    void carcount(){
        System.err.println("\nCar count : "+car_count);
    }
    public static void main(String[] args) {
        // car_function mycar = new car_function();
        // mycar.colour = "Yellow";
        // mycar.name = "BMW";
        // mycar.year = 2025;
        // mycar.displayInfo();

        car_function mycar2 = new car_function("Honda City", "Matt Black", 2019); 
        mycar2.displayInfo();
        mycar2.carcount();

        car_function mycar3 = new car_function("Ertiga", "Red", 2022); 
        mycar3.displayInfo();
        mycar3.carcount();

        car_function car4 = new car_function();
        car4.displayInfo();
        car4.carcount(); // car count wont change as diff constructor

        car_function car5 = new car_function("Suzuki");
        car5.displayInfo();
        car5.carcount(); 
    }
}
