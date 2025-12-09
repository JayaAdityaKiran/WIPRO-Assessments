package Java.Day_2;
import java.util.*;
public class odd_even {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a num :");
        int num = input.nextInt();
        if(num%2==0){
            System.out.println("It is an even number.");
        }else{
            System.out.println("It is an odd number.");
        }
    }
    
}
