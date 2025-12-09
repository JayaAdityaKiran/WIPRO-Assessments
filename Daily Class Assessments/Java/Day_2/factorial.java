package Java.Day_2;
import java.util.*;
public class factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a num : ");
        int n = input.nextInt();
        long fact=1;
        for(int i=1;i<=n;i++){
            fact = fact*i;
        }
        System.out.println("Factorial of "+n+" = "+fact);
    }
}
