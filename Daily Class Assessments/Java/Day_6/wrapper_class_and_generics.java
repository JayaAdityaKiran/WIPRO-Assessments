package Java.Day_6; 
public class wrapper_class_and_generics {
    public static void main(String[] args) {
        Printer<Integer> p1 = new Printer<>(12);
        p1.print();
        Printer<String> p2 = new Printer<>("Done");
        // Printer<Double> 
        p2.print();

        shout(111);
        shout("yeh");
        explain("null",222 );
    }
    static <Gen> void shout(Gen toShout){
    System.out.println(toShout + "!!!");
    }

    static <Gen,Otr,mm> void explain(Gen toShout,Otr toexplain){ 
    System.out.println(toShout + "!!!" + "... " + toexplain);
    }

    static <Gen> Gen rtn(Gen toShout){
    return toShout;
    }
}

class Printer <T> {
    T varia;

    Printer(T thingToPrint) {
        varia = thingToPrint;
    }

    void print() {
        System.out.println(varia);
    }
}