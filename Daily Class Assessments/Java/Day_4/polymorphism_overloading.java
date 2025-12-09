package Java.Day_4;

public class polymorphism_overloading {

    public int add(int a,int b){
        return a+b;
    }

    public int add(int a,int b, int c){
        return a+b+c;
    }

    public int add(int a){
        return a%2;
    }

    public static void main(String[] args) {
        polymorphism_overloading a1 = new polymorphism_overloading();

        System.out.println(a1.add(10));
        System.out.println(a1.add(2,3,4));
        System.out.println(a1.add(3,4));
        System.out.println(a1.add(5));

    }
}
