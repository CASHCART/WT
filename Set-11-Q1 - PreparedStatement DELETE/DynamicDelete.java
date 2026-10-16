import java.sql.*;
import java.util.*;

public class DynamicDelete {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            System.out.println("Enter employee ID:");
            String i = sc.nextLine();
            String q = "DELETE FROM emp WHERE id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, i);
            int c = ps.executeUpdate();
            if (c == 1) System.out.println("Record deleted");
            else System.out.println("Record not found");
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
