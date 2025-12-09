package Java.Day_4;


class car{
    private String c_name = "BMW";
    public int year = 2016;

    // public car(String c_name,int year){
    //     this.c_name = c_name;
    //     this.year = year;
    // }

    void displayInfo(){
        System.out.println("\nCar Name : "+c_name);
        System.out.println("Year : "+year+"\n");
    }
}
public class encapsulation_car_ex {
    public static void main(String[] args) {
        car c1 = new car();
        c1.displayInfo();
        // ----- can only see c1.year but not c1.c_name
    }
}