package Java.Day_2;
import java.util.*;
public class strings {
    public static void main(String[] args) {
    
        String s = "Hello world";
        String s1 = "Hello";
        String s2 = "World";
        System.out.println(s);
        System.out.println(s1 + s2);
        System.out.println(s.charAt(4)); //find character
        System.out.println(s.indexOf("l")); // find 1st occurance index of char
        System.out.println(s.lastIndexOf("l")); // find the last occurance of char
        System.out.println(s.substring(2, 5)); // a part of a string
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.length());
    }
}
