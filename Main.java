import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Expense Splitter ====");
            System.out.println("1. Add User");
            System.out.println("2. Add Expense");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    UserService.addUser();
                    break;
                case 2:
                    ExpenseService.addExpense();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
