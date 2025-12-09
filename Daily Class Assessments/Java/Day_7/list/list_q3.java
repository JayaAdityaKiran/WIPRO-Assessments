package Java.Day_7.list;
import java.util.*;
public class list_q3 {
    public static void main(String[] args) {
        ArrayList<String> w_list = new ArrayList<>();
        w_list.add("Java");
        w_list.add("is");
        w_list.add("fun");
        System.out.println("\nList : "+w_list);

        ArrayList<String> reverse_w_list = new ArrayList<>();
        for(int i = w_list.size()-1;i>=0;i--){
            String word = w_list.get(i);
            String reverse_word = new StringBuilder(word).reverse().toString();
            reverse_w_list.add(reverse_word);
        }
        System.out.println("Reverse List as well as the value in it : "+reverse_w_list+"\n");
    }
}
