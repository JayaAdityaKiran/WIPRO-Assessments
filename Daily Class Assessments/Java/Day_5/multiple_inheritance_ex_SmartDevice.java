package Java.Day_5;

interface Camera{
    void clickPhoto();
}

interface Phone{
    void makeCall();
}

class SmartDevice implements Camera,Phone{
    public void clickPhoto(){
        System.out.println("\nPhoto Clicked!");
    }
    public void makeCall(){
        System.out.println("Calling!\n");
    }
}

public class multiple_inheritance_ex_SmartDevice {
    public static void main(String[] args) {
        SmartDevice sd = new SmartDevice();
        sd.clickPhoto();
        sd.makeCall();
    }
}
