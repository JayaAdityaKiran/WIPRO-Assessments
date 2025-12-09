package Java.Day_2;
import java.util.*;
public class fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a num : ");
        int n = input.nextInt();
        int a = 1;
        int b = 1;
        int answer=0;
        if(n==0 || n==1){
            System.out.println("The answer is 1");
        }else{
            for(int i = 2;i<n;i++){
                answer = a + b;
                a = b;
                b = answer;
            }
        System.out.println("The answer for the series is : "+answer);
        }
    }
}
