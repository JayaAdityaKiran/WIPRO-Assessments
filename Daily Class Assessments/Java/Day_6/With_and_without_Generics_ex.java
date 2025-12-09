
// Create a class Box that can store a single item. You want to store items in the box and retrieve them later. Test it with different types like Integer and String. Without Generics and with Generics.

package Java.Day_6;

// ---------- WITHOUT GENERICS ----------
class BoxWithoutGenerics {
    private Object item; // Can hold anything

    public void setItem(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }
}

// ---------- WITH GENERICS ----------
class Box<T> {
    private T item; // Type-safe

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

// ---------- MAIN CLASS ----------
public class With_and_without_Generics_ex {
    public static void main(String[] args) {
        System.out.println("\n=== Without Generics ===");
        BoxWithoutGenerics box1 = new BoxWithoutGenerics();
        box1.setItem("Hello World"); // Storing String
        System.out.println("Box1 item: " + box1.getItem());

        BoxWithoutGenerics box2 = new BoxWithoutGenerics();
        box2.setItem(123); // Storing Integer
        System.out.println("Box2 item: " + box2.getItem());

        // ❌ Requires casting and can cause runtime errors
        String text = (String) box1.getItem(); // Works
        System.out.println("Casted String: " + text);
        // int num = (int) box1.getItem(); // ❌ Would cause ClassCastException

        System.out.println("\n=== With Generics ===");
        Box<Integer> intBox = new Box<>();
        intBox.setItem(42);
        System.out.println("Integer Box item: " + intBox.getItem());

        Box<String> strBox = new Box<>();
        strBox.setItem("Generics in Java");
        System.out.println("String Box item: " + strBox.getItem());

        // ✅ Type-safe — no casting needed
        String message = strBox.getItem();
        System.out.println("Retrieved message: " + message+"\n");

        // ❌ Compile-time error if you try to store wrong type
        // strBox.setItem(123); // Not allowed

    }
}

// Sir's Code

// // Box class without generics
// class Box {
//     private Object item;  

    
//     public void setItem(Object item) {
//         this.item = item;
//     }

    
//     public Object getItem() {
//         return item;
//     }
// }


// public class Main {
//     public static void main(String[] args) {

        
//         Box intBox = new Box();
//         intBox.setItem(123);  // Autoboxing Integer # Object is class which is inheriting String, 

        
//         Box strBox = new Box();
//         strBox.setItem("Hello");

        
//         Integer num = (Integer) intBox.getItem();  
//         String str = (String) strBox.getItem();   

        
//         System.out.println("Integer: " + num);
//         System.out.println("String: " + str);
//         String wrong = (String) intBox.getItem();  
        

//         // String wrong = (String) intBox.getItem();  // ClassCastException
//     }
// }







// Another Code

// With generics

// package Day6;
// class Box<T> {
//     T value;
//     Box(T value) {
//         this.value = value;
//     }
//     void show() {
//         System.out.println("Value: " + value);
//     }
// }
// public class GenericsDemo {
//      public static void main(String[] args) {
//         Box<String> box1 = new Box<>("Hello Generics");
//         box1.show();
//         Box<Double> box2 = new Box<>(12.5);
//         box2.show();
//         Box<Integer> box3 = new Box<>(12);
//         box3.show();
//     }
// }


// without generics

// package Day6;
// class Box1{
//     String value;
    
//     Box1(String value){
//         this.value=value;
//     }
//     void show() {
//         System.out.println("Value: " + value);
//     }  
// }
// class Box2{
//     int value;
//     Box2(int value){
//         this.value=value;
//     }
//     void show() {
//         System.out.println("Value: " + value);
//     }
// }
// public class withoutGenric {
//     public static void main(String[] args) {
//         Box1 b = new Box1("ABC");
//         b.show();
//         Box2 b2 = new Box2(12);
//         b2.show();
//     }
// }









// Another Code

// public class Box {
//     public static void main(String[] args) {
//         Store<Integer> s1 = new Store<>(123); // Generic
//         Store<String> s2 = new Store<>("Biscuit");
//         s1.print();
//         s2.print();

//         Int_Box i = new Int_Box(44); // w/o generic
//         i.print();

//         String_Box s = new String_Box("Honey");
//         s.print();
//     }
// }

// class Store<T> {
//     T varia;

//     Store(T tostore) {
//         varia = tostore;
//     }

//     void print() {
//         System.out.println("It stored : " + varia);
//     }
// }

// class Int_Box {
//     int item;

//     Int_Box(int i) {
//         item = i;
//     }

//     void print() {
//         System.out.println("It stored : " + item);
//     }
// }

// class String_Box {
//     String item;

//     String_Box(String i) {
//         item = i;
//     }

//     void print() {
//         System.out.println("It stored : " + item);
//     }
// }