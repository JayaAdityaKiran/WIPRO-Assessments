package Java.Day_7.list;
import java.util.*;
public class list_q5 {
    public static void main(String[] args) {
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(3);
        num1.add(5);
        num1.add(7);
        num1.add(5);
        System.out.println("\nList 1 : "+num1);
        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(2);
        num2.add(7);
        num2.add(8);
        num2.add(3);
        System.out.println("List 2 : "+num2);
        ArrayList<Integer> num_merged = new ArrayList<>();
        num_merged.addAll(num1);
        num_merged.addAll(num2);
        System.out.println("Merged List with duplicate values : "+num_merged);
        ArrayList<Integer> num_merged_new = new ArrayList<>();

        for(int i : num_merged){
            if(!num_merged_new.contains(i)){
                num_merged_new.add(i);
            }
        }
        System.out.println("Merged Unsorted List : "+num_merged_new);
        num_merged_new.sort(null);
        System.out.println("Merged Sorted List : "+num_merged_new+"\n");
    }
}
