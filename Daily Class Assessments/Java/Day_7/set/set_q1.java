package Java.Day_7.set;
import java.util.*;
public class set_q1 {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>();
        s1.add(10);
        s1.add(20);
        s1.add(50);
        s1.add(40);
        s1.add(90); 
        s1.add(60);
        s1.add(70);
        System.out.println("\nSet : "+s1);

        System.out.println("Size of Set : "+s1.size());

        s1.remove(10);
        s1.remove(60);
        System.out.println("Set afetr removing 10 and 60 : "+s1);

        System.out.println("Size of Set : "+s1.size());

        System.out.println("To check if 100 is there in the set of not :  "+s1.contains(100));

        s1.clear();
        System.out.println("Set after Clear() : "+s1+"\n");


   }
}
