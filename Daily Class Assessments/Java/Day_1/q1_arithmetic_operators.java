import java.util.Scanner;

    
public class q1_arithmetic_operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();
        int product = num1 * num2;
        int sum = num1+num2;
        int sub , q, r;

        if(num1 > num2)
        {sub = num1-num2;
        q = num1/num2;
        r = num1%num2;}
        
        else
        {sub = num2-num1;
        q = num2/num1;
        r = num2%num1;}

        System.out.println("Sum: "+sum);
        System.out.println("Difference: "+sub);
        System.out.println("Product: "+product);
        System.out.println("Quotient: "+q);
        System.out.println("Remainder: "+r);
        
        scanner.close();
    }
}
