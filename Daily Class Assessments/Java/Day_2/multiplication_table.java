package Java.Day_2;
import java.util.*;
public class multiplication_table {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = input.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(num+" x "+i+" = "+num*i);
        }
    }
}
