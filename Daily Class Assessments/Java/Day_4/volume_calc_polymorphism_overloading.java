package Java.Day_4;
import java.math.*;
public class volume_calc_polymorphism_overloading {

    double vol_calc(float l){
        return l*l*l;
    }

    double vol_calc(double r){
        return 4.0/3.0*Math.PI*r*r*r;
    }

    double vol_calc(double h,double r){
        return Math.PI * h * r*r;
    }

    public static void main(String[] args) {
        volume_calc_polymorphism_overloading v  =new volume_calc_polymorphism_overloading();
        System.out.println("\nVolume of cube is : "+v.vol_calc(10, 20));
        System.out.println("Volume of sphere is : "+v.vol_calc(20));
        System.out.println("Volume of cylinder is : "+v.vol_calc(20.5)+"\n");
    }

}
