package Java.Day_4;
// import java.util.*;
public class factorial_function {
    public static long fact(int a){
        int f = 1;
        for(int i=a;i>0;i--){
            f = f*i;
        }
        return f;
    }
    public static void main(String[] args) {
        long num = fact(7);
        System.out.println("Factorial is : "+num);
    }
}
