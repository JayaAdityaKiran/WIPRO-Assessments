package Java.Day_2;
import java.util.*;
public class leap_year {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an Year : ");
        int num = input.nextInt();
        if(num % 4 == 0){

            if(num % 100 != 0){
                System.out.println("It is a Leap year.");
            }else{
                if(num % 400 != 0){
                    System.out.println("It is not a Leap year.");
                }else if(num % 400 == 0){
                    System.out.println("It is a Leap year.");
                }
            
            }
        }else{
            System.out.println("It is not a Leap year");
        }

    }
}
