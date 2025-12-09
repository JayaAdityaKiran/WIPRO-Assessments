package Java.Day_2;
import java.util.*;
public class largest_of_3_nos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a num : ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        if (n1>n2 && n1>n3){
            System.out.println(n1 + " is the largest number.");
        }else if(n2>n1 && n2>n3){
            System.out.println(n2 + " is the largest number.");
        }else{
             System.out.println(n3 + " is the largest number.");
        }
    }
}
