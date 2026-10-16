import java.sql.*;
import java.util.*;

public class DynamicSelectJDBC {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            System.out.println("Enter employee ID:");
            String i = sc.nextLine();
            String q = "SELECT * FROM emp WHERE id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, i);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t"
                    + rs.getString(3) + "\t" + rs.getString(4));
            else System.out.println("Record not found");
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
