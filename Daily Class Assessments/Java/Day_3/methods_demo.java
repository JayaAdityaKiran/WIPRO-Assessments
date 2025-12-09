package Java.Day_3;

class Calculator{
    int a;
    int b;
    // Method without parameters and without return
    void greet() {
        System.out.println("Welcome to the Calculator");
        System.out.println("Sum : "+(a+b));
    }

    // Method with parameters and without return
    void add(int a,int b) {
        // System.out.println("Sum : "+(a+b));
        this.a = a;
        this.b = b;
    }

    // Method with multiple parameters and without return
    void hello(String name,String message,int count){ 
        for(int i=0;i<count;i++){
            System.out.println("Hello " + name + ", " + message);
    }
}
    
    // Method with parameters and return type
    int multiply(int x, int y){
        return x*y;
    }

    // Method with parameters and return type
    String getGreetingMessage(String name){
        return "Hello, " + name + "! Welcome to the program.";
    }
}

public class methods_demo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(10, 15);
        calc.greet();
        calc.hello("Alice","Welcome to Java Programming!",3);
        int result = calc.multiply(10, 20);
        System.out.println("Multiplication Result: " + result);
        String message = calc.getGreetingMessage("Bob");
        System.out.println(message);
    }
}
