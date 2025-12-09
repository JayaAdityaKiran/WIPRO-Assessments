package Java.Day_2;
import java.util.*;
public class reverse_num {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a num : ");
        int n = input.nextInt();
        int reverse_n = 0;
        int remain;
        while(n>0){
            remain = n%10;
            reverse_n = reverse_n*10+remain;
            n = n/10;
        }
        System.out.println("The reversed number is : "+reverse_n);
    }
}
