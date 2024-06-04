import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class user{
    int balance = 50000;
    int PIN = 1456;
}

class bank{
    user u1 = new user();
    Scanner sc = new Scanner(System.in);

    public void deposite(int amount) throws InterruptedException{
        u1.balance = u1.balance + amount;
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\t\tyour Account Baalance is "+u1.balance);
    }

    public void withdrall(int amount) throws InterruptedException{
        if(amount < u1.balance)
        {
            if(amount<=15000)
            {
                System.out.println("\t Cash withdrall ");
                u1.balance-=amount;
                TimeUnit.SECONDS.sleep(2);
                System.out.println("\t your Account Balance is "+u1.balance);                
            }
            else
            {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("\tEnter ammount less than 15000/- RS");
            }
        }
        else
        {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\tInsaficiant Fund ");
        }
    }

    public void checkBalance() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\tYour account balance is "+u1.balance);
    }

    public void changePin(int pass) throws InterruptedException{
        if(pass == u1.PIN)
        {
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\tEnter new pin ");
            pass = sc.nextInt();
            System.err.print("\tRe=enter Your new pin ");
            int pass2 = sc.nextInt();
            TimeUnit.SECONDS.sleep(2);
            if(pass == pass2)
            {
                u1.PIN = pass;
                System.err.println("\t PIN Change Succesfully ");
            }
            else{
                System.out.println("\tSomething went Wrong");
                }
        }
        else{
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\tEnter valid current pin ");
            }
    }

}
public class ATM {
    public static void main(String[] args) throws InterruptedException {
        
        user u1 = new user();
        Scanner sc = new Scanner(System.in);
        bank b1 = new bank();
        System.out.println("\t Welcome to Bank ATM\n");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\t Insert your card ");
        TimeUnit.SECONDS.sleep(2);
        System.out.print("\t Enter your Personal Pin ");
        int pin = sc.nextInt();

        TimeUnit.SECONDS.sleep(2);
        if(pin == u1.PIN){
            while(true){

                System.out.println("\n\t 1. Check Balance\t\t 2. Cash withdrall\n");
                System.out.println("\t 3. Cash Deposite\t\t 4. Chanage PIN\n");
                System.out.println("\t 5. Cancle Transaction\n  ");
                System.out.print("\t Enter Choice ");
                int ch = sc.nextInt();
                TimeUnit.SECONDS.sleep(2);
                switch(ch){
                    case 1:
                        b1.checkBalance();
                        break;

                    case 2:
                        System.out.print("\t Enter amount to withdrall ");
                        int cash = sc.nextInt();
                        b1.withdrall(cash);
                        break;

                    case 3:
                        System.out.print("\t Enter ammount to deoisite ");
                        int amount = sc.nextInt();
                        b1.deposite(amount);
                        break;

                    case 4:
                        System.out.print("\t enter Old pin ");
                        int pass = sc.nextInt();
                        b1.changePin(pass);
                        break;

                    case 5:
                        System.out.println("\tThank you For visit SBI Bank ATM\n\tRemove Your card \n\tVisit again ..!");
                        System.exit(1);
                }
                
            }

        }
        else{
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\tinvalid pin \nvisite again \thank you \n");
        }

    }
}
    