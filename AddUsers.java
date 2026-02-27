import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserService {
    static Scanner sc = new Scanner(System.in);

    public static void addUser() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter User Name: ");
            String name = sc.nextLine();

            String query = "INSERT INTO users(name) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("✅ User Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
