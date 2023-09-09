import java.util.Scanner;

 public class Main{

    public static void main(String[] args){

    AtmInterface ai= new Implement();

    try (Scanner sc = new Scanner(System.in)) {
        System.out.println("********************************************");
        System.out.println("       WELCOME TO THE ATM MACHINE");
        System.out.println("********************************************");

        int id, pin;

        do {
            System.out.print("Enter your user ID: ");
            id = sc.nextInt();
            System.out.print("Enter your user Pin: ");
            pin = sc.nextInt();
            if (!check_id_pin(id, pin)) {
                System.out.println("Invalid User ID or Pin. Please try again.");
            }
        } while (!check_id_pin(id, pin));

        while (true) {
            System.out.println("\n********************************************");
            System.out.println("            MAIN MENU");
            System.out.println("********************************************");
            System.out.println("1. View Available Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    ai.viewBalance();
                    break;

                case 2:
                    System.out.print("Enter Amount To Withdraw: $");
                    double withdrawAmount = sc.nextDouble();
                    sc.nextLine(); // Consume the newline character
                    ai.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter Amount To Deposit: $");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine(); // Consume the newline character
                    ai.deposit(depositAmount);
                    break;

                case 4:
                    System.out.print("Enter Transaction ID: ");
                    int tranID = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    if (tranID == 5678) {
                        System.out.print("Enter Amount To Transfer: $");
                        double transferAmount = sc.nextDouble();
                        sc.nextLine(); // Consume the newline character
                        ai.transfer(transferAmount);
                        System.out.println("SUCCESSFULLY TRANSFERRED AMOUNT TO " + tranID);
                        ai.viewBalance();
                    } else {
                        System.out.println("Invalid Transaction ID.");
                    }
                    break;

                case 5:
                    ai.transactionHistory();
                    break;

                case 6:
                    System.out.println("COLLECT YOUR ATM CARD\nTHANK YOU FOR USING THE ATM MACHINE.");
                    System.exit(0);
                    break;
                    default:
                    System.out.println("Invalid choice. Please try again.");
                    break;  
            }
            }
        
       
    }

    }


    public static boolean check_id_pin(int id,int pin)
    {
        if(id==12345 && pin==54321)
        {
        return true;
        }
        else
        {
        return false;
        }
    }

      
}