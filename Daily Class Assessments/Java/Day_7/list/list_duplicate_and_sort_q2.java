package Java.Day_7.list;
import java.util.*;

public class list_duplicate_and_sort_q2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(30);
        nums.add(20);
        nums.add(20);
        nums.add(10);
        nums.add(30);
        nums.add(20);
        nums.add(40);
        System.out.println("\nList before removing duplicate values : "+nums);
        ArrayList<Integer> result_nums = new ArrayList<>();
        for(Integer i: nums){
            if (!result_nums.contains(i)){
                result_nums.add(i);
            }
        } 
        System.out.println("List after removing duplicate values : "+result_nums);
        result_nums.sort(null);
        System.out.println("List after being sorted in ascending order : "+result_nums);
        // or  Collections.sort(result_nums); ----- both are used for ascending sort order

        result_nums.sort(Collections.reverseOrder());
        // or Collections.sort(result_nums,Collections.reverseOrder()); ------ both are used for descending sort order
        System.out.println("List after being sorted in ascending order : "+result_nums+"\n");
    }
}
