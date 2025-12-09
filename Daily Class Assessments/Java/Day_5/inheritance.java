package Java.Day_5;

class vehicle{
    String name = "honda";
    int year = 2025;
    void new_vehicle(){
        System.out.println("Vehicle Name : "+name);
        System.out.println("Vehicle Year : "+year);
    }
    void v_vehicle(){
        System.out.println("This is a vehicle");
    }
}
class car extends vehicle{
    String model = "I series";
    void c_car(){
        System.out.println("Vehicle Model : "+model);
    }
}

class bike extends car{
    void b_vehicle(){
        System.out.println("This is a bike");
    }
    void v_vehicle(){
        System.out.println("This is not a vehicle");
    }
}

class tempo extends vehicle{
    void c_tempo(){
        System.out.println("This is a tempo");
    }
}







interface color{
    default void c(){
        System.out.println("This is color");
    }
    void cc();
}

interface height{
    default void h(){
        System.out.println("This is height");
    }
}

class dog implements color,height{
    void d(){
        System.out.println("This is dog");
    }
    public void cc(){
        System.out.println("This is color color");
    }
}





public class inheritance {
    public static void main(String[] args) {
        vehicle v1 = new vehicle();
        // v1.print();

        // System.out.println("\n");
        car c1 = new car();
        // c1.print(); ------- single inheritance

        bike b1 = new bike();
        // b1.print();
        // b1.printt(); -------multilevel inheritance as b1 can access vehicle class 

        // v1.v_vehicle();
        // b1.v_vehicle(); --------- overriding method as v_vehicle is there 2 times but bike take bike one and vehicle takes vehicle one
        // b1.b_vehicle();
        // b1.new_vehicle();
        
        tempo t1 = new tempo();
        // t1.v_vehicle(); ----- this is showing the value of vehicle v_vehicle as it is child of vehicle but if it was a child of bike it would have shown the valueof v_vehicle of the bike class
        // t1.v_vehicle(); ----- hierarchical inheritance - single parent(vehicle) multiple children

        dog d1 = new dog();
        // d1.c();
        // d1.h();   ------- this is multiple inheritance using interfaces
        // d1.d();
        // d1.cc();
        
    }
}
