package Java.Day_6;

public class wrapper_class_ex {
    public static void main(String[] args) {
        // int num = 10;
        // Integer w = Integer.valueOf(num); 
        // System.out.println(w + 5); 
        // int un = w.intValue();
        // System.out.println("Unwrapped Integer: " + un);







        

        int num = 10;
        double price = 99.99;
        char grade = 'A';
        boolean isPassed = true;

        // 🔹 Autoboxing (primitive → object)
        Integer numObj = num;         // int → Integer
        Double priceObj = price;      // double → Double
        Character gradeObj = grade;   // char → Character
        Boolean isPassedObj = isPassed; // boolean → Boolean

        System.out.println("=== Autoboxing (Primitive → Wrapper Object) ===");
        System.out.println("Integer object: " + numObj);
        System.out.println("Double object: " + priceObj);
        System.out.println("Character object: " + gradeObj);
        System.out.println("Boolean object: " + isPassedObj);

        // 🔹 Unboxing (object → primitive)
        int num2 = numObj;
        double price2 = priceObj;
        char grade2 = gradeObj;
        boolean isPassed2 = isPassedObj;

        System.out.println("\n=== Unboxing (Wrapper Object → Primitive) ===");
        System.out.println("int value: " + num2);
        System.out.println("double value: " + price2);
        System.out.println("char value: " + grade2);
        System.out.println("boolean value: " + isPassed2);

        // 🔹 Using Wrapper class methods
        System.out.println("\n=== Wrapper Class Utility Methods ===");
        String numStr = "123";
        int parsedNum = Integer.parseInt(numStr); // convert String → int
        double parsedDouble = Double.parseDouble("45.67");

        System.out.println("Parsed int from String: " + parsedNum);
        System.out.println("Parsed double from String: " + parsedDouble);

        // 🔹 Example in Collections (only objects allowed)
        java.util.ArrayList<Integer> numbers = new java.util.ArrayList<>();
        numbers.add(5);   // autoboxing (int → Integer)
        numbers.add(10);
        numbers.add(15);

        System.out.println("\n=== ArrayList Example (Autoboxing & Unboxing) ===");
        for (int n : numbers) {   // unboxing while reading
            System.out.println("Number: " + n);
        }
    }
    
}
