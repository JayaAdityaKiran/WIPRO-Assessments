// Create a BankAccount class with private fields for account holder's name, account number, and balance. Implement methods to deposit and withdraw money with proper validation (e.g., no overdraft, positive amounts only). Provide getters and setters for the account holder's name and account number, but encapsulate the balance to be modified only through deposit and withdraw methods. Include a method to display account details.


package Java.Day_5;
import java.util.*;

class bank_account{
    private String a_name;
    private int a_number;
    public float a_balance;
    // public float deposit;
    // public float withdraw;

    String get_aname(){
        return a_name;
    }
    int get_aNumber(){
        return a_number;
    }
    // float get_aBalance(){
    //     return a_balance;
    // }

    void set_account_details(String a_name,int a_number, float a_balance){
        this.a_name = a_name;
        this.a_number = a_number;
        this.a_balance = a_balance;
    }

    void a_deposit(float num){
        // deposit  = num + deposit;
        System.out.println("Amount Deposited : "+num);
        a_balance = a_balance+num;

    }

    void a_withdraw(float num){
        if (num>a_balance){
            System.out.println("Insufficient Balance");
        }else if(num<0){
            System.out.println("Enter a valid amount");
        }else{
            System.out.println("Amount Withdrew : "+num);
            a_balance = a_balance-num;
        }
    }

    void displayInfo(){
        System.out.println("\nAccount Holder's Name : "+get_aname());
        System.out.println("Account Number : "+get_aNumber());
        System.out.println("Account Balance : "+a_balance);
    }

    void displayScreen(){
        System.out.println("Press 1 to see the Account Details");
        System.out.println("Press 2 to deposit money");
        System.out.println("Press 3 to Withdraw money");
        System.out.println("Press 0 to Exit");
    }
    
}

public class Bank_System {
    public static void main(String[] args) {
        System.out.println("\nWelcome to ATM Machine");
        bank_account b1 = new bank_account();
        b1.set_account_details("Aditya", 7890456, 10000);
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.print("\n");
            b1.displayScreen();
            System.out.print("Enter the number : ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    b1.displayInfo();
                    // System.out.println();
                    // b1.displayScreen();
                    break;

                case 2:
                    System.out.print("\nEnter the amount to be deposited : ");
                    float d = sc.nextFloat();
                    b1.a_deposit(d);
                    // b1.displayScreen();
                    break;

                case 3:
                    System.out.print("\nEnter the amount to be withdrawn : ");
                    float w = sc.nextFloat();
                    b1.a_withdraw(w);
                    // b1.displayScreen();
                    break;

                case 0:
                    System.out.println("\nThank You for Visiting\n");
                    break;

                default:
                    System.out.println("\nPlease Select a valid option");
                    // b1.displayScreen();
                    break;
        }

        }while(option!=0);
        
        // b1.displayInfo();
    }
}
