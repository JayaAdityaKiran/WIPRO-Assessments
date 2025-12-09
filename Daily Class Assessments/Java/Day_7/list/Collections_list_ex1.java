package Java.Day_7.list;
// import java.util.ArrayList;
// import java.util.Collection;
import java.util.*;
public class Collections_list_ex1 {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        System.out.println("\n");

        names.add("Jaya");
        names.add("Aditya");
        names.add("Kiran");
        names.add("SSL");
        System.out.println("Names List : "+names+"\n");

        names.remove(3);
        System.out.println("Names List After removing at index 3 : "+names+"\n");

        System.out.println("Names List Value at index 2 : "+names.get(2)+"\n");
        // System.out.println("Names List : "+names.get(3)+"\n"); ----- out of index
        
        names.set(2,"Tatiparti");
        System.out.println("Updated Names List : "+names+"\n");

        System.out.println("Names List Size : "+names.size()+"\n");

        System.out.println("Check if Jaya is there in names list : "+names.contains("Jaya")+"\n");
        System.out.println("Check if Sai is there in names list : "+names.contains("Sai")+"\n");

        System.out.println("Give the index of value Tatiparti : "+names.indexOf("Tatiparti")+"\n");
        System.out.println("Give the index of value Nikhil which is not present : "+names.indexOf("Nikhil")+"\n");

        names.clear();
        System.out.println("Names List after using names.clear() : "+names+"\n");

    }
}
