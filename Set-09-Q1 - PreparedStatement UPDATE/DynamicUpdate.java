import java.sql.*;
import java.util.*;

public class DynamicUpdate {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            System.out.println("Enter new employee ID, name, department and salary:");
            String i = sc.nextLine(), n = sc.nextLine(), d = sc.nextLine();
            float s = sc.nextFloat();
            sc.nextLine();
            System.out.println("Enter employee ID to update:");
            String w = sc.nextLine();
            String q = "UPDATE emp SET id=?, name=?, dept=?, sal=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, i);
            ps.setString(2, n);
            ps.setString(3, d);
            ps.setFloat(4, s);
            ps.setString(5, w);
            int c = ps.executeUpdate();
            if (c == 1) System.out.println("Record updated");
            else System.out.println("Record not found");
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
