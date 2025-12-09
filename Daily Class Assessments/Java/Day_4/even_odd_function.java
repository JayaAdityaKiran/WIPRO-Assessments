package Java.Day_4;
import java.util.*;
public class even_odd_function {

    public static boolean even_odd(int a){
        if(a%2==0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number: ");
        int b = sc.nextInt();
        boolean result = even_odd(b);
        if (result){
            System.out.println("Even\n");
        }else{
            System.out.println("Odd\n");
        }
    }
}
