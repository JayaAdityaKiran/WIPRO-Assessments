package Java.Day_7.list;

import java.util.ArrayList;
import java.util.Collections;

public class list_q4 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(50);
        nums.add(70);
        nums.add(20);
        nums.add(100);
        nums.add(79);

        System.out.println("\nList : "+nums);
        nums.sort(Collections.reverseOrder());
        System.out.println("Second Largest Number in the list is : "+nums.get(1)+"\n");
    }
}
