 package ATMMachine;
import java.util.*;

class ATM{
    float Balance;
    int PIN = 2580;

    public int getpin()
    {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enterdpin = sc.nextInt();
        return enterdpin;
    }
    public void  checkpin() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enterdpin = sc.nextInt();
        if (getpin() == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid pin ");

        }
    }

        public void menu(){
            System.out.println("Enter your choice: ");
            System.out.println("1. Check A/C Balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. deposit Money");
            System.out.println("4. EXIT");

            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();
           switch (opt){
                case1:
                     checkBalance();
                     break;
                 case2:
                      withdrawMoney();
                      break;
               case3:
                      depositMoney();
                      break;
               case4:
               return;
               default:
                   System.out.println("Enter the valide choiced");
           }
        public void checkBalance(){
            System.out.println("Balance: "+Balance);
            menu();
        }
        public void withdrawMoney(){
            System.out.println("Enter Amount to Withdraw: ");
            Scanner sc=new Scanner(System.in);
            float amount = sc.nextFloat();
            if(amount>Balance){
                System.out.println("Insufficient Balance");
            }
            else{
                Balance = Balance-amount;
                System.out.println("Money Withdraw Successful");
            }
            menu();
        }
        public void depositMoney(){
            System.out.println("Enter the Amount");
            Scanner sc= new Scanner(System.in);
            float amount = sc.nextFloat();
            Balance= Balance+amount;
            System.out.println("Money Deposited Successfully");
            menu();
        }
    }
    public class ATMMachine {
    public static void main(String args[]){
        ATM obj= new ATM();
        obj.checkpin();

    }
}
