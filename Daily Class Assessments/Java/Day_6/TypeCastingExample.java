package Java.Day_6;

public class TypeCastingExample {
    public static void main(String[] args) {

        // -----------------------------
        // 🌟 1. Primitive Type Casting
        // -----------------------------

        // ✅ Implicit Casting (Widening)
        // small → large data type (no data loss)
        int intNum = 10;
        double doubleNum = intNum; // int → double automatically
        System.out.println("\nImplicit Casting (int to double): " + doubleNum);

        // ✅ Explicit Casting (Narrowing)
        // large → small data type (possible data loss)
        double bigDouble = 99.99;
        int smallInt = (int) bigDouble; // need explicit cast
        System.out.println("Explicit Casting (double to int): " + smallInt+"\n");

        // -----------------------------------------------------
        // 🌟 2. Non-Primitive Type Casting (Object Casting)
        // -----------------------------------------------------

        // Parent class
        class Animal {
            void sound() {
                System.out.println("Animal makes a sound");
            }
        }

        // Child class
        class Dog extends Animal {
            void sound() {
                System.out.println("Dog barks");
            }
            void fetch() {
                System.out.println("Dog fetches the ball");
            }
        }

        // ✅ Upcasting (Implicit — child → parent)
        Animal a = new Dog();  // Dog object, but reference type Animal
        a.sound(); // Dog’s version (because of overriding)

        // ❌ a.fetch(); // Not allowed — Animal reference doesn’t know Dog methods

        // ✅ Downcasting (Explicit — parent → child)
        Dog d = (Dog) a; // we are telling compiler to treat 'a' as Dog
        d.sound(); // still Dog’s version
        d.fetch(); // now works

        // ⚠️ Unsafe Downcasting Example
        Animal a2 = new Animal();
        // Dog d2 = (Dog) a2; // ❌ Runtime error (ClassCastException)
        // d2.sound();

        System.out.println("\nCasting demo complete");



    }
        //     class Phone {
        //     void call() {
        //         System.out.println("Calling");
        //     }
        // }

        // class SmartPhone extends Phone {
        //     void useInternet() {
        //         System.out.println("Using Internet");
        //     }
        // }

        // public class Smart {
        //     public static void main(String[] args) {
                
        //         Phone p = new SmartPhone();
        //         p.call(); 

            
        //         SmartPhone sp = (SmartPhone) p;
        //         sp.useInternet(); 
        // }
        // }
}
