import java.sql.*;
import java.util.Scanner;

public class ExpenseService {
    static Scanner sc = new Scanner(System.in);

    public static void addExpense() {
        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Description: ");
            String desc = sc.nextLine();

            System.out.print("Enter Total Amount: ");
            double amount = sc.nextDouble();

            System.out.print("Paid By (User ID): ");
            int paidBy = sc.nextInt();

            System.out.print("Number of people to split: ");
            int n = sc.nextInt();

            double splitAmount = amount / n;

            // Insert expense
            String expenseQuery = "INSERT INTO expenses(description, amount, paid_by) VALUES(?,?,?)";
            PreparedStatement expPs = con.prepareStatement(expenseQuery, Statement.RETURN_GENERATED_KEYS);
            expPs.setString(1, desc);
            expPs.setDouble(2, amount);
            expPs.setInt(3, paidBy);
            expPs.executeUpdate();

            ResultSet rs = expPs.getGeneratedKeys();
            rs.next();
            int expenseId = rs.getInt(1);

            // Insert splits
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter User ID who owes: ");
                int userId = sc.nextInt();

                String splitQuery = "INSERT INTO splits(expense_id, user_id, amount_owed) VALUES(?,?,?)";
                PreparedStatement splitPs = con.prepareStatement(splitQuery);
                splitPs.setInt(1, expenseId);
                splitPs.setInt(2, userId);
                splitPs.setDouble(3, splitAmount);
                splitPs.executeUpdate();
            }

            System.out.println("💸 Expense Added & Split Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
